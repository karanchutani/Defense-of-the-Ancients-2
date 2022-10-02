package com.assignment.Defense.of.the.Ancients2.configuration;

import com.assignment.Defense.of.the.Ancients2.util.Constant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is configuration class for swagger.
 * @author Karan
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(Constant.SWAGGER_BASE_PACKAGE_PATH))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }
}
