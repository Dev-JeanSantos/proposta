package br.com.zup.proposta.validacoes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zup.proposta.excecoes.ExcecaoParaDocumentosDuplicados;

@RestControllerAdvice
public class ValidationErrorHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FormErros> handle(MethodArgumentNotValidException exception) {
		List<FormErros> erros = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			int status = HttpStatus.BAD_REQUEST.value();
			LocalDateTime time = LocalDateTime.now();
			FormErros erro = new FormErros(e.getField(), mensagem, status, time);
			erros.add(erro);
		});
		return erros;
	}

	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(ExcecaoParaDocumentosDuplicados.class)
	public FormErros duplicateDocument(ExcecaoParaDocumentosDuplicados exception) {
		LocalDateTime time = LocalDateTime.now();
		FormErros dto = new FormErros("Documentos - CPF ou CNPJ", "Já existe uma proposta com esse mesmo documento no sistema", 422, time);
		return dto;
	}
		
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BiometriaException.class)
    public FormErros fingerPrintInvalidEncode(BiometriaException exception) {
        LocalDateTime time = LocalDateTime.now();
        FormErros dto = new FormErros("fingerprint","Base64 Encode inválido",400,time);
        return dto;
    }
	

}
