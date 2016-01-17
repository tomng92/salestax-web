package com.coding_exercise.item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Used for the display of item lists.
 * This is to make jsf easier.
 * @author papa
 *
 */
public class ShowList {
	private String name; // eg. "1" which is the index of the list.
	
	private List<Map<String, String>> items;// the left and right hand column values.
	
	private BigDecimal total;
	private BigDecimal totalTax;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Map<String, String>> getItems() {
		return items;
	}
	public void setItems(List<Map<String, String>> items) {
		this.items = items;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

}
