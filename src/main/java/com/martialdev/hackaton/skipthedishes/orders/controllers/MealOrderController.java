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

import com.martialdev.hackaton.skipthedishes.orders.entities.MealOrder;
import com.martialdev.hackaton.skipthedishes.orders.repos.MealOrderRepository;

@RepositoryRestController
@RequestMapping(value="/")
public class MealOrderController {
	
	@Autowired
	MealOrderRepository mealOrderRepository;
	
	@PostMapping("/")
	public ResponseEntity<PersistentEntityResource> save(@RequestBody MealOrder mealOrder, PersistentEntityResourceAssembler assembler) {
		
		 //mealOrderRepository.save(mealOrder);
		
		 
			MealOrder order = new MealOrder();
			order.setContact(mealOrder.getContact() + ": passou por aqui");
		

		return ResponseEntity.ok(assembler.toResource(order));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersistentEntityResource> get(@Param("id") String id, PersistentEntityResourceAssembler assembler) {
		
		MealOrder order = new MealOrder();
		
		return ResponseEntity.ok(assembler.toResource(order));
		
	}

}
