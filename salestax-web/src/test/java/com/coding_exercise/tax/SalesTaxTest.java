package com.coding_exercise.tax;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coding_exercise.item.Item;
import com.coding_exercise.item.ItemImpl;
import com.coding_exercise.item.ItemType;
import com.coding_exercise.item.Price;
import com.coding_exercise.tax.SalesTaxCalculatorImpl;

/**
 * Test for SalesTax.
 * @author thanh nguyen
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:**/testApplicationContext.xml")

public class SalesTaxTest {
	
	@Autowired
	private SalesTaxCalculatorImpl salesTaxCalculator;
	
	public void setSalesTaxCalculator(SalesTaxCalculatorImpl salesTaxCalculator) {
		this.salesTaxCalculator = salesTaxCalculator;
	}

	@Test
	public void testNotTaxableItem() {
		Item foodItem = new ItemImpl("some food", ItemType.FOOD, 12.345, false);
		Price tax =  salesTaxCalculator.computeTax(foodItem);
		Assert.assertTrue("no tax on food", tax.getValue().compareTo(new Price("0").getValue()) == 0);
	}

	@Test
	public void testTaxableItem() {
		Item musicItem = new ItemImpl("some music cd", ItemType.OTHER, 14.99, false);
		Price tax =  salesTaxCalculator.computeTax(musicItem);
		Assert.assertTrue("10% tax on music", tax.getValue().compareTo(new Price("1.5").getValue()) == 0);
	}
	
	@Test
	public void testTaxableItem2() {
		Item perfume = new ItemImpl("perfume", ItemType.OTHER, 27.99, false);
		Price tax =  salesTaxCalculator.computeTax(perfume);
		Assert.assertTrue("10% tax on perfume", tax.getValue().compareTo(new Price("2.80").getValue()) == 0);
	}
	
	@Test
	public void testNullItem() {
		try {
			/*Price duty = */ salesTaxCalculator.computeTax(null);
			Assert.fail("Should catch exception");
		} catch (IllegalArgumentException ex) {
			// ok
		}
	}

	
}
