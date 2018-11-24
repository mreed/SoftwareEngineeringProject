package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import softwareengineeringproject.CheckoutCart;
import softwareengineeringproject.Item;

public class SelectPaymentMethodView extends View {
	private JTable table;
	private JButton btnPayWithDebitOrCC;

	private JButton btnPayWithCash;
	private DefaultTableModel tableModel;
	private JButton btnCancelPayment;
	private JLabel totalDue;

	public JTable getTable() {
		return table;
	}

	public JButton getBtnPayWithDebitOrCC() {
		return btnPayWithDebitOrCC;
	}


	public JLabel getTotalDue() {
		return totalDue;
	}
	public JButton getBtnPayWithCash() {
		return btnPayWithCash;
	}
	public JButton getBtnCancelPayment() {
		return btnCancelPayment;
	}
	public SelectPaymentMethodView(JFrame frame) {
		super(frame);
	}
	public void ShowCart(CheckoutCart cart) {
		for(Item i : cart.getItems()) {
			Object objs[] =  {i.getName(),String.format("$%.2f", i.getPrice())};
			tableModel.addRow(objs);
		}
	}
	@Override
	public void Display() {
		mainPanel = new JPanel();
		mainPanel.setBounds(12, 45, 984, 659);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		String columns[] = {"Name","Price"};
		tableModel = new DefaultTableModel(columns,0);
		
		table = new JTable(tableModel);
		table.setBounds(21, 24, 387, 528);
		mainPanel.add(table);
		totalDue = new JLabel("");
		totalDue.setBounds(252, 593, 92, 14);
		mainPanel.add(totalDue);
		
	    btnPayWithDebitOrCC = new JButton("Pay with Debit/Credit Card");
		btnPayWithDebitOrCC.setBounds(430, 225, 200, 70);
		mainPanel.add(btnPayWithDebitOrCC);
		
	
		
		btnPayWithCash = new JButton("Pay with Cash");
		btnPayWithCash.setBounds(430, 303, 200, 70);
		mainPanel.add(btnPayWithCash);
		
		JLabel lblSelectPaymentMethod = new JLabel("Select Payment Method");
		lblSelectPaymentMethod.setBounds(430, 138, 413, 58);
		mainPanel.add(lblSelectPaymentMethod);
		
		btnCancelPayment = new JButton("Cancel Payment");
		btnCancelPayment.setBounds(430, 555, 200, 58);
		mainPanel.add(btnCancelPayment);

	}

	

	

}
