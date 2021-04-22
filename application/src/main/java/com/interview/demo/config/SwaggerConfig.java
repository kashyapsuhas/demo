package com.interview.demo.config;

import io.swagger.models.*;
import io.swagger.models.auth.ApiKeyAuthDefinition;
import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends HttpServlet {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        Info info = new Info()
                .title("Demo project")
                .description("Implemantaion of some basic stuff.");

        ServletContext context = config.getServletContext();
        Swagger swagger = new Swagger().info(info);
        swagger.externalDocs(new ExternalDocs("Find code here", "https://github.com/kashyapsuhas/job-universe"));
        swagger.securityDefinition("api_key", new ApiKeyAuthDefinition("api_key", In.HEADER));
        swagger.tag(new Tag()
                .name("Hibernate Search")
                .description("Google for your entities")
                .externalDocs(new ExternalDocs("Find out more", "http://hibernate.org/search/")));
        swagger.tag(new Tag()
                .name("Spring Boot")
                .description("Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can \"just run\". "));
        context.setAttribute("swagger", swagger);
    }
}

