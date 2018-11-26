package GUI;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import BusinessLogic.Item;

public class ScanInventoryView extends View {

	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<String> itemNames = new ArrayList<String>();
	private JComboBox scanner;
	private DefaultListModel<String> listItems = new DefaultListModel<String>();
	private JButton btnDoneScanning;
	private JButton btnCancel;
	public ScanInventoryView(JFrame frame,ArrayList<Item> items) {
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
		
		scanner = new JComboBox(itemNames.toArray());
		scanner.setEditable(true);
		scanner.setBounds(33, 88, 524, 72);
		mainPanel.add(scanner);
		
		JList selectedItemsList = new JList(listItems);
		selectedItemsList.setBounds(594, 95, 361, 467);
		mainPanel.add(selectedItemsList);
		
		JLabel lblSelectedItems = new JLabel("Selected Items");
		lblSelectedItems.setBounds(594, 61, 353, 26);
		mainPanel.add(lblSelectedItems);
		
		JLabel lblSelectItemTo = new JLabel("Select Item to scan or type name of new item. (Only one new item may be added.");
		lblSelectItemTo.setBounds(36, 51, 521, 26);
		mainPanel.add(lblSelectItemTo);
		
		JLabel lblItemScanner = new JLabel("Item Inventory Scanner");
		lblItemScanner.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblItemScanner.setBounds(36, 11, 521, 29);
		mainPanel.add(lblItemScanner);
		
		btnDoneScanning = new JButton("Done Scanning");
		btnDoneScanning.setBounds(590, 590, 171, 58);
		mainPanel.add(btnDoneScanning);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(784, 590, 171, 58);
		mainPanel.add(btnCancel);
		

	}

	public JComboBox getScanner() {
		return scanner;
	}

	public DefaultListModel<String> getListItems() {
		return listItems;
	}

	public JButton getBtnDoneScanning() {
		return btnDoneScanning;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

}
