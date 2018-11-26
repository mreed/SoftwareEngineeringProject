package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.Item;

public class ScanItemsView extends View {

	private JTable itemList;
	private JLabel currentItem;
	private JButton btnSearchOrKey;
	private JLabel totalAmount;
	public JTable getItemList() {
		return itemList;
	}
	//adds the item to the list of items
	public void AddItemFromCart(Item item) {
		Object objs[] = {item.getName(),String.format("$%.2f", item.getPrice())};
		tableModel.addRow(objs);
	}
	public void setItemList(JTable itemList) {
		this.itemList = itemList;
	}

	public JLabel getCurrentItem() {
		return currentItem;
	}

	public JButton getBtnSearchOrKey() {
		return btnSearchOrKey;
	}

	public JLabel getTotalAmount() {
		return totalAmount;
	}

	public JButton getBtnPay() {
		return btnPay;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnSubtotal() {
		return btnSubtotal;
	}

	private JButton btnPay;
	private JButton btnCancel;
	private JButton btnSubtotal;
	private DefaultTableModel tableModel;

	public ScanItemsView(JFrame frame) {
		super(frame);
	}

	@Override
	public void Display() {
		mainPanel = new JPanel();
		mainPanel.setBounds(12, 45, 984, 659);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel scanItemsPanel = new JPanel();
		scanItemsPanel.setBounds(0, 0, 984, 659);
		mainPanel.add(scanItemsPanel);
		scanItemsPanel.setLayout(null);
		
		JPanel currentItemPanel = new JPanel();
		currentItemPanel.setBackground(new Color(255, 255, 255));
		currentItemPanel.setBounds(0, 12, 491, 330);
		scanItemsPanel.add(currentItemPanel);
		currentItemPanel.setLayout(null);
		currentItem = new JLabel();
		currentItem.setBounds(5,5,480,28);
		currentItemPanel.add(currentItem);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 250, 154));
		separator.setBounds(0, 348, 491, 9);
		scanItemsPanel.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 355, 491, 65);
		scanItemsPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblPleaseScanNext = new JLabel("Please scan next Item.");
		lblPleaseScanNext.setBounds(12, 14, 189, 28);
		panel.add(lblPleaseScanNext);
		try
		{
		BufferedImage searchImage = ImageIO.read(new File("./images/search3.png"));
		JLabel searchLbl = new JLabel(new ImageIcon(searchImage));
		panel.add(searchLbl);
		}
		catch(IOException ex) {
			
		}
		
		
		btnSearchOrKey = new JButton("Search or Key in Code");
		btnSearchOrKey.setBounds(246, 14, 233, 39);
		panel.add(btnSearchOrKey);
		
		
		String columns[] = {"Name", "Price"};
		tableModel = new DefaultTableModel(columns,0);
		itemList = new JTable(tableModel);
		itemList.setBounds(503, 12, 469, 517);
	
		
		scanItemsPanel.add(itemList);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(503, 532, 469, 15);
		scanItemsPanel.add(separator_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(503, 537, 469, 36);
		scanItemsPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(12, 12, 100, 16);
		panel_1.add(lblTotal);
		
		totalAmount = new JLabel("");
		totalAmount.setBounds(402, 12, 55, 16);
		panel_1.add(totalAmount);
		
		btnPay = new JButton("Pay $0.00");
		btnPay.setForeground(new Color(255, 255, 255));
		btnPay.setFont(new Font("Dialog", Font.BOLD, 26));
		btnPay.setHorizontalAlignment(SwingConstants.LEFT);
		btnPay.setBackground(new Color(0, 255, 127));
		btnPay.setBounds(503, 585, 469, 62);
		scanItemsPanel.add(btnPay);
		
		btnCancel = new JButton("Cancel Checkout");
		btnCancel.setBounds(12, 608, 131, 26);
		scanItemsPanel.add(btnCancel);
		
		btnSubtotal = new JButton("Subtotal");
		btnSubtotal.setBounds(172, 608, 98, 26);
		scanItemsPanel.add(btnSubtotal);
	}

}
