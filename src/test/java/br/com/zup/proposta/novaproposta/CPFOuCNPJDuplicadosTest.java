package br.com.zup.proposta.novaproposta;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
public class CPFOuCNPJDuplicadosTest {

	@Autowired
	private MockMvc mock;

	@Test
	@DisplayName("Busca retornar 402 no cadastro de propostas com documentos (CNPJ e CPF) duplicados")
	public void TestandoExcecoesNaValidacaoDeDocumentos() throws Exception {

		String form = "{\n" + "\t\"documento\" : \"676253985-87\",\n" 
				+ "\t\"email\" : \"jeancbsan@gmail.com\",\n"
				+ "\t\"nome\" : \"Jean Santos\",\n" 
				+ "\t\"endereco\" : {\n"
				+ "\t\t\"logradouro\" : \"Rua Manoel Novis\",\n" 
				+ "\t\t\"numero\" : \"201\",\n"
				+ "\t\t\"bairro\" : \"Centro\",\n" 
				+ "\t\t\"cidade\" : \"Tanguá\",\n" 
				+ "\t\t\"cep\" : \"24890-000\"\n"
				+ "\t},\n" 
				+ "\t\"salario\" : \"2500\"\t\n" + "}";

		mock.perform(MockMvcRequestBuilders.post("/propostas").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(form))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());

		mock.perform(MockMvcRequestBuilders.post("/propostas").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(form))
				.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity()).andDo(MockMvcResultHandlers.print());

	}

}
