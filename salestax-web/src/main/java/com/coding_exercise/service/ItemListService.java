package com.coding_exercise.service;

import java.util.List;
import java.util.Map;

import com.coding_exercise.item.ShowList;

/**
 * Allows to query the list of items based on list key, like "Input 1".
 * @author papa
 *
 */
public interface ItemListService {
	
	/**
	 * @return List nb selected by user, 1,2,3, etc
	 */
	String getSelectedList();
	void setSelectedList(String listId);
	
	/**
	 * Map to build the listbox
	 * @return
	 */
	Map<String, String> getAvailableLists();

	/**
	 * Map to build the listbox
	 * @return
	 */
	Map<Integer, String> getAvailableListsNew();

	/**
	 * @return the number of available lists.
	 */
	int getNbList();

	/**
	 * Find the queried list.
	 * @return
	 */
	String fetchList();

	/**
	 * @return The list of items corresponding to the selected key.
	 */
	//List<List<Item>> getResultLists();
	/**
	 * @return The Map of Maps. The first map is keyed on the item index, like '1' or '2'. The second map
	 */
	 List<ShowList> getShowResults();
	
	

}