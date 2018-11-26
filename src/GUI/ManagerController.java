package GUI;

import javax.swing.JOptionPane;

import BusinessLogic.InventoryManager;
import BusinessLogic.Item;
import Interfaces.IOnNewItem;
import softwareengineeringproject.Client;


public class ManagerController extends Controller {

	private ManagerView managerView;
	private ManagerViewInventory managerInventoryView;
	private ManagerUpdateInventory managerInventoryUpdate;
	InventoryManager iManager = new InventoryManager();
	public ManagerController(Client client) {
		super(client);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Init() {
		managerView = new ManagerView(client.GetFrame());
		managerView.Display();
		managerView.getBtnUpdate().addActionListener(x -> OnUpdateInventory());
		managerView.getBtnView().addActionListener(x -> OnViewInventory());

	}

	private void OnViewInventory() {
		managerView.Hide();
		
		managerInventoryView = new ManagerViewInventory(client.GetFrame(),iManager.RetrieveInventory());
		managerInventoryView.Display();
		managerInventoryView.getBtnOk().addActionListener(e -> OnFinishView());
		managerInventoryView.getInventorySelect().addActionListener(e -> OnSelectItemToView());
		
		
	}

	private void OnSelectItemToView() {
		String itemName = (String) managerInventoryView.getInventorySelect().getSelectedItem();
		Item item = iManager.RetrieveItem(itemName);
		if(item != null) {
			managerInventoryView.getChckbxIsAlcohol().setSelected(item.isAlcohol());
			managerInventoryView.getShowDiscount().setText(Integer.toString(item.getDiscount()));
			managerInventoryView.getShowName().setText(item.getName());
			managerInventoryView.getShowPrice().setText(Double.toString(item.getPrice()));
			managerInventoryView.getShowQuantity().setText(Integer.toString(item.getQuantity()));
		}
		
	}

	private void OnFinishView() {
		managerInventoryView.Hide();
		managerView.Show();
	}

	private void OnUpdateInventory() {
		managerView.Hide();
		managerInventoryUpdate = new ManagerUpdateInventory(client.GetFrame(),iManager.RetrieveInventory());
		managerInventoryUpdate.Display();
		managerInventoryUpdate.getBtnOk().addActionListener(e -> OnUpdateItem());
		managerInventoryUpdate.getBtnCancel().addActionListener(e -> OnCancelUpdate());
		managerInventoryUpdate.getInventorySelect().addActionListener(e -> OnSelectItemToUpdate());
		
	}

	private void OnSelectItemToUpdate() {
		String itemName = (String) managerInventoryUpdate.getInventorySelect().getSelectedItem();
		Item item = iManager.RetrieveItem(itemName);
		if(item != null) {
			managerInventoryUpdate.getChckbxIsAlcohol().setSelected(item.isAlcohol());
			managerInventoryUpdate.getShowDiscount().setText(Integer.toString(item.getDiscount()));
			managerInventoryUpdate.getShowName().setText(item.getName());
			managerInventoryUpdate.getShowPrice().setText(Double.toString(item.getPrice()));
			
		}
	}

	private void OnCancelUpdate() {
		managerInventoryUpdate.Hide();
		managerView.Show();
	}

	private void OnUpdateItem() {
		String name = managerInventoryUpdate.getShowName().getText();
		String price = managerInventoryUpdate.getShowPrice().getText();
		String discount = managerInventoryUpdate.getShowDiscount().getText();
		boolean isAlcohol = managerInventoryUpdate.getChckbxIsAlcohol().isSelected();
		
		if(name.isEmpty() || price.isEmpty()) {
			JOptionPane.showMessageDialog(client.GetFrame(), "Name and Price are required");
			return;
		}
		Item item = new Item();
		try {

			item.setPrice(Double.parseDouble(price));
			item.setName(name);
			item.setAlcohol(isAlcohol);
			item.setDiscount(Integer.parseInt(discount));
			
			boolean result = iManager.UpdateDatabase(item);
			if(!result) {
				JOptionPane.showMessageDialog(client.GetFrame(),"Could not update Item.");
				return;
			}
			JOptionPane.showMessageDialog(client.GetFrame(),item.getName() + " successfully updated.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(client.GetFrame(), "Price must be a decimal number, quantity and discount must be numbers.");
			return;
		}
	/*	managerInventoryView.getChckbxIsAlcohol().setSelected(false);
		managerInventoryView.getShowDiscount().setText("");
		managerInventoryView.getShowName().setText("");
		managerInventoryView.getShowPrice().setText("");
		managerInventoryView.getShowQuantity().setText("");*/
		
	}

}
