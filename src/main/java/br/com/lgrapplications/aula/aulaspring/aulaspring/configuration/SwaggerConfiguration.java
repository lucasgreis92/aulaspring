package br.com.lgrapplications.aula.aulaspring.aulaspring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    @Value("${swagger.base-package}")
    private String BASEPACKAGE;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASEPACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("API Database WS")
                .description ("Essa é a API responsável por comunicar com o banco de dados e disponibilizar os dados via REST.")
                /*           .license("Apache License Version 2.0")
                           .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                           .termsOfServiceUrl("/service.html")*/
                .version("1.0.0")
                .contact(new Contact("Lucas Gabriel Reis","http://www.spintec.com.br/", "lucas.reis@spintec.com.br"))
                .build();

        return apiInfo;
    }
}
