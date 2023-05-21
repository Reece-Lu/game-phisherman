package com.example.fisherman_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableOpenApi
public class Swagger3Config {

    /**
     * 文档基本信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger Interface documents")
                .description("swagger Interface documents")
                .version("2.0")
                .build();
    }

    /**
     * Global general attributes (abstract) configuration
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()) //Basic information of application documents
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.fisherman_server.controller")) // swagger scan path
                .paths(PathSelectors.any()) // Applied to all paths under the package
                .build();

    }

}
