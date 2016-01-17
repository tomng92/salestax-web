package com.coding_exercise.app;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;

import com.coding_exercise.config.AppSpringConfig;
import com.coding_exercise.data.ItemList;
import com.coding_exercise.item.Item;
import com.coding_exercise.item.Price;
import com.coding_exercise.tax.ImportDutyCalculator;
import com.coding_exercise.tax.SalesTaxCalculator;

/**
 * This is the command line sales tax application.
 * @author thanh nguyen 18 july 2015
 *
 */
@Configuration
@ComponentScan("com.coding_exercise")     
public class SalesTaxApp {
	public static void main(String[] args) {
		 
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppSpringConfig.class);
		SalesTaxCalculator taxHelper = (SalesTaxCalculator) ctx.getBean("salesTaxCalculator");
		ImportDutyCalculator dutyHelper = (ImportDutyCalculator) ctx.getBean("importDutyCalculator");
		ItemList itemList = (ItemList) ctx.getBean("itemList");
		//
		((AbstractApplicationContext)ctx).registerShutdownHook();
		
		// print legend  "Input 1:       Output 1:"
		outputDashLine();
		output2ColumnLine("INPUT:",  "OUTPUT:");
		outputDashLine();
		
		for (int i = 0; i < itemList.getItemListList().size(); i++) {
			processInputList(i + 1, taxHelper, dutyHelper, itemList.getItemListList().get(i));
		}
				
		((ConfigurableApplicationContext)ctx).close();
	}

	/**
	 * Loop over the item list to compute tax and duty, and print item line out.
	 * Sample output:
	 * 
	 *   INPUT:                                OUTPUT
	 *   Input 1:                              Output 1:
	 *     1 book at 12.49                      1 book : 12.49 
	 *     1 music CD at 14.99                  1 music CD: 16.49
	 *     1 chocolate bar at 0.85              1 chocolate bar: 0.85
	 *                                          Sales Taxes: 1.50
	 *                                          Total: 29.83
	 * @param listNumber
	 * @param taxHelper
	 * @param dutyHelper
	 * @param itemList
	 */
	private static void processInputList(int listNumber, SalesTaxCalculator taxHelper, ImportDutyCalculator dutyHelper, List<Item> itemList) {
		
		// print legend  "Input 1:       Output 1:"
		output2ColumnLine("Input " + listNumber + ":", "Output " + listNumber + ":");
		
		BigDecimal totalSalesTax = new BigDecimal(0);
		BigDecimal total = new BigDecimal(0);
		
		// loop over each item to print line items
		for (Item item: itemList) {
			Price tax = taxHelper.computeTax(item);
			Price duty = dutyHelper.computeImportDuty(item);
			BigDecimal itemTotal = item.getPrice().getValue().add(tax.getValue()).add(duty.getValue());
			total = total.add(itemTotal);
			totalSalesTax = totalSalesTax.add(tax.getValue()).add(duty.getValue());
			outputItemLine(item, itemTotal);
		}
		
		// print 'Sales tax' line and 'Total'
		output2ColumnLine("", String.format("Sales Tax:  %.2f", totalSalesTax));
		output2ColumnLine("", String.format("Total:  %.2f", total));
		outputDashLine();
		
	}
	
	/**
	 * Return something like this:
	 *    "1 book at 12.49       1 book : 12.49"
	 * @return
	 */
	private static void outputItemLine(Item item, BigDecimal priceWithTaxAndDuty) {
		String leftPart = String.format("1 %s at %.2f", item.getName(), item.getPrice().getValue());
		String rightPart = String.format("1 %s: %.2f", item.getName(), priceWithTaxAndDuty);
		output2ColumnLine(leftPart, rightPart);
		
	}
	
	/**
	 * Print a 2-colum line for proper vertical alignment, like "1 book at 12.49       1 book : 12.49"
	 * @param column1Str
	 * @param column2Str
	 */
	private static void output2ColumnLine(String column1Str, String column2Str) {
		System.out.printf("%-45s %s%n", column1Str,  column2Str);
	}
	
	private static void outputDashLine() {
		System.out.println("---------------------------------------------------------------------------------");
	}
}
