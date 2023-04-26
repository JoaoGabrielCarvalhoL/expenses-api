package br.com.carv.expenses.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI configOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Expenses Management.")
                        .version("1.0 - Development.")
                        .description("Expense Management System.")
                        .contact(new Contact()
                                .name("João Gabriel Carvalho")
                                .email("27.joaogabriel@gmail.com")
                                .url("http://github.com/JoaoGabrielCarvalhoL"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));

    }

}
