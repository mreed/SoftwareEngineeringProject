package Interfaces;

import java.util.ArrayList;

import BusinessLogic.Item;

public abstract class IItemScanner {

	protected ArrayList<IOnItemNameScanned> namesScannedListeners = new ArrayList<IOnItemNameScanned>();
	protected ArrayList<IOnItemsScanned> itemScannedListeners = new ArrayList<IOnItemsScanned>();
	public abstract void scanItems();

	//This method return name of items that we are going to restock.
	public abstract void ScanInventoryItems(ArrayList<Item> inventoryItems);
	
	public void addScanItemListener(IOnItemsScanned listener) {
		 itemScannedListeners.add(listener);
	 }
	public void addNameScanListener(IOnItemNameScanned listener) {
		 namesScannedListeners.add(listener);
	 }

}