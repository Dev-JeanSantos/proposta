package br.com.zup.proposta.cartao;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.proposta.validacoes.BiometriaException;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

	@Autowired
	private CartaoRepository repository;

	@PostMapping("/{idCartao}")
	public ResponseEntity<?> cadastrarBiometria(@PathVariable("idCartao") String idCartao,
			@RequestBody @Valid BiometriaRequest request, UriComponentsBuilder response) throws BiometriaException {

		request.isValid();

		if (!repository.existsById(idCartao)) {
			return ResponseEntity.notFound().build();
		}

		Long digitalID = request.salvaDigital(repository, idCartao);

		Assert.notNull(digitalID, "Falha ao recuperar informações de biometria");

		URI location = response.path("api/cartoes/"+idCartao+"/biometria/{id}").buildAndExpand(digitalID).toUri();
        return ResponseEntity.created(location).build();
	}
}
