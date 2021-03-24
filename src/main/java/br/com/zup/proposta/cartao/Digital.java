package br.com.zup.proposta.cartao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Digital {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime criadoEm = LocalDateTime.now();
    @NotBlank
    private String idCartao;
    @NotBlank
    private String biometria;
	
    @Deprecated
    public Digital() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Digital(@NotBlank String idCartao, @NotBlank String biometria) {
		super();
		this.idCartao = idCartao;
		this.biometria = biometria;
	}
	@Override
	public String toString() {
		return "Digital [id=" + id + ", criadoEm=" + criadoEm + ", idCartao=" + idCartao + ", biometria=" + biometria
				+ "]";
	}
	public Long getId() {
		return id;
	}   
    
}
