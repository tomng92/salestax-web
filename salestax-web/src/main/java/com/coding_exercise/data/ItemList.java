package com.coding_exercise.data;

import java.util.List;

import com.coding_exercise.item.Item;

/**
 * Store the list of item lists.
 * @author thanh nguyen
 *
 */
public class ItemList {

	private List<List<Item>> itemListList;

	public List<List<Item>> getItemListList() {
		return itemListList;
	}

	public void setItemListList(List<List<Item>> itemListList) {
		this.itemListList = itemListList;
	}
	
}
