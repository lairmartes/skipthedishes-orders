package com.martialdev.hackaton.skipthedishes.orders.entities;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MealOrderTest {
	
	@Mock
	MealOrderItem itemOneMock;
	MealOrderItem itemTwoMock;
	MealOrderItem itemThreeMock;
	List<MealOrderItem> mealOrderItemListMock;

	
	@Test
	public void testTotalOrder() {
		
		double totalItemOne = 12.45;
		double totalItemTwo = 341.76;
		double totalItemThree = 1.75;
		double expectedTotal = totalItemOne + totalItemTwo + totalItemThree;
		
		when(itemOneMock.getTotal()).thenReturn(totalItemOne);
		when(itemTwoMock.getTotal()).thenReturn(totalItemTwo);
		when(itemThreeMock.getTotal()).thenReturn(totalItemThree);
		
		Set<MealOrderItem> mockOrderItemSet = new HashSet<>();
		mockOrderItemSet.add(itemOneMock);
		mockOrderItemSet.add(itemOneMock);
		mockOrderItemSet.add(itemOneMock);
		
		MealOrder mealOrderTest = new MealOrder();
		mealOrderTest.setMealOrderItem(mockOrderItemSet);
		
		assertEquals(expectedTotal, mealOrderTest.getTotal(), 0.0);
	}

}
