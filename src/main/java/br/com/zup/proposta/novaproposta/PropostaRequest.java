package br.com.zup.proposta.novaproposta;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.proposta.validacoes.CpfOuCnpj;

/**
 * @author Jean
 *
 */
public class PropostaRequest {
	@NotBlank
	@CpfOuCnpj
	String documento;
	@NotBlank
	@Email
	String email;
	@NotBlank
	String nome;
	@NotNull
	@Valid
	EnderecoRequest endereco;
	@NotNull
	@Positive
	BigDecimal salario;
	
	public PropostaRequest(@NotBlank String documento, @NotBlank @Email String email, @NotBlank String nome,
			EnderecoRequest endereco, @NotNull @Positive BigDecimal salario) {
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "PropostaRequest [nome=" + nome + ", documento=" + documento + ", email=" + email + ", salario="
				+ salario + ", endereco=" + endereco + "]";
	}

	public Proposta toModel() {
		
		return new Proposta(nome, documento, email, salario, endereco);
	}
}
