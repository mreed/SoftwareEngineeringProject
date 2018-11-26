package Interfaces;

import java.util.ArrayList;

public abstract class IRestocker {
	protected ArrayList<IOnNewItem> newItemListeners = new ArrayList<IOnNewItem>();
	
	public void addNewItemListener(IOnNewItem listener) {
		newItemListeners.add(listener);
	}
	abstract public void Displaymenu();
	
	abstract public int getQuantity(String name);
	
	abstract public void DisplayQuantity(String name, int quanitty);
	
	abstract public void getNewItemInfo(String name);
	abstract public void Warning(String message);
	
}