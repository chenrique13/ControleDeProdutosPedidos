package br.com.kLab.controleDeProdutosPedidos.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguracao {

	  @Bean
	    OpenAPI cutomizacaoOpenAPI() {
	        return new OpenAPI()
	                .info(new Info().title("Controle de Produtos/Pedidos")
	                        .description("Documentação da API Controle de Produtos/Pedidos")
	                        .version("v1.0"))
	                .externalDocs(new ExternalDocumentation()
	                        .description("Mais detalhes")
	                        .url("https://github.com/chenrique13/ControleDeProdutosPedidos"));
	    }
	
}
