package GUI;

import javax.swing.*;

import Console.RestockerInterface;

public class ChooseUIView extends View {
	private JButton customerInterfaceButton;
	private JButton restockerInterface;
	private JButton managerInterface;
	
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
		restockerInterface.setBounds(20, 130, 400, 100);
		restockerInterface.setFocusPainted(false);
		mainPanel.add(restockerInterface);
		
		managerInterface = new JButton("Use manager Interface");
		managerInterface.setBounds(20, 250, 400, 100);
		managerInterface.setFocusPainted(false);
		mainPanel.add(managerInterface);
		
		mainPanel.setVisible(true);
	}
	public JButton getManagerInterface() {
		return managerInterface;
	}

}
