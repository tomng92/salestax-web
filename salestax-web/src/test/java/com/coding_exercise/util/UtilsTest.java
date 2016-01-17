package com.coding_exercise.util;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.coding_exercise.item.Price;

/**
 * Test Utils class.
 * @author thanh nguyen
 *
 */
public class UtilsTest {
	private Utils utils;
	

	@Before
	public void setUp() throws Exception {
		utils = new Utils();
	}

	/**
	 * Tests rounding function: round up to nearest 0.05. 
	 */
	@Test
	public void testRounding() {			
		Assert.assertTrue(new Price(utils.roundUpToNearest005(0)).getValue().compareTo(new BigDecimal("0")) == 0);
		Assert.assertTrue(new Price(utils.roundUpToNearest005(4)).getValue().compareTo(new BigDecimal("4")) == 0);
		Assert.assertTrue(new Price(utils.roundUpToNearest005(4.1101)).getValue().compareTo(new BigDecimal("4.15")) == 0);
		Assert.assertTrue(new Price(utils.roundUpToNearest005(4.11)).getValue().compareTo(new BigDecimal("4.15")) == 0);
		Assert.assertTrue(new Price(utils.roundUpToNearest005(4.14)).getValue().compareTo(new BigDecimal("4.15")) == 0);
		Assert.assertTrue(new Price(utils.roundUpToNearest005(4.15)).getValue().compareTo(new BigDecimal("4.15")) == 0);
		Assert.assertTrue(new Price(utils.roundUpToNearest005(4.152)).getValue().compareTo(new BigDecimal("4.2")) == 0);
		Assert.assertTrue(new Price(utils.roundUpToNearest005(4.19)).getValue().compareTo(new BigDecimal("4.2")) == 0);
	}

}
