package com.martialdev.hackaton.skipthedishes.orders.controllers;

public enum OrderStatus {
	
	CREATED("created"),
	CANCELLED("cancelled");
	
	private String status;
	
	OrderStatus(String status) {
		this.status = status;
	}
	
	public String status() {
		return this.status;
	}
}
