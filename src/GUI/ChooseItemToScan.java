package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import softwareengineeringproject.Item;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;

public class ChooseItemToScan extends JDialog {
	JButton okButton = new JButton("OK");

	private final JPanel contentPanel = new JPanel();

	private JButton cancelButton;

	private JComboBox selectItemDDL;
	public String getSelectedItem() {
		return (String)selectItemDDL.getSelectedItem();
	}
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ChooseItemToScan dialog = new ChooseItemToScan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ChooseItemToScan(String[] items,boolean allowNewItems) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSelectItemTo = new JLabel("Select Item to add to your Purchase");
		lblSelectItemTo.setBounds(10, 11, 173, 14);
		contentPanel.add(lblSelectItemTo);
		
		selectItemDDL = new JComboBox(items);
		if(allowNewItems) {
			selectItemDDL.setEditable(true);
		}
		
		selectItemDDL.setBounds(10, 53, 414, 31);
		selectItemDDL.addActionListener(e -> OnSelectItem(e));
		contentPanel.add(selectItemDDL);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.setEnabled(false);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	private void OnSelectItem(ActionEvent e) {
		if(!this.getSelectedItem().isEmpty())
			okButton.setEnabled(true);
	}
}
