package GUI;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BusinessLogic.InventoryManager;
import BusinessLogic.Item;
import Interfaces.IOnItemNameScanned;
import Interfaces.IOnNewItem;
import Interfaces.IRestocker;
import softwareengineeringproject.Client;
import sun.net.www.content.audio.x_aiff;


public class RestockerController extends IRestocker implements IOnItemNameScanned {

	private RestockerView restockerView;
	private ItemScannerGUI itemScanner;
	private Client client;
	private NewItemView newItemView;

	public RestockerController(Client client) {
		this.client = client;
	}

	public void Init() {
		restockerView = new RestockerView(client.GetFrame());
		restockerView.Display();
		restockerView.getBtnRestock().addActionListener(x -> OnRestock());
	}

	private void OnRestock() {
		itemScanner = new ItemScannerGUI(client);
		itemScanner.addNameScanListener(this);
		restockerView.Hide();
		InventoryManager inventoryManager = new InventoryManager(itemScanner,this);
		inventoryManager.ScanItems();

	}

	@Override
	public void OnItemNameScanned(ArrayList<String> names) {
		restockerView.Show();
	}

	@Override
	public void Displaymenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getQuantity(String name) {
		
		
		while(true) {
		String result = JOptionPane.showInputDialog(client.GetFrame(),
				"Enter " + name + " quantity.",
				"Provide Quanity",
				JOptionPane.QUESTION_MESSAGE);
		try {
			int r = Integer.parseInt(result);
			return r;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(client.GetFrame(), "Please enter a valid quanity");
		}
		
		}
				
	
	}

	@Override
	public void DisplayQuantity(String name, int quanitty) {
		JOptionPane.showMessageDialog(client.GetFrame(),
			String.format("%s now has %d quantity", name,quanitty));
		
	}
	
	@Override
	public void getNewItemInfo(String name) {
		
		restockerView.Hide();
		newItemView = new NewItemView(client.GetFrame());
		newItemView.Display();
		newItemView.getName().setText(name);
		newItemView.getBtnCancel().addActionListener(x -> OnCancelNewItem());
		newItemView.getBtnSave().addActionListener(x -> OnSaveNewItem());
		
	}

	private void OnSaveNewItem() {
		String name = newItemView.getName().getText();
		String price = newItemView.getPrice().getText();
		String discount = newItemView.getDiscount().getText();
		boolean isAlcohol = newItemView.getChckbxIsAlcohol().isSelected();
		String quantity = newItemView.getQuantity().getText();
		if(name.isEmpty() || price.isEmpty() || quantity.isEmpty()) {
			JOptionPane.showMessageDialog(client.GetFrame(), "Name, Price and Quantity are required");
			return;
		}
		Item item = new Item();
		try {

			item.setPrice(Double.parseDouble(price));
			item.setName(name);
			item.setAlcohol(isAlcohol);
			item.setDiscount(Integer.parseInt(discount));
			item.setQuantity(Integer.parseInt(quantity));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(client.GetFrame(), "Price must be a decimal number, quantity and discount must be numbers.");
			return;
		}
		for(IOnNewItem listener : this.newItemListeners) {
			listener.OnNewItem(item);
		}
		newItemView.Hide();
		restockerView.Show();
	}

	private void OnCancelNewItem() {
		newItemView.Hide();
		restockerView.Show();
	}

	@Override
	public void Warning(String message) {
		JOptionPane.showMessageDialog(client.GetFrame(),message );
	}

	

}
