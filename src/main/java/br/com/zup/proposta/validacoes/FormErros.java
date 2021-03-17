package br.com.zup.proposta.validacoes;

import java.time.LocalDateTime;

public class FormErros {
	
	private String field;
    private String error;
    private int status;
    private LocalDateTime timeStamp;
	
    public FormErros(String field, String error, int status, LocalDateTime timeStamp) {
		super();
		this.field = field;
		this.error = error;
		this.status = status;
		this.timeStamp = timeStamp;
	}

	public String getField() {
		return field;
	}

	public String getError() {
		return error;
	}

	public int getStatus() {
		return status;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}   
    
}
