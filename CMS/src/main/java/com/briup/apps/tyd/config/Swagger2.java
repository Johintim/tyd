/**
 * Project Name:poll
 * File Name:Swagger2.java
 * Package Name:com.briup.apps.poll.config
 * Date:2018年6月10日下午6:22:51
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.briup.apps.tyd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName:Swagger2 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年11月11日 下午6:22:51 <br/>
 * @author   tyd
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.briup.apps.tyd.web.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("远东博客系统")
				.description("远东国际有限公司，http://www.briup.com")
				.termsOfServiceUrl("http://www.briup.com")
				.version("1.0")
				.build();
	}
	
	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}
}

