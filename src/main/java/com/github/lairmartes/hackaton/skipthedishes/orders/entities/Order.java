package com.github.lairmartes.hackaton.skipthedishes.orders.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "MEAL_ORDER")
public class Order {
	
	/*
	# ******* order **********
	#{
	#  "id": 0,
	#  "date": "2018-03-18T13:14:53.000Z",
	#  "customerId": 0,
	#  "deliveryAddress": "string",
	#  "contact": "string",
	#  "storeId": 0,
	#  "orderItems": [
			// see MealOrderItem
	#  ],
	#  "total": 0,
	#  "status": "string",
	#  "lastUpdate": "2018-03-18T13:14:53.000Z"
	#}
	*/
	
	@Id
	@Column(nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@CreationTimestamp
	@Column(updatable=false)
	private Instant date;
	private long customerId;
	private String deliveryAddress;
	private String contact;
	private long storeId;
	//@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Transient
	private Set<OrderItem> orderItems;
	private String status;
	private Instant lastUpdate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Instant getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
	}	

	public Set<OrderItem> getOrderItems() {
		
		Set<OrderItem> result;
		
		if (orderItems == null) {
			result = new HashSet<OrderItem>();
		} else {
			result = orderItems;
		}
		return result;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public double getTotal() {
		
		double result = 0.0;
		
		if (orderItems != null) {
			result = orderItems.stream().mapToDouble(OrderItem::getTotal).sum();
		}
		
		return result;
	}

}
