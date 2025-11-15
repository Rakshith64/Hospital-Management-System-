package com.qsp.hospital_management_system.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(new Components())
            .info(new Info()
                .title("Hospital Management System API")
                .description("This API allows managing hospital data such as owners, hospitals, patients, and doctors. "
                        + "It supports CRUD operations, linking entities, and simplifies hospital administration both online and offline.")
                .version("1.1")
                .contact(new Contact()
                        .name("M5Batch Team")
                        .email("m5batch@gmail.com")
                        .url("https://www.m5batch.com"))
                .license(new License()
                        .name("M5Batch License")
                        .url("#")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("Hospital Management APIs")
            .packagesToScan("com.qsp.hospital_management_system")
            .build();
    }
}
