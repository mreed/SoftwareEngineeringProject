package GUI;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomeView extends View {
	private JButton btnBeginCheckout;
	public JButton getBeginCheckoutButton() {
		return btnBeginCheckout;
	}
	public WelcomeView(JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Display() {
		mainPanel = new JPanel();
		mainPanel.setBounds(12, 45, 984, 659);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		btnBeginCheckout =new JButton("Begin Checkout");
		btnBeginCheckout.setBounds(635, 331, 319, 81);
		btnBeginCheckout.setFocusPainted(false);
		mainPanel.add(btnBeginCheckout);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWelcome.setBounds(635, 224, 205, 56);
		mainPanel.add(lblWelcome);
		
		JLabel lblClickBelowTo = new JLabel("Click below to begin scanning your items");
		lblClickBelowTo.setBounds(635, 291, 231, 16);
		mainPanel.add(lblClickBelowTo);
		
		JPanel welcomeImagePanel = new JPanel();
		welcomeImagePanel.setBounds(0, 0, 590, 613);
		mainPanel.add(welcomeImagePanel);
		BufferedImage welcomeImage;
		try
		{
		welcomeImage = null;
		welcomeImage = ImageIO.read(new File("./images/shoppingCart.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(welcomeImage));
		welcomeImagePanel.add(picLabel);
		}
		catch(IOException ex) {
			
		}
		
		mainPanel.setVisible(true); 
	}

}
