package com.github.lairmartes.hackaton.skipthedishes.orders.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.lairmartes.hackaton.skipthedishes.orders.entities.OrderItem;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemTest {
	
	@Test
	public void testTotalItem() {
		
		OrderItem mealOrderTest = new OrderItem();
		double priceTest = 12.34;
		double qttyTest = 3;
		
		mealOrderTest.setPrice(priceTest);
		mealOrderTest.setQuantity(qttyTest);
		
		assertEquals(priceTest * qttyTest, mealOrderTest.getTotal(), 0);
	}

}
