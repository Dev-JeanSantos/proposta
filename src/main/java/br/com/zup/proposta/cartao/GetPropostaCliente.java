package br.com.zup.proposta.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${analiseCartao.targetUrl}", name =  "solicitacao")
public interface GetPropostaCliente {
	
	@GetMapping("/api/cartoes")
	public FormPropostaResponse response(@RequestParam(name = "idProposta") Long idProposta);

}

