package GUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BusinessLogic.Item;

public class ManagerViewInventory extends View {

	private JLabel ShowName;
	private JLabel ShowPrice;
	private JLabel ShowDiscount;
	private JLabel ShowQuantity;
	private JButton btnOk;
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<String> itemNames = new ArrayList<String>();
	private JComboBox inventorySelect;
	private JCheckBox chckbxIsAlcohol;
	public ManagerViewInventory(JFrame frame, ArrayList<Item> items) {
		super(frame);
		this.items = items;
		itemNames.add(""); //initial blank
		for(Item item : items) {
			itemNames.add(item.getName());
		}
	}

	@Override
	public void Display() {
		mainPanel = new JPanel();
		mainPanel.setBounds(12, 45, 984, 659);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		inventorySelect = new JComboBox(itemNames.toArray());
		inventorySelect.setBounds(24, 67, 447, 55);
		mainPanel.add(inventorySelect);
		
		JLabel lblSelectItemFrom = new JLabel("Select Item from Inventory to View");
		lblSelectItemFrom.setBounds(27, 38, 268, 14);
		mainPanel.add(lblSelectItemFrom);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 172, 454, 200);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(20, 20, 46, 14);
		panel.add(lblName);
		
		 ShowName = new JLabel("");
		ShowName.setBounds(95, 20, 170, 14);
		panel.add(ShowName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(20, 54, 100, 14);
		panel.add(lblPrice);
		
		 ShowPrice = new JLabel("");
		ShowPrice.setBounds(95, 54, 170, 14);
		panel.add(ShowPrice);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBounds(20, 88, 100, 14);
		panel.add(lblDiscount);
		
		JLabel label = new JLabel("");
		label.setBounds(95, 100, 170, 14);
		panel.add(label);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(20, 122, 100, 14);
		panel.add(lblQuantity);
		
		chckbxIsAlcohol = new JCheckBox("Is Alcohol");
		chckbxIsAlcohol.setBounds(20, 156, 97, 23);
		chckbxIsAlcohol.setEnabled(false);
		panel.add(chckbxIsAlcohol);
		
		 ShowDiscount = new JLabel("");
		ShowDiscount.setBounds(95, 88, 170, 14);
		panel.add(ShowDiscount);
		
		 ShowQuantity = new JLabel("");
		ShowQuantity.setBounds(95, 122, 170, 14);
		panel.add(ShowQuantity);
		
		btnOk = new JButton("Ok");
		
		btnOk.setBounds(24, 522, 89, 23);
		mainPanel.add(btnOk);
		
	

	}

	public JCheckBox getChckbxIsAlcohol() {
		return chckbxIsAlcohol;
	}

	public JComboBox getInventorySelect() {
		return inventorySelect;
	}

	public JLabel getShowName() {
		return ShowName;
	}

	public JLabel getShowPrice() {
		return ShowPrice;
	}

	public JLabel getShowDiscount() {
		return ShowDiscount;
	}

	public JLabel getShowQuantity() {
		return ShowQuantity;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

}
