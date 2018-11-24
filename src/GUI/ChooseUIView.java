package GUI;

import javax.swing.*;

public class ChooseUIView extends View {
	private JButton customerInterfaceButton;
	
	public ChooseUIView(JFrame frame) {
		super(frame);
	}
	public JButton getCustomerInterfaceButton() {
		return customerInterfaceButton;
	}
	@Override
	public void Display() {
		mainPanel = new JPanel();
		mainPanel.setBounds(12, 45, 984, 659);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		customerInterfaceButton = new JButton("Use Customer Interface");
		customerInterfaceButton.setBounds(20, 20, 400, 100);
		customerInterfaceButton.setFocusPainted(false);
		mainPanel.add(customerInterfaceButton);
		
		mainPanel.setVisible(true);
	}

}
