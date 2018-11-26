package Interfaces;

import java.util.ArrayList;

import BusinessLogic.Item;

public interface IItemScanner {

	void scanItems();

	//This method return name of items that we are going to restock.
	void ScanInventoryItems(ArrayList<Item> inventoryItems);
	
	void addScanItemListener(IOnItemsScanned listener);
	void addNameScanListener(IOnItemNameScanned listener);

}