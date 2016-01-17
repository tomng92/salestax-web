package com.coding_exercise.util;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coding_exercise.item.Item;
import com.coding_exercise.item.Price;
import com.coding_exercise.tax.ImportDutyCalculator;
import com.coding_exercise.tax.SalesTaxCalculator;

public class Utils {
	
	@Autowired
	SalesTaxCalculator taxCalculator;
	
	@Autowired
	ImportDutyCalculator dutyCalculator;
	
	/**
	 * This function rounds up to the nearest 0.05.
	 * Example
	 *   2.10452345235 -> 2.15
	 *   2.11345   -> 2.15
	 *   2.1334535 -> 2.15
	 *   2.15 -> 2.15
	 *   2.1500001 -> 2.2
	 *   2.15345 -> 2.2
	 *   2.1734535 -> 2.2
	 *
	 * See http://stackoverflow.com/questions/11815135/best-method-to-round-up-to-the-nearest-0-05-in-java?rq=1.
	 * 
	 * @param taxValue
	 * @return rounded value
	 */
	public double roundUpToNearest005(double value) {
		double rounded = (Math.ceil(value * 20)) / 20.0;
		return rounded;
	}
	
//	public String[] processInputList(String listNumber, List<Item> itemList) {
//		
//		// print legend  "Input 1:       Output 1:"
//		output2ColumnLine("Input " + listNumber + ":", "Output " + listNumber + ":");
//		
//		BigDecimal totalSalesTax = new BigDecimal(0);
//		BigDecimal total = new BigDecimal(0);
//		
//		// loop over each item to print line items
//		for (Item item: itemList) {
//			Price tax = taxCalculator.computeTax(item);
//			Price duty = dutyCalculator.computeImportDuty(item);
//			BigDecimal itemTotal = item.getPrice().getValue().add(tax.getValue()).add(duty.getValue());
//			total = total.add(itemTotal);
//			totalSalesTax = totalSalesTax.add(tax.getValue()).add(duty.getValue());
//			outputItemLine(item, itemTotal);
//		}
//		
//		// print 'Sales tax' line and 'Total'
//		output2ColumnLine("", String.format("Sales Tax:  %.2f", totalSalesTax));
//		output2ColumnLine("", String.format("Total:  %.2f", total));
//		outputDashLine();
//		
//	}


}
