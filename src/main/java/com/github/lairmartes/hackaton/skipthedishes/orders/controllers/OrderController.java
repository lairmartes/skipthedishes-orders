package com.github.lairmartes.hackaton.skipthedishes.orders.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.github.lairmartes.hackaton.skipthedishes.orders.entities.Order;
import com.github.lairmartes.hackaton.skipthedishes.orders.repos.OrderRepository;
import com.martialdev.hackaton.skipthedishes.products.entities.Product;

@RepositoryRestController
@RequestMapping(value = "/")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	String urlRestApiProduct;

	@PostMapping("/")
	public ResponseEntity<PersistentEntityResource> save(@RequestBody Order mealOrder,
			PersistentEntityResourceAssembler assembler) {

		mealOrder.setStatus(OrderStatus.CREATED.status());

		orderRepository.save(mealOrder);

		mealOrder.getOrderItems().forEach(item -> {
			Product p = restTemplate.getForObject(urlRestApiProduct + item.getProductId(), Product.class);
			item.setProduct(p);
		});

		return ResponseEntity.ok(assembler.toResource(mealOrder));
	}

	@GetMapping("/status/{id}")
	public ResponseEntity<PersistentEntityResource> get(@PathVariable Long id,
			PersistentEntityResourceAssembler assembler) {

		Order order = openOrder(id);

		return ResponseEntity.ok(assembler.toResource(order));

	}

	@PostMapping("/cancel/{id}")
	public ResponseEntity<PersistentEntityResource> save(@PathVariable Long id,
			PersistentEntityResourceAssembler assembler) {

		int qttyRowsAffected = orderRepository.changeStatus(OrderStatus.CANCELLED.status(), id);

		if (qttyRowsAffected < 1) {
			throw new ResourceNotFoundException("Order not found");
		}
		
		Order order = openOrder(id);

		return ResponseEntity.ok(assembler.toResource(order));
	}

	private Order openOrder(Long id) {

		Optional<Order> askOrder = orderRepository.findById(id);

		if (!askOrder.isPresent()) {
			throw new ResourceNotFoundException("Order " + id + " not found");
		}

		Order result = askOrder.get();

		result.getOrderItems().forEach(item -> {
			// get product data from Product Rest API
			Product p = restTemplate.getForObject(urlRestApiProduct + item.getProductId(), Product.class);
			item.setProduct(p);
		});

		return result;

	}

}
