package com.coding_exercise.item;

/**
 * Represents an item with a name and price. 
 * @author thanh nguyen
 *
 */
public interface Item {
	
	public ItemType getType();
	public Price getPrice();
	public String getName();
	public boolean isImported();

}
