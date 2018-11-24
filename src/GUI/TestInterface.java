package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;

public class TestInterface {

	private JFrame frame;
	private JTable table;
	private JButton btnPayWithDebit;
	private JButton btnPayWithCredit;
	private JButton btnPayWithCash;
	private JButton btnCancelPayment;
	private JLabel lblTotalDue;
	private JLabel totalDue;

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
		
		table = new JTable();
		table.setBounds(21, 24, 387, 528);
		mainPanel.add(table);
		totalDue = new JLabel("");
		totalDue.setBounds(252, 593, 92, 14);
		mainPanel.add(totalDue);
		
	    btnPayWithDebit = new JButton("Pay with Debit");
		btnPayWithDebit.setBounds(430, 225, 200, 70);
		mainPanel.add(btnPayWithDebit);
		
		btnPayWithCredit = new JButton("Pay with Credit");
		btnPayWithCredit.setBounds(643, 225, 200, 70);
		mainPanel.add(btnPayWithCredit);
		
		btnPayWithCash = new JButton("Pay with Cash");
		btnPayWithCash.setBounds(430, 303, 200, 70);
		mainPanel.add(btnPayWithCash);
		
		JLabel lblSelectPaymentMethod = new JLabel("Select Payment Method");
		lblSelectPaymentMethod.setBounds(430, 138, 413, 58);
		mainPanel.add(lblSelectPaymentMethod);
		
		btnCancelPayment = new JButton("Cancel Payment");
		btnCancelPayment.setBounds(430, 555, 200, 58);
		mainPanel.add(btnCancelPayment);
		
		lblTotalDue = new JLabel("Total Due");
		lblTotalDue.setBounds(25, 583, 192, 34);
		mainPanel.add(lblTotalDue);
		
		
	}
}
