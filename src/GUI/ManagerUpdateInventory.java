package GUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BusinessLogic.Item;

public class ManagerUpdateInventory extends View {

	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<String> itemNames = new ArrayList<String>();
	private JComboBox inventorySelect;
	private JCheckBox chckbxIsAlcohol;
	private JTextField ShowName;
	private JTextField ShowPrice;
	private JTextField ShowDiscount;

	private JButton btnOk;
	private JButton btnCancel;
	public ManagerUpdateInventory(JFrame frame, ArrayList<Item> items) {
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
		
		JLabel lblSelectItemFrom = new JLabel("Select Item from Inventory to Update");
		lblSelectItemFrom.setBounds(27, 38, 268, 14);
		mainPanel.add(lblSelectItemFrom);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 172, 454, 200);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(20, 20, 46, 14);
		panel.add(lblName);
		
		 ShowName = new JTextField("");
		ShowName.setBounds(95, 20, 238, 14);
		ShowName.setEnabled(false);
		panel.add(ShowName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(20, 54, 100, 14);
		panel.add(lblPrice);
		
		 ShowPrice = new JTextField("");
		ShowPrice.setBounds(95, 54, 56, 14);
		panel.add(ShowPrice);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBounds(20, 88, 100, 14);
		panel.add(lblDiscount);
		
		
		
		
		
		 chckbxIsAlcohol = new JCheckBox("Is Alcohol");
		chckbxIsAlcohol.setBounds(20, 156, 97, 23);
		panel.add(chckbxIsAlcohol);
		
		 ShowDiscount = new JTextField("");
		ShowDiscount.setBounds(95, 88, 56, 14);
		panel.add(ShowDiscount);
		
		
		 btnOk = new JButton("Ok");
		
		btnOk.setBounds(24, 522, 89, 23);
		mainPanel.add(btnOk);
		
	    btnCancel = new JButton("Cancel");
		btnCancel.setBounds(124, 522, 89, 23);
		mainPanel.add(btnCancel);
		
	

	}
	public JComboBox getInventorySelect() {
		return inventorySelect;
	}
	public JCheckBox getChckbxIsAlcohol() {
		return chckbxIsAlcohol;
	}
	public JTextField getShowName() {
		return ShowName;
	}
	public JTextField getShowPrice() {
		return ShowPrice;
	}
	public JTextField getShowDiscount() {
		return ShowDiscount;
	}
	
	public JButton getBtnOk() {
		return btnOk;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}

}
