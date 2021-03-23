package br.com.zup.proposta.novaproposta;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class NovaPropostaTest {
	

	@Autowired
	private MockMvc mockMvc;
	
	
	 @ParameterizedTest
	    @MethodSource("PassaCPFeCNPJ")
	    @DisplayName("Sucesso no cadastro de CPF e CNPJ")
	    public void testSucess(String request) throws  Exception{
	        mockMvc.perform(MockMvcRequestBuilders.post("/propostas")
	                .accept(MediaType.APPLICATION_JSON)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(request))
	                .andExpect(MockMvcResultMatchers.status().isCreated())
	                .andDo(MockMvcResultHandlers.print());
	    }
	 
	 public static Stream<Arguments> PassaCPFeCNPJ(){
	        return Stream.of(
	                Arguments.of("{\n" +
	                		"\t\"documento\" : \"080.348.957-92\",\n" +
	                        "\t\"email\" : \"jeancbsan@gmail.com\",\n" +
	                        "\t\"nome\" : \"Jean Santos\",\n" +
	                        "\t\"endereco\" : {\n" +
	                        "\t\t\"logradouro\" : \"Rua Manoel Novis\",\n" +
	                        "\t\t\"numero\" : \"201\",\n" +
	                        "\t\t\"bairro\" : \"Centro\",\n" +
	                        "\t\t\"cidade\" : \"Tanguá\",\n" +
	                        "\t\t\"cep\" : \"24890-000\"\n" +
	                        "\t},\n" +
	                        "\t\"salario\" : \"2500\"\t\n" +
	                        "}"),
	                Arguments.of("{\n" +
	                        "\t\"documento\" : \"30.038.243/0001-80\",\n" +
	                        "\t\"email\" : \"jeancbsan@gmail.com\",\n" +
	                        "\t\"nome\" : \"Jean Santos\",\n" +
	                        "\t\"endereco\" : {\n" +
	                        "\t\t\"logradouro\" : \"Rua Manoel Novis\",\n" +
	                        "\t\t\"numero\" : \"201\",\n" +
	                        "\t\t\"bairro\" : \"Centro\",\n" +
	                        "\t\t\"cidade\" : \"Tanguá\",\n" +
	                        "\t\t\"cep\" : \"24890-000\"\n" +
	                        "\t},\n" +
	                        "\t\"salario\" : \"2500\"\t\n" +
	                        "}")
	        );
	    };


	@ParameterizedTest
	@MethodSource("ErroDeValidacaoProposta")
	@DisplayName("Erros na Validação nos formatos inválidos de uma nova proposta")
	public void testFailController(String request) throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/propostas").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(request))
				.andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print());
	}

    public static Stream<Arguments> ErroDeValidacaoProposta(){
      return Stream.of(
              Arguments.of("{\n" +
                      "\t\"documento\" : \"676253985-87\",\n" +
                      "\t\"email\" : \"jeancbsan@gmail.com\",\n" +
                      "\t\"nome\" : \"Jean Santos\",\n" +
                      "\t\"endereco\" : {\n" +
                      "\t\t\"logradouro\" : \"Rua Manoel Novis\",\n" +
                      "\t\t\"numero\" : \"\",\n" +
                      "\t\t\"bairro\" : \"Centro\",\n" +
                      "\t\t\"cidade\" : \"Tanguá\",\n" +
                      "\t\t\"cep\" : \"24890-000\"\n" +
                      "\t},\n" +
                      "\t\"salario\" : \"2500\"\t\n" +
                      "}"),
              Arguments.of("{\n" +
            		  "\t\"documento\" : \"\",\n" +
                      "\t\"email\" : \"jeancbsan@gmail.com\",\n" +
                      "\t\"nome\" : \"Jean Santos\",\n" +
                      "\t\"endereco\" : {\n" +
                      "\t\t\"logradouro\" : \"Rua Manoel Novis\",\n" +
                      "\t\t\"numero\" : \"201\",\n" +
                      "\t\t\"bairro\" : \"Centro\",\n" +
                      "\t\t\"cidade\" : \"Tanguá\",\n" +
                      "\t\t\"cep\" : \"24890-000\"\n" +
                      "\t},\n" +
                      "\t\"salario\" : \"2500\"\t\n" +
                      "}"),
              Arguments.of("{\n" +
            		  "\t\"documento\" : \"676253985-87\",\n" +
                      "\t\"email\" : \"jeancbsan@gmail.com\",\n" +
                      "\t\"nome\" : \"Jean Santos\",\n" +
                      "\t\"endereco\" : {\n" +
                      "\t\t\"logradouro\" : \"Rua Manoel Novis\",\n" +
                      "\t\t\"numero\" : \"\",\n" +
                      "\t\t\"bairro\" : \"Centro\",\n" +
                      "\t\t\"cidade\" : \"\",\n" +
                      "\t\t\"cep\" : \"24890-000\"\n" +
                      "\t},\n" +
                      "\t\"salario\" : \"2500\"\t\n" +
                      "}"),
              Arguments.of("{\n" +
            		  "\t\"documento\" : \"676253985-87\",\n" +
                      "\t\"email\" : \"jeancbsan@gmail.com\",\n" +
                      "\t\"nome\" : \"Jean Santos\",\n" +
                      "\t\"endereco\" : {\n" +
                      "\t\t\"logradouro\" : \"Rua Manoel Novis\",\n" +
                      "\t\t\"numero\" : \"\",\n" +
                      "\t\t\"bairro\" : \"Centro\",\n" +
                      "\t\t\"cidade\" : \"Tanguá\",\n" +
                      "\t\t\"cep\" : \"24890-000\"\n" +
                      "\t},\n" +
                      "\t\"salario\" : \"-100\"\t\n" +
                      "}"),
              Arguments.of("{\n" +
            		  "\t\"documento\" : \"676253985-87\",\n" +
                      "\t\"email\" : \"jeancbsan@\",\n" +
                      "\t\"nome\" : \"Jean Santos\",\n" +
                      "\t\"endereco\" : {\n" +
                      "\t\t\"logradouro\" : \"Rua Manoel Novis\",\n" +
                      "\t\t\"numero\" : \"\",\n" +
                      "\t\t\"bairro\" : \"Centro\",\n" +
                      "\t\t\"cidade\" : \"Tanguá\",\n" +
                      "\t\t\"cep\" : \"24890-000\"\n" +
                      "\t},\n" +
                      "\t\"salario\" : \"2500\"\t\n" +
                      "}"),
              Arguments.of("{\n" +
            		  "\t\"documento\" : \"676253985-87\",\n" +
                      "\t\"email\" : \"jeancbsan@gmail.com\",\n" +
                      "\t\"nome\" : \"\",\n" +
                      "\t\"endereco\" : {\n" +
                      "\t\t\"logradouro\" : \"Rua Manoel Novis\",\n" +
                      "\t\t\"numero\" : \"\",\n" +
                      "\t\t\"bairro\" : \"Centro\",\n" +
                      "\t\t\"cidade\" : \"Tanguá\",\n" +
                      "\t\t\"cep\" : \"24890-000\"\n" +
                      "\t},\n" +
                      "\t\"salario\" : \"2500\"\t\n" +
                      "}")
              );
    };
}
