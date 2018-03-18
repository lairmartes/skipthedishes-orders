package com.martialdev.hackaton.skipthedishes.orders.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.martialdev.hackaton.skipthedishes.orders.entities.MealOrder;

public interface MealOrderRepository extends PagingAndSortingRepository<MealOrder, Long>{

}
