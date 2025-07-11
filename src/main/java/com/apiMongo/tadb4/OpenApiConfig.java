package com.apiMongo.tadb4;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Rest medicamentos") // Aquí defines el título
                        .version("1.0") // Puedes poner la versión de tu API
                        .description("API para la gestión de medicamentos y compuestos")); // Descripción opcional
    }
}