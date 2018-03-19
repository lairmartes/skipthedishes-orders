package com.github.lairmartes.hackaton.skipthedishes.orders.entities;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.lairmartes.hackaton.skipthedishes.orders.entities.Order;
import com.github.lairmartes.hackaton.skipthedishes.orders.entities.OrderItem;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {
	
	@Mock
	OrderItem itemOneMock;
	@Mock
	OrderItem itemTwoMock;
	@Mock
	OrderItem itemThreeMock;

	@Test
	public void testTotalOrder() {
		
		double totalItemOne = 12.45;
		double totalItemTwo = 341.76;
		double totalItemThree = 1.75;
		double expectedTotal = totalItemOne + totalItemTwo + totalItemThree;
		
		when(itemOneMock.getTotal()).thenReturn(totalItemOne);
		when(itemTwoMock.getTotal()).thenReturn(totalItemTwo);
		when(itemThreeMock.getTotal()).thenReturn(totalItemThree);
		
		Set<OrderItem> mockOrderItemSet = new HashSet<>();
		mockOrderItemSet.add(itemOneMock);
		mockOrderItemSet.add(itemTwoMock);
		mockOrderItemSet.add(itemThreeMock);
		
		Order mealOrderTest = new Order();
		mealOrderTest.setOrderItems(mockOrderItemSet);
		
		assertEquals(expectedTotal, mealOrderTest.getTotal(), 0.0);
	}

}
