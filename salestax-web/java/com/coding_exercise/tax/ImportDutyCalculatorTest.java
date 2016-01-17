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

/**
 * Test for ImportDutyCalculator.
 * @author thanh nguyen
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:**/testApplicationContext.xml")
public class ImportDutyCalculatorTest {

	@Autowired
	private ImportDutyCalculatorImpl importDutyCalculator;
	

	public void setImportDutyCalculator(ImportDutyCalculatorImpl dutyCalculator) {
		this.importDutyCalculator = dutyCalculator;
	}

	@Test
	public void testImportedItem() {
		Item item = new ItemImpl("some food", ItemType.FOOD, 12.345, true);
		Price duty =  importDutyCalculator.computeImportDuty(item);
		Assert.assertTrue("5% duty on imported item", duty.getValue().compareTo(new Price("0.65").getValue()) == 0);
	}

	@Test
	public void testNotImportedItem() {
		Item item = new ItemImpl("some food", ItemType.FOOD, 12.345, false);
		Price duty =  importDutyCalculator.computeImportDuty(item);
		Assert.assertTrue("no duty on not imported item", duty.getValue().compareTo(new Price("0").getValue()) == 0);
	}
	
	@Test
	public void testNullItem() {
		try {
			/*Price duty = */ importDutyCalculator.computeImportDuty(null);
			Assert.fail("Should catch exception");
		} catch (IllegalArgumentException ex) {
			// ok
		}
	}
}
