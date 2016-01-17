package com.coding_exercise.tax;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import com.coding_exercise.item.Item;
import com.coding_exercise.item.ItemType;
import com.coding_exercise.item.Price;
import com.coding_exercise.util.Utils;

/**
 * Object that computes sales tax according to the rule:
 *    "Basic sales tax is applicable at a rate of 10% on all goods,
 *     except books, food, and medical products that are exempt."
 * @author thanh nguyen
 *
 */
public class SalesTaxCalculatorImpl implements SalesTaxCalculator {
	
	final static Logger logger = Logger.getLogger(SalesTaxCalculatorImpl.class.getName());
	
	@Autowired()
	private Utils utils;
	
	public Utils getUtils() {
		return utils;
	}

	public void setUtils(Utils utils) {
		this.utils = utils;
	}

	/**
	 * Compute sales tax for item.
	 * @param item
	 * @return sales tax.
	 */
	@Override
	public Price computeTax(Item item) {
		
		if (item == null) {
			logger.severe("item is null");
			throw new IllegalArgumentException("item is null");
		}
		
		if (item.getType() != ItemType.BOOK &&
			item.getType() != ItemType.FOOD &&
			item.getType() != ItemType.MEDICAL_PRODUCT) {
			
			double tax = item.getPrice().getValue().doubleValue() * 10 / 100;
			return new Price(utils.roundUpToNearest005(tax));
		} else {
			return new Price(0.0);
		}
	}
}
