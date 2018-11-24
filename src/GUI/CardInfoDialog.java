package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CardInfoDialog extends JDialog {
	private JTextField textField;
	private JButton okButton;
	private JRadioButton rdbtnDebit;
	private JRadioButton rdbtnCrdit;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			CardInfoDialog dialog = new CardInfoDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public CardInfoDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.setEnabled(false);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		rdbtnDebit = new JRadioButton("Debit");
		rdbtnDebit.setBounds(10, 7, 109, 33);
		getContentPane().add(rdbtnDebit);
		rdbtnDebit.addActionListener(x -> OnDebit(x));
		
		
		rdbtnCrdit = new JRadioButton("Credit");
		rdbtnCrdit.setBounds(10, 46, 109, 23);
		getContentPane().add(rdbtnCrdit);
		rdbtnCrdit.addActionListener(x -> OnCredit(x));
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCrdit);
		group.add(rdbtnDebit);
		
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(10, 96, 63, 14);
		getContentPane().add(lblCardNumber);
		
		textField = new JTextField();
		textField.setBounds(10, 121, 151, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(x -> OnCreditCardNumber(x));
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JRadioButton getRdbtnDebit() {
		return rdbtnDebit;
	}

	public JRadioButton getRdbtnCrdit() {
		return rdbtnCrdit;
	}

	private void OnDebit(ActionEvent x) {
		if(!textField.getText().isEmpty())
			this.okButton.setEnabled(true);
	}

	private void OnCredit(ActionEvent x) {
		if(!textField.getText().isEmpty())
			this.okButton.setEnabled(true);
	}

	private void OnCreditCardNumber(ActionEvent x) {
		if(textField.getText().isEmpty())
			return;
		if(this.rdbtnCrdit.isSelected() || this.rdbtnDebit.isSelected()) {
			this.okButton.setEnabled(true);
		}
	}
}
