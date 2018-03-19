package com.martialdev.hackaton.skipthedishes.orders.controllers;

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

import com.martialdev.hackaton.skipthedishes.orders.entities.Order;
import com.martialdev.hackaton.skipthedishes.orders.repos.OrderRepository;

@RepositoryRestController
@RequestMapping(value="/")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@PostMapping("/")
	public ResponseEntity<PersistentEntityResource> save(@RequestBody Order mealOrder, PersistentEntityResourceAssembler assembler) {
		
		mealOrder.setStatus(OrderStatus.CREATED.status());
		
		System.out.println(mealOrder.getTotal());
		
		orderRepository.save(mealOrder);

		return ResponseEntity.ok(assembler.toResource(mealOrder));
	}

	@GetMapping("/status/{id}")
	public ResponseEntity<String> get(@PathVariable Long id) {
		
		Optional<Order> askOrder  = orderRepository.findById(id);
		Order order = askOrder.get();
		if (!askOrder.isPresent()) {
			throw new ResourceNotFoundException("Order not found");
		}
		
		return ResponseEntity.ok("order " +order.getId() + " " + order.getStatus());
		
	}
	
	@PostMapping("/cancel/{id}")
	public ResponseEntity<String> save(@PathVariable Long id) {
		
		int qttyRowsAffected = orderRepository.cancelOrder(id);
		
		if (qttyRowsAffected < 1) {
			throw new ResourceNotFoundException("Order not found");
		}

		return ResponseEntity.ok("order " + id + " has been cancelled");
	}

}
