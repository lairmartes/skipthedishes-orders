package com.martialdev.hackaton.skipthedishes.orders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martialdev.hackaton.skipthedishes.orders.entities.Order;
import com.martialdev.hackaton.skipthedishes.orders.repos.OrderRepository;

@RepositoryRestController
@RequestMapping(value="/")
public class OrderController {
	
	@Autowired
	OrderRepository mealOrderRepository;
	
	@PostMapping("/")
	public ResponseEntity<PersistentEntityResource> save(@RequestBody Order mealOrder, PersistentEntityResourceAssembler assembler) {
		
		mealOrder.setStatus(OrderStatus.CREATED.status());
		
		System.out.println(mealOrder.getTotal());
		
		 mealOrderRepository.save(mealOrder);

		return ResponseEntity.ok(assembler.toResource(mealOrder));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersistentEntityResource> get(@Param("id") String id, PersistentEntityResourceAssembler assembler) {
		
		Order order = new Order();
		
		return ResponseEntity.ok(assembler.toResource(order));
		
	}

}
