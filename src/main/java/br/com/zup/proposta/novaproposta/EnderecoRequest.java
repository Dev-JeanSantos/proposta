package br.com.zup.proposta.novaproposta;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class EnderecoRequest {
	
	@NotBlank
	String logradouro;
	@NotBlank
	String bairro;
	@NotBlank
	String cidade;
	@NotBlank
	String numero;
	@NotBlank
	String cep;
	
	@Deprecated
	public EnderecoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnderecoRequest(@NotBlank String logradouro, @NotBlank String bairro, @NotBlank String cidade,
			@NotBlank String numero, @NotBlank String cep) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "EnderecoRequest [logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade + ", numero="
				+ numero + ", cep=" + cep + "]";
	}
}
