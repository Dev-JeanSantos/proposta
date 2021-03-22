package br.com.zup.proposta.novaproposta;

import java.util.Locale;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PropostaResponse {

	@NotNull
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String documento;
	@NotNull
	private StatusProposta status;
	
	public PropostaResponse(@Valid Proposta entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.documento = ocultaDocumento(entity.getDocumento());
		this.status = entity.getStatus();
	}
	
	
	private String ocultaDocumento(String documento){
        String retorno = documento.trim().toLowerCase(Locale.ROOT).split("//")[0].replaceAll("\\D","");

        if(retorno.length() == 11){
            return  "***.***.***-" + retorno.substring(9,11);
        }else {
            return "**.***.***/****-" + retorno.substring(12,14);
        }

    }


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getDocumento() {
		return documento;
	}


	public StatusProposta getStatus() {
		return status;
	}
	
}
