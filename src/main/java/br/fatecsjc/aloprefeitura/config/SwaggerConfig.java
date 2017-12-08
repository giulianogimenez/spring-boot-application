package br.fatecsjc.aloprefeitura.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.edu.fatecsjc.aloprefeitura.controllers")).paths(regex("/.*"))
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Sistemas de Usuários", "Sistema de cadastro simples de usuários, no qual pode-se fazer login e efetuar auditoria dos registros", 
				"1.0", "Giuliano Gimenez Amorim", "ggimenez87@gmail.com", "", "");
		return apiInfo;
	}
}
