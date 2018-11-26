package GUI;

import javax.swing.*;

import Console.RestockerInterface;

public class ChooseUIView extends View {
	private JButton customerInterfaceButton;
	private JButton restockerInterface;
	
	public ChooseUIView(JFrame frame) {
		super(frame);
	}
	public JButton getCustomerInterfaceButton() {
		return customerInterfaceButton;
	}
	public JButton getRestockerInterfaceButton() {
		return restockerInterface;
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
		
		restockerInterface = new JButton("Use restocker Interface");
		restockerInterface.setBounds(20, 20, 400, 100);
		restockerInterface.setFocusPainted(false);
		mainPanel.add(restockerInterface);
		
	
		
		mainPanel.setVisible(true);
	}

}
