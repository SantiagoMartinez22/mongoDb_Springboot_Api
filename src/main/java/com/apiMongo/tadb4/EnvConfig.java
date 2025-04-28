package com.apiMongo.tadb4;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;



    @Configuration
    public class EnvConfig {

        @PostConstruct
        public void loadEnv() {
            Dotenv dotenv = Dotenv.configure()
                    .directory("./") // Busca el .env en la raíz
                    .ignoreIfMissing() // No falla si no existe
                    .load();

            // Carga las variables al System Properties
            dotenv.entries().forEach(entry ->
                    System.setProperty(entry.getKey(), entry.getValue())
            );
        }
    }

