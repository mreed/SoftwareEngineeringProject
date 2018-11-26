package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewItemView extends View {

	private JTextField name;
	private JCheckBox chckbxIsAlcohol;
	private JTextField quantity;
	private JTextField price;
	private JTextField discount;
	private JButton btnSave;
	private JButton btnCancel;

	public NewItemView(JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Display() {
		 	mainPanel = new JPanel();
			mainPanel.setBounds(12, 45, 984, 659);
			frame.getContentPane().add(mainPanel);
			mainPanel.setLayout(null);
			
			JLabel lblAddNewItem = new JLabel("Add New Item");
			lblAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 32));
			lblAddNewItem.setBounds(10, 11, 286, 55);
			mainPanel.add(lblAddNewItem);
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(42, 126, 84, 24);
			mainPanel.add(lblName);
			
			JLabel lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(42, 200, 100, 25);
			mainPanel.add(lblQuantity);
			
			JLabel lblDiscount = new JLabel("Discount");
			lblDiscount.setBounds(42, 253, 100, 25);
			mainPanel.add(lblDiscount);
			
			JLabel lblPrice = new JLabel("Price");
			lblPrice.setBounds(42, 228, 100, 25);
			mainPanel.add(lblPrice);
			
			name = new JTextField();
			name.setBounds(171, 128, 286, 20);
			mainPanel.add(name);
			name.setColumns(10);
			
			chckbxIsAlcohol = new JCheckBox("Is Alcohol");
			chckbxIsAlcohol.setBounds(171, 167, 97, 23);
			mainPanel.add(chckbxIsAlcohol);
			
			quantity = new JTextField();
			quantity.setBounds(171, 197, 86, 20);
			mainPanel.add(quantity);
			quantity.setColumns(10);
			
			price = new JTextField();
			price.setBounds(171, 225, 86, 20);
			mainPanel.add(price);
			price.setColumns(10);
			
			discount = new JTextField();
			discount.setBounds(171, 250, 86, 20);
			mainPanel.add(discount);
			discount.setColumns(10);
			
			btnSave = new JButton("Save");
			btnSave.setBounds(42, 535, 89, 23);
			mainPanel.add(btnSave);
			
			btnCancel = new JButton("Cancel");
			btnCancel.setBounds(151, 535, 89, 23);
			mainPanel.add(btnCancel);
			
			

	}

	public JTextField getName() {
		return name;
	}

	public JCheckBox getChckbxIsAlcohol() {
		return chckbxIsAlcohol;
	}

	public JTextField getQuantity() {
		return quantity;
	}

	public JTextField getPrice() {
		return price;
	}

	public JTextField getDiscount() {
		return discount;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

}
