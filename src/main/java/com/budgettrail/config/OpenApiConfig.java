package com.budgettrail.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI budgetTrailOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Budget Trail API")
                        .description("Seyahat planlama ve bütçe yönetimi için REST API")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Budget Trail Team")
                                .email("info@budgettrail.com")
                                .url("https://budgettrail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
} 