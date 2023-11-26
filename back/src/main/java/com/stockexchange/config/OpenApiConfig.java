package com.stockexchange.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de consulta ações da bolsa Java17 e Spring-Boot 3")
                        .version("v1")
                        .description("API de consulta BOLSA de valores do Mundo usando a Alpha Vantage")
                        .termsOfService("https://www.alphavantage.co/terms_of_service/")
                        .license(new License()
                                .name("TERMS OF SERVICE")
                                .url("https://www.alphavantage.co/terms_of_service/")
                        )
                );
    }
}
