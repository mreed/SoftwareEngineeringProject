package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestInterface {

	private JFrame frame;
	private JTable table;
	private JButton btnPayWithDebit;
	private JButton btnPayWithCredit;
	private JButton btnPayWithCash;
	private JButton btnCancelPayment;
	private JLabel lblTotalDue;
	private JLabel totalDue;
	private JTextField name;
	private JTextField quantity;
	private JTextField price;
	private JTextField discount;

	public JTable getTable() {
		return table;
	}

	public JButton getBtnPayWithDebit() {
		return btnPayWithDebit;
	}

	public JButton getBtnPayWithCredit() {
		return btnPayWithCredit;
	}

	public JButton getBtnPayWithCash() {
		return btnPayWithCash;
	}

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestInterface window = new TestInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public TestInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(12, 45, 984, 659);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JComboBox inventorySelect = new JComboBox();
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
		
		JTextField ShowName = new JTextField("");
		ShowName.setBounds(95, 20, 238, 14);
		panel.add(ShowName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(20, 54, 100, 14);
		panel.add(lblPrice);
		
		JTextField ShowPrice = new JTextField("");
		ShowPrice.setBounds(95, 54, 56, 14);
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
		
		JCheckBox chckbxIsAlcohol = new JCheckBox("Is Alcohol");
		chckbxIsAlcohol.setBounds(20, 156, 97, 23);
		panel.add(chckbxIsAlcohol);
		
		JTextField ShowDiscount = new JTextField("");
		ShowDiscount.setBounds(95, 88, 56, 14);
		panel.add(ShowDiscount);
		
		JTextField ShowQuantity = new JTextField("");
		ShowQuantity.setBounds(95, 122, 56, 14);
		panel.add(ShowQuantity);
		
		JButton btnOk = new JButton("Ok");
		
		btnOk.setBounds(24, 522, 89, 23);
		mainPanel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(124, 522, 89, 23);
		mainPanel.add(btnCancel);
		
	
	
		
		
		
	}
}
