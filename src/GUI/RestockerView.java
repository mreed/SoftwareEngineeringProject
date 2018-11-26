package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class RestockerView extends View  {

	private JButton btnRestock;

	public RestockerView(JFrame frame) {
		super(frame);
	}

	@Override
	public void Display() {
		mainPanel = new JPanel();
		mainPanel.setBounds(12, 45, 984, 659);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		btnRestock = new JButton("Restock");
		btnRestock.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnRestock.setBounds(44, 43, 418, 115);
		mainPanel.add(btnRestock);

	}

	public JButton getBtnRestock() {
		return btnRestock;
	}

	

	

}
