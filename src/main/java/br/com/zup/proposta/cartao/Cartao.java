package br.com.zup.proposta.cartao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cartao {
	
	@Id
	private String idCartao;
	
	@NotNull
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@NotBlank
	private String Biometria;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "idCartao")
    private List<Digital> digitais = new ArrayList<>();
	
	@Deprecated
	public Cartao() {
		
	}

	public String getIdCartao() {
		return idCartao;
	}

	public Cartao(@NotBlank String idCartao, @NotBlank String biometria) {
		super();
		this.idCartao = idCartao;
		Biometria = biometria;
	}

	public List<Digital> getDigitais() {
		return digitais;
	}

	public void setDigitais(Digital digital) {
		digitais.add(digital);
	}

}
