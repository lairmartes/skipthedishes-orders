package com.martialdev.hackaton.skipthedishes.orders.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.martialdev.hackaton.skipthedishes.orders.entities.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
	
	@Modifying
	@Transactional
	@Query("update Order o set o.status = :status where o.id = :id")
	public int changeStatus(@Param("status") String status, @Param("id") Long id);

}
