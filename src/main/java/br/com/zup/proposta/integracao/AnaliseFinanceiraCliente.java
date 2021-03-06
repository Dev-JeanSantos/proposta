package br.com.zup.proposta.integracao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(url = "${analiseFinanceiraCliente.targetUrl}", name =  "AnaliseFinanceiraCliente")
public interface AnaliseFinanceiraCliente {
	
	@PostMapping("/api/solicitacao")
	public FormAnaliseResponse formAnalise(@RequestBody FormAnaliseRequest request);
}