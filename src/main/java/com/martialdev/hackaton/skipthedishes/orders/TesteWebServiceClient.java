package com.martialdev.hackaton.skipthedishes.orders;

import org.springframework.web.client.RestTemplate;

import com.martialdev.hackaton.skipthedishes.products.entities.Product;

public class TesteWebServiceClient {

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		Product p = restTemplate.getForObject("http://localhost:8090/api/v1/Product/products/2", Product.class);
		System.out.println(p.toString());

	}

}
