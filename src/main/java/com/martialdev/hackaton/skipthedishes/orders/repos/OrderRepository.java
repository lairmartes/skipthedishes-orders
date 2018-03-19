package com.martialdev.hackaton.skipthedishes.orders.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.martialdev.hackaton.skipthedishes.orders.entities.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{

}
