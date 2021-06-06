package com.demo.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    Docket api() {
       ApiInfo apiInfo = new ApiInfo(
                "Bank App  Kafka  Test Application",
                "APIs for the Test App.",
                "", "", new Contact("","",""), "", "");

        return new Docket(DocumentationType.SWAGGER_2)
                //.globalOperationParameters([authorizationParameter])
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.bankapp"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }



/*
    @Bean
    Docket api() {
        Parameter authorizationParameter = new ParameterBuilder()
                .name("Authorization")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("Bearer ")
                .required(false)
                .build();

        ApiInfo apiInfo = new ApiInfo(
                "Bharath Test Application",
                "APIs for the Test App.",
               "", "", "", "", "");

        return new Docket(DocumentationType.SWAGGER_2)
                //.globalOperationParameters([authorizationParameter])
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.techguy.demo"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);

    }*/
}
