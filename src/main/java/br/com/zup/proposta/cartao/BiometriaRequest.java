package br.com.zup.proposta.cartao;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.util.Assert;

import br.com.zup.proposta.validacoes.BiometriaException;

/**
 * @author Jean
 *
 */
public class BiometriaRequest {
	
	@NotBlank
	private String biometria;

	@Deprecated
	public BiometriaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BiometriaRequest(@NotBlank String biometria) {
	
		this.biometria = biometria;
	}

	public String getBiometria() {
		return biometria;
	}
	
	public Boolean isValid() throws BiometriaException {
        try{
            byte[] decode = Base64.getDecoder().decode(biometria.getBytes());
            return true;
        }catch (Exception e){
            throw new BiometriaException("erro na encodaçao para Base64");
        }
    }
	
	 public Long salvaDigital(CartaoRepository cartaoRepository, String idCartao) {
	        
		 	Optional<Cartao> cartao = cartaoRepository.findById(idCartao);

	        Assert.isTrue(cartao.isPresent(),"Falha ao recuperar informações do cartão de crédito");

	        if(cartao.isPresent()){

	            Digital digital = new Digital(idCartao,biometria);
	            Cartao update = cartao.get();

	            update.setDigitais(digital);

	            List<Digital> digitais = update.getDigitais();
	            cartaoRepository.save(update);

	            return update.getDigitais().get(digitais.size() - 1).getId();
	        }
	        return null;
	    }

	@Override
	public String toString() {
		return "BiometriaRequest [biometria=" + biometria + "]";
	}	
}
