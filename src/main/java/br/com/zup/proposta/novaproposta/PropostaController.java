package br.com.zup.proposta.novaproposta;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.proposta.excecoes.ExcecaoParaDocumentosDuplicados;



@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	@Autowired
	private PropostaRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Proposta> criar(@RequestBody @Valid PropostaRequest request) throws ExcecaoParaDocumentosDuplicados {
		
		Proposta proposta = request.toModel(repository);
		repository.save(proposta);
		
		Assert.isTrue(proposta != null, "Há um erro em sua proposta!");
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(proposta.getId()).toUri();
		
		return ResponseEntity.created(uri).build();

	}
	
}
