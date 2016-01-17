package com.coding_exercise.item;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a price. The value internally kept is a BigDecimal with scale of 2.
 * Constructors uses RoundingMode.HALF_EVEN to convert from double or string values.
 * @author thanh nguyen
 *
 */
public class Price {

	private BigDecimal value;
	
	public BigDecimal getValue() {
		return value;
	}
	
	/**
	 * Constructor from a double value.
	 * @param val Double
	 */
	public Price(double val) {
		
		BigDecimal p = new BigDecimal(val);
		this.value = p.setScale(2, RoundingMode.HALF_UP);
	}
		
	/**
	 * Constructor from a string value.
	 * @param val String
	 */
	public Price(String val) {
		BigDecimal p = new BigDecimal(val);
		this.value = p.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * Constructor from a Price value.
	 * @param val
	 */
	public Price(BigDecimal val) {
		this.value = val;
	}

}
