package com.martialdev.hackaton.skipthedishes.orders.entities;

import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class MealOrder {
	
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
	private Instant created;
	private long customerId;
	private String deliveryAddress;
	private String contact;
	private long storeId;
	@OneToMany(mappedBy = "mealOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<MealOrderItem> mealOrderItems;
	private String status;
	private Instant lastUpdate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Instant getCreated() {
		return created;
	}
	public void setCreated(Instant created) {
		this.created = created;
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
	public Set<MealOrderItem> getMealOrderItem() {
		return mealOrderItems;
	}
	public void setMealOrderItem(Set<MealOrderItem> mealOrderItem) {
		this.mealOrderItems = mealOrderItem;
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

	public double getTotal() {
		
		double result = 0.0;
		
		result = mealOrderItems.stream().mapToDouble(MealOrderItem::getTotal).sum();
		
		return result;
	}

}
