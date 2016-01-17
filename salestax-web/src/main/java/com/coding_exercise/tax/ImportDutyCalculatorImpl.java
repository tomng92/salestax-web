package com.coding_exercise.tax;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import com.coding_exercise.item.Item;
import com.coding_exercise.item.Price;
import com.coding_exercise.util.Utils;

/**
 * ImportDutyCalculator computes the import duty. This rule applies:
 * 
 *     "Import duty is an additional sales tax applicable on
 *      all imported goods at a rate of 5%, with no exemptions".
 * 
 * @author thanh nguyen
 *
 */
public class ImportDutyCalculatorImpl implements ImportDutyCalculator {
	
	final static Logger logger = Logger.getLogger(ImportDutyCalculatorImpl.class.getName());
	
	@Autowired
	private Utils utils;
	
	public Utils getUtils() {
		return utils;
	}

	public void setUtils(Utils utils) {
		this.utils = utils;
	}

	/**
	 * @see com.coding_exercise.tax.ImportDutyCalculator#computeImportDuty(com.coding_exercise.item.Item)
	 */
	@Override
	public Price computeImportDuty(Item item) {
		
		if (item == null) {
			logger.severe("item is null");
			throw new IllegalArgumentException("item is null");
		}

		if (!item.isImported()) {
			return new Price(0);
		}
		
		double tax = item.getPrice().getValue().doubleValue() * 5 / 100;
		return new Price(utils.roundUpToNearest005(tax));
	}
	
}
