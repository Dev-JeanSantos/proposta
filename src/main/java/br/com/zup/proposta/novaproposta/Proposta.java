package br.com.zup.proposta.novaproposta;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Proposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	private @NotBlank String documento;
	private @NotBlank @Email String email;
	private @NotNull @Positive BigDecimal salario;
	private @NotNull @Valid EnderecoRequest endereco;

	public Proposta(@NotBlank String nome, @NotBlank String documento, @NotBlank @Email String email,
			@NotNull @Positive BigDecimal salario, @NotNull @Valid EnderecoRequest endereco) {
				this.nome = nome;
				this.documento = documento;
				this.email = email;
				this.salario = salario;
				this.endereco = endereco;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Proposta [nome=" + nome + ", documento=" + documento + ", email=" + email + ", salario=" + salario
				+ ", endereco=" + endereco + "]";
	}

}
