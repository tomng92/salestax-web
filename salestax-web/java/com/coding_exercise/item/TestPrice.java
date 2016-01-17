package com.coding_exercise.item;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.coding_exercise.item.Price;

public class TestPrice {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConstrutorString() {
		Price price = new Price("12");
		Assert.assertTrue("Price should have scale 2", price.getValue().equals(new BigDecimal("12.00")));

		price = new Price("12.345");
		Assert.assertTrue("Price should have scale 2 and rounded up", price.getValue().equals(new BigDecimal("12.35")));
	}
	
	@Test
	public void testConstrutorDouble() {
		Price price = new Price(12);
		Assert.assertTrue("Price should have scale 2", price.getValue().equals(new BigDecimal("12.00")));

		price = new Price(12.345);
		Assert.assertTrue("Price should have scale 2 and rounded up", price.getValue().equals(new BigDecimal("12.35")));
	}
	
	@Test
	public void testConstrutorStringInvalidFormat() {
		try {
			/* Price price = */ new Price("hello");
			Assert.fail("Should throw exception");
		} catch (Exception e) {
			// ok
		}
	}
}
