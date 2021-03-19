package br.com.zup.proposta.cartao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zup.proposta.novaproposta.Proposta;
import br.com.zup.proposta.novaproposta.PropostaRepository;
import br.com.zup.proposta.novaproposta.StatusProposta;

@Component
public class AvaliacaoPropostaCartao {

	@Autowired
	private GetPropostaCliente cliente;

	@Autowired
	private PropostaRepository repository;

	private final Logger logger = LoggerFactory.getLogger(AvaliacaoPropostaCartao.class);
	
	@Scheduled(fixedDelayString= "${tempo_avaliar_cartao}")
	private void analisaCartoes() {
		
		List<Proposta> propostas = repository.findByStatusAndCartao(StatusProposta.ELEGÍVEL, null);
		
		  if(!propostas.isEmpty()){
	            propostas.stream().forEach(this::getCartaoId);
	        }
	}

	public void getCartaoId(Proposta proposta) {
		FormPropostaResponse response = cliente.response(proposta.getId());
		proposta.setCartao(response.getId());
		repository.save(proposta);
		logger.info("Atualização de cadastro para o id " + proposta.getId() + " gerada com sucesso");
	}
}
