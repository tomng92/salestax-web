package com.coding_exercise.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coding_exercise.data.ItemList;
import com.coding_exercise.item.Item;
import com.coding_exercise.item.Price;
import com.coding_exercise.item.ShowList;
import com.coding_exercise.tax.ImportDutyCalculator;
import com.coding_exercise.tax.SalesTaxCalculator;

/**
 * Service for querying the list of items.
 * @author thanh nguyen
 *
 */
@Component("itemListService")
public class ItemListServiceImpl implements ItemListService {
	
	@Autowired
	private ItemList itemList;
	@Autowired
	private SalesTaxCalculator taxCalculator;
	@Autowired
	private ImportDutyCalculator dutyCalculator;

	private List<List<Item>> resultList;// keeps list selected by the user.
	

	public String selectedList;// item selected by user, "1", "2", .. or "ALL".
	
	public String getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(String selection) {
		this.selectedList = selection;
	}

	public void setItemList(ItemList itemList) {
		this.itemList = itemList;
 	}
	
	/**
	 * @see com.coding_exercise.service.ItemListService#getListKeys()
	 */
	@Override
	public int getNbList() {
		return itemList.getItemListList().size();
	}

	/**
	 * Invoked after user selects an item.
	 * @see com.coding_exercise.service.ItemListService#fetchList()
	 */
	@Override
	public String fetchList() {
		
		// if list index desired is -1, this means we want "ALL" lists.
		if (selectedList.equals("ALL")) {
			resultList = itemList.getItemListList();
		} else {
		
			// TODO check parse exception... if still have time.
			int itemIndex = Integer.parseInt(selectedList);
			
			// otherwise return the list wanted
			resultList = new ArrayList<List<Item>>();
			resultList.add(itemList.getItemListList().get(itemIndex)); 
		}
		
		// display the result
		return "showList";
	}

	/**
	 * @see com.coding_exercise.service.ItemListService#getAvailableLists()
	 */
	@Override
	public Map<String, String> getAvailableLists() {
		Map<String, String> availLists; // map used to build the listbox

		availLists = new LinkedHashMap<String, String>();
		for (int i = 0; i < itemList.getItemListList().size(); i++) {
			availLists.put( "Input " + (i + 1), i + "");
		}

		return availLists;
	}

	@Override
	public Map<Integer, String> getAvailableListsNew() {
		Map<String, String> list = getAvailableLists();

		Map<Integer, String> availLists; // map used to build the listbox

		availLists = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < list.size(); i++) {
			availLists.put( i, i + "");
		}
		for (int i = 0; i < list.size(); i++) {
			availLists.put( i, i + "");
		}

		return availLists;

	}

	
	
	/**
	 * @see com.coding_exercise.service.ItemListService#getShowResults()
	 * @TODO Add test and refactor-extract!!
	 */
	@Override
	public List<ShowList> getShowResults() {
		List<ShowList> results = new ArrayList<ShowList>();
		for (int i = 0; i < resultList.size(); i++) {
			ShowList showList = new ShowList();
			results.add(showList);
			
			if (selectedList.equals("ALL")) {
				showList.setName(i + 1 + ""); // list name is simply its index.
			} else {
				showList.setName((Integer.parseInt(selectedList) + 1) + "");// need to add 1 because start with 0
				
			}
			
			List<Item> items = resultList.get(i);
			BigDecimal totalSalesTax = new BigDecimal(0);
			BigDecimal total = new BigDecimal(0);
			List<Map<String, String>> itemRows = new ArrayList<Map<String, String>>();
			
			for (Item item: items) {
				Map<String, String> itemRow = new Hashtable<String, String>(); 
				Price tax = taxCalculator.computeTax(item);
				Price duty = dutyCalculator.computeImportDuty(item);
				BigDecimal itemTotal = item.getPrice().getValue().add(tax.getValue()).add(duty.getValue());
				itemRow.put("leftside", String.format("1 %s at %.2f", item.getName(), item.getPrice().getValue()));// example "1 book at 12.49
				itemRow.put("rightside", String.format("1 %s: %.2f", item.getName(), itemTotal));// example: "1 book : 12.49"
				total = total.add(itemTotal);
				totalSalesTax = totalSalesTax.add(tax.getValue()).add(duty.getValue());
				
				itemRows.add(itemRow);
			}
			
			// output the sales tax and total line
			Map<String, String> itemRow = new Hashtable<String, String>(); 
			itemRow.put("leftside", "");
			itemRow.put("rightside", String.format("Sales Tax: %.2f", totalSalesTax));
			itemRows.add(itemRow);
			
			itemRow = new Hashtable<String, String>(); 
			itemRow.put("leftside", "");
			itemRow.put("rightside", String.format("Total: %.2f", total));
			itemRows.add(itemRow);

			showList.setItems(itemRows);
			showList.setTotal(total);
			showList.setTotalTax(totalSalesTax);
		}
		
	return results;
		
	}

}
