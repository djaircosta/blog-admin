package br.com.aydconnection.blogadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Indica que esta é uma classe de configuração do Spring
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Aplica a configuração CORS a todos os endpoints que começam com /api/
        registry.addMapping("/api/**")
                // Liste os domínios do seu frontend que terão permissão para acessar sua API
                // EXTREMAMENTE IMPORTANTE: AJUSTE ESSAS ORIGENS PARA ONDE SEU FRONTEND RODARÁ!
                .allowedOrigins("http://localhost:3000", "http://localhost:4200", "http://localhost:8081", "http://127.0.0.1:5500") // Exemplos: React, Angular, Vue, Live Server
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true); // Permite o envio de cookies e cabeçalhos de autenticação
    }
}
