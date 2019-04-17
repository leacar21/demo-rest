package com.example.demorest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {  
	
//	@Autowired
//	private TypeResolver typeResolver;
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();      
    	
//    	return new Docket(DocumentationType.SWAGGER_2)
//    			.select()
//    			.apis(RequestHandlerSelectors.basePackage("com.example.demorest.controllers"))
//    			.paths(PathSelectors.regex("/countries.*"))
//    			.build()
//    			//.pathMapping("/")
//    			.genericModelSubstitutes(ResponseEntity.class)
//    			.alternateTypeRules(AlternateTypeRules.newRule(
//    				typeResolver.resolve(DeferredResult.class,
//    				typeResolver.resolve(ResponseEntity.class,WildcardType.class)), 
//    				typeResolver.resolve(WildcardType.class)))
//    			.useDefaultResponseMessages(false)
//    			.apiInfo(apiInfo());
    }
    
//    private ApiInfo apiInfo() {
//    	return new ApiInfo(
//    		"API Title",
//    		"API Description",
//    		"", 
//    		"urn:tos", 
//    		"contactName", 
//    		"API License",
//    		"http://www.api-license-url.com");
//    }
}

