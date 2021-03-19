package br.com.zup.proposta.novaproposta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusProposta status = StatusProposta.NÃO_ELEGÍVEL;
	@Column(nullable = false)
	private LocalDateTime updateDate = LocalDateTime.now();
	
	private String cartao;
	
	@Deprecated
	public Proposta() {
		
	}
	

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
	public StatusProposta getStatus() {
		return status;
	}
	public String getNome() {
		return nome;
	}
	public String getDocumento() {
		return documento;
	}
	
	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}


	@Override
	public String toString() {
		return "Proposta [id=" + id + ", nome=" + nome + ", documento=" + documento + ", email=" + email + ", salario="
				+ salario + ", endereco=" + endereco + ", status=" + status + "]";
	}


	public void atualizacaoStatus(StatusProposta status) {
		
		this.status = status;
		this.updateDate  = LocalDateTime.now();
		
	}

}
