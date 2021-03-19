package br.com.zup.proposta.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class FormPropostaResponse {
	
	private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private List<?> bloqueios;
    private List<?> avisos;
    private List<?> carteiras;
    private List<?> parcelas;
    private BigDecimal limite;
    private String renegociacao;
    private Vencimento vencimento;
    private Long idProposta;
	
    @Deprecated
    public FormPropostaResponse() {
		
	}

	public FormPropostaResponse(String id, LocalDateTime emitidoEm, String titular, List<?> bloqueios, List<?> avisos,
			List<?> carteiras, List<?> parcelas, BigDecimal limite, String renegociacao, Vencimento vencimento,
			Long idProposta) {
		super();
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.bloqueios = bloqueios;
		this.avisos = avisos;
		this.carteiras = carteiras;
		this.parcelas = parcelas;
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.idProposta = idProposta;
	}


	public String getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public List<?> getBloqueios() {
		return bloqueios;
	}

	public List<?> getAvisos() {
		return avisos;
	}

	public List<?> getCarteiras() {
		return carteiras;
	}

	public List<?> getParcelas() {
		return parcelas;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public String getRenegociacao() {
		return renegociacao;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	@Override
	public String toString() {
		return "FormPropostaResponse [id=" + id + ", emitidoEm=" + emitidoEm + ", titular=" + titular + ", bloqueios="
				+ bloqueios + ", avisos=" + avisos + ", carteiras=" + carteiras + ", parcelas=" + parcelas + ", limite="
				+ limite + ", renegociacao=" + renegociacao + ", vencimento=" + vencimento + ", idProposta="
				+ idProposta + "]";
	}
 
}
