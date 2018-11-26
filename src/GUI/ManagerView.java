package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManagerView extends View {

	private JButton btnView;
	private JButton btnUpdate;

	public ManagerView(JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Display() {
		mainPanel = new JPanel();
		mainPanel.setBounds(12, 45, 984, 659);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		btnView = new JButton("View Inventory");
		btnView.setBounds(61, 68, 309, 82);
		mainPanel.add(btnView);
		
		btnUpdate = new JButton("Update Inventory");
		btnUpdate.setBounds(61, 181, 309, 82);
		mainPanel.add(btnUpdate);

	}

	public JButton getBtnView() {
		return btnView;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

}
