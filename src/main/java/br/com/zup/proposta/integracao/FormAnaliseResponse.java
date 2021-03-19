package br.com.zup.proposta.integracao;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.proposta.novaproposta.StatusProposta;

public class FormAnaliseResponse {
	
	private String idProposta;
	
	@JsonProperty("resultadoSolicitacao")
	private String status;

	public String getIdProposta() {
		return idProposta;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "FormAnaliseResponse [idProposta=" + idProposta + ", status=" + status + "]";
	}

	public StatusProposta toModelStatus() {
		
		if("COM_RESTRICAO".equals(status)) {
			
			return StatusProposta.NÃO_ELEGÍVEL;
		}
		
		return  StatusProposta.ELEGÍVEL;
	}
	
}
