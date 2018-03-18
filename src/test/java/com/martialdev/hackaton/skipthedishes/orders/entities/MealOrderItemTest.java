package com.martialdev.hackaton.skipthedishes.orders.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MealOrderItemTest {
	
	@Test
	public void testTotalItem() {
		
		MealOrderItem mealOrderTest = new MealOrderItem();
		double priceTest = 12.34;
		double qttyTest = 3;
		
		mealOrderTest.setPrice(priceTest);
		mealOrderTest.setQuantity(qttyTest);
		
		assertEquals(priceTest * qttyTest, mealOrderTest.getTotal(), 0);
	}

}
