package br.com.zup.proposta.logs;
//package br.com.zup.proposta;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import br.com.zup.proposta.cartao.CartaoRepository;
//import br.com.zup.proposta.cartao.GetPropostaCliente;
//import br.com.zup.proposta.novaproposta.Proposta;
//import br.com.zup.proposta.novaproposta.PropostaRepository;
//import br.com.zup.proposta.novaproposta.StatusProposta;
//
//public class LogsCartoes {
//
//	@Autowired
//	private PropostaRepository repository;
//
//	@Autowired
//	private CartaoRepository cartaoRepository;
//	
//	@Autowired
//	private GetPropostaCliente client;
//
//	private  final Logger logger  =  LoggerFactory.getLogger(LogsCartoes.class);
//	
//	@Scheduled(fixedDelayString= "${periodicidade.avalia-cartao}")
//    private void avaliaCartoes() {
//        List<Proposta> propostas = repository.findByStatusAndCartao(StatusProposta.ELEGIVEL,null);
//        if(!propostas.isEmpty()){
//            propostas.stream().forEach(this::SaveCartaoId);
//        }
//   }
//	 
//	 
