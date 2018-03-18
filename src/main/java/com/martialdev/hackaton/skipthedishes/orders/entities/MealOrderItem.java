package com.martialdev.hackaton.skipthedishes.orders.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MealOrderItem {

	/*
	"orderItems": [
	           	#    {
	           	#      "id": 0,
	           	#      "orderId": 0,
	           	#      "productId": 0,
	           	#      "product": {
	           	#        "id": 0,
	           	#        "storeId": 0,
	           	#        "name": "string",
	           	#        "description": "string",
	           	#        "price": 0
	           	#      },
	           	#      "price": 0,
	           	#      "quantity": 0,
	           	#      "total": 0
	           	#    }
	           	#  ],
	 	*/
	
	@Id
	@Column(nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName="ID", nullable=false, updatable=false)
	private MealOrder mealOrder;
	private long productId;
	private double price;
	private double quantity;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public MealOrder getMealOrder() {
		return mealOrder;
	}
	public void setMealOrder(MealOrder mealOrder) {
		this.mealOrder = mealOrder;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return this.price * this.quantity;
	}

}