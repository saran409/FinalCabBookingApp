package com.cabapp.pro.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.service.contexts.SecurityContext;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {

	  public static final String AUTHORIZATION_HEADER = "Authorization";

	    private ApiKey apiKey(){
	        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	    }

	    private SecurityContext securityContext(){
	        return SecurityContext.builder().securityReferences(defaultAuth()).build();
	    }
	    
	    private List<SecurityReference> defaultAuth(){
	        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
	        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	        authorizationScopes[0] = authorizationScope;
	        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	    }
	    
	
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cabapp.pro"))
                .paths(PathSelectors.any())
                .build();
    }

}