package com.coding_exercise.item;

/** 
 * Item implementation.
 * @author thanh nguyen
 */
public class ItemImpl implements Item {
	private Price price;// price without tax.
	private String name;
	private boolean imported;
	private ItemType type;
	
	public void setType(ItemType type) {
		this.type = type;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	
	// default ctor for Spring
	public ItemImpl() {}
	
	// Regular ctor.
	public ItemImpl(String name, ItemType type, double price, boolean imported) {
		this.name = name;
		this.type = type;
		this.price = new Price(price);
		this.imported = imported;
	}

	@Override
	public ItemType getType() {
		return type;
	}

	@Override
	public Price getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isImported() {
		return imported;
	}

}
