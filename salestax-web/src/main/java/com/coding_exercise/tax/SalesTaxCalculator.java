package com.coding_exercise.tax;

import com.coding_exercise.item.Item;
import com.coding_exercise.item.Price;

public interface SalesTaxCalculator {

	/**
	 * Compute sales tax for item.
	 * @param item
	 * @return sales tax.
	 */
	public Price computeTax(Item item);

}