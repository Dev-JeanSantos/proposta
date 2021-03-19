package br.com.zup.proposta.integracao;

import br.com.zup.proposta.novaproposta.Proposta;

public class FormAnaliseRequest {
	
	private String nome;
	private String documento;
	private String IdProposta;
	
	
	public FormAnaliseRequest(Proposta proposta) {
		this.nome = proposta.getNome();
		this.documento = proposta.getDocumento();
		this.IdProposta = proposta.getId().toString();
	}
	
	public String getNome() {
		return nome;
	}
	public String getDocumento() {
		return documento;
	}
	public String getIdProposta() {
		return IdProposta;
	}
	@Override
	public String toString() {
		return "FormAnaliseRequest [nome=" + nome + ", documento=" + documento + ", IdProposta=" + IdProposta + "]";
	}
	
}
