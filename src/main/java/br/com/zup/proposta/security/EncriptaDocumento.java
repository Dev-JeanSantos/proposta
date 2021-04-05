package br.com.zup.proposta.security;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class EncriptaDocumento {

	private String key = "pa55word";
	private String salt = "1A123AB293";

	public  String processa(String documento){
        TextEncryptor encryptor = Encryptors.queryableText(key,salt);
        String documentoEncript = encryptor.encrypt(documento);
        return documentoEncript;
    }
}