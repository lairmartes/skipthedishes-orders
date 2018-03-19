package com.github.lairmartes.hackaton.skipthedishes.orders.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EnvironmentConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public String urlRestApiProduct() {
		return "http://localhost:8090/api/v1/Product/";
	}
}
