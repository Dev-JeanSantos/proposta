package br.com.zup.proposta.novaproposta;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.proposta.excecoes.ExcecaoParaDocumentosDuplicados;
import br.com.zup.proposta.integracao.AnaliseFinanceiraCliente;
import br.com.zup.proposta.integracao.FormAnaliseRequest;
import br.com.zup.proposta.integracao.FormAnaliseResponse;
import feign.FeignException;



@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	@Autowired
	private AnaliseFinanceiraCliente analise;
	
	@Autowired
	private PropostaRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Proposta> criar(@RequestBody @Valid PropostaRequest request) throws ExcecaoParaDocumentosDuplicados {
		
		Proposta proposta = request.toModel(repository);
		repository.save(proposta);
		
		Assert.isTrue(proposta != null, "Há um erro em sua proposta!");
		
		FormAnaliseRequest formReq = new FormAnaliseRequest(proposta);
		StatusProposta status = null;
		
		try {
			FormAnaliseResponse formRes = analise.formAnalise(formReq);
			status = formRes.toModelStatus();
		} catch (FeignException.UnprocessableEntity e) {
			status = StatusProposta.NÃO_ELEGÍVEL;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Um erro inesperado ocorreu!");
		}
		
		
		proposta.atualizacaoStatus(status);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(proposta.getId()).toUri();
		
		return ResponseEntity.created(uri).build();

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscaPropostaPorId(@PathVariable("id") Long id) {
		Optional<Proposta> proposta = repository.findById(id);
		
		if(proposta.isPresent()) {
			
			PropostaResponse resp =  new PropostaResponse(proposta.get());
			Assert.notNull(resp,"Erro ao retornar dados da proposta");
			return ResponseEntity.ok(resp);
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
