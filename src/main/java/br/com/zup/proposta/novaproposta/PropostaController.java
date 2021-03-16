package br.com.zup.proposta.novaproposta;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Proposta> criar(@RequestBody @Valid PropostaRequest request) {
		
		Proposta proposta = request.toModel();
		manager.persist(proposta);
		
		//Assert.isTrue(proposta != null, "Há um erro em sua proposta!");
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(proposta.getId()).toUri();
		
		return ResponseEntity.created(uri).build();

	}

}
