package com.coding_exercise.tax;

import com.coding_exercise.item.Item;
import com.coding_exercise.item.Price;

public interface ImportDutyCalculator {

	/**
	 * Computes the import duty, which is 5% of item price. 
	 * Round up to the nearest 0.05.
	 * 
	 * @param item
	 * @return Price.
	 */
	Price computeImportDuty(Item item);

}