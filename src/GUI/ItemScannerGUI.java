package GUI;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import BusinessLogic.Item;
import Interfaces.IItemScanner;
import Interfaces.IOnItemNameScanned;
import softwareengineeringproject.Client;


public class ItemScannerGUI extends IItemScanner {

	private JFrame frame;
	private ScanInventoryView inventoryView;
	private ArrayList<String> selectedItems = new ArrayList<String>();
	
	public ItemScannerGUI(Client client) {
		this.frame = client.GetFrame();
	}
	@Override
	public void scanItems() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ScanInventoryItems(ArrayList<Item> inventoryItems) {
		inventoryView = new ScanInventoryView(this.frame, inventoryItems);
		inventoryView.Display();
		inventoryView.getBtnCancel().addActionListener(x -> OnCancelScan());
		inventoryView.getBtnDoneScanning().addActionListener(x_-> OnDoneScanning());
		inventoryView.getScanner().addActionListener(x -> OnItemScanned(x));
		

	}
	private void OnItemScanned(ActionEvent e) {
		String itemName = (String)inventoryView.getScanner().getSelectedItem();
		if(!itemName.isEmpty() && (selectedItems.indexOf(itemName) == -1)) {
			
		selectedItems.add(itemName);
		inventoryView.getListItems().addElement(itemName);
		inventoryView.getScanner().setSelectedIndex(0);
		}
	}
	private void OnCancelScan() {
		inventoryView.Hide();
		selectedItems = new ArrayList<String>();
		for(IOnItemNameScanned listener : this.namesScannedListeners) {
			listener.OnItemNameScanned(selectedItems); //send empty arraylist to signal action is cancelled.
		}
	}
	private void OnDoneScanning() {
		inventoryView.Hide();
		for(IOnItemNameScanned listener : this.namesScannedListeners) {
			listener.OnItemNameScanned(selectedItems);
		}
		
	}

}
