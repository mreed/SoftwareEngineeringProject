package GUI;

import java.io.IOException;

import javax.swing.*;

public abstract class View {
	protected JFrame frame;
	protected JPanel mainPanel;
	public View(JFrame frame) {
		this.frame = frame;
	}
	public void Hide() {
		mainPanel.setVisible(false);
	}
	public void Show() {
		mainPanel.setVisible(true);
	}
	public abstract void Display();
}
