package br.com.zup.proposta.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8888/api", name = "getProposta")
public interface GetPropostaCliente {
	
	@GetMapping("/cartoes")
	public FormPropostaResponse response(@RequestParam(name = "idProposta") Long idProposta);

}

