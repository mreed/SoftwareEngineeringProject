package softwareengineeringproject;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import GUI.CheckOutManager;
import GUI.ChooseUIController;

public class Client {
	private CheckOutManager checkoutManager;
	private JFrame frame;
	public JFrame GetFrame() {
		return frame;
	}
	public void Start() {
	
		// TODO Auto-generated method stub
		//create choice interface
		//from choose interface make the right ui.
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Our Store");
		frame.setVisible(true);
		JLabel lblWelcome = new JLabel("Welcome to Our Store");
		lblWelcome.setBackground(SystemColor.activeCaption);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcome.setBounds(12, 12, 653, 38);
		frame.getContentPane().add(lblWelcome);
		ChooseUIController controller = new ChooseUIController(this);
		controller.Init();
		
		
	}
	public void ShowCustomerInterface() {
		checkoutManager = new CheckOutManager(this);
		checkoutManager.Init();
	}

}
