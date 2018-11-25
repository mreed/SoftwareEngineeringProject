package GUI;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.View;
import softwareengineeringproject.ICardReader;

public class CardReaderView extends View implements ICardReader {

	private CardInfoDialog dialog;
	private boolean dialogOked;
	public CardReaderView(JFrame frame) {
		super(frame);
	}

	@Override
	public String[] GetCardInfo() {
		String[] result = new String[2];
		String[] cardType = {"Credit","Debit"};
		result[0] = (String)JOptionPane.showInputDialog(
				frame,
				"Is this credit or debit?",
				"Credit or Debit",
				JOptionPane.QUESTION_MESSAGE,
				null,
				cardType,
				null);
		result[1] = JOptionPane.showInputDialog(frame,
				"Enter your Card Number",
				"Card Number",
				JOptionPane.DEFAULT_OPTION);
		return result;

	}

	@Override
	public int Debit() {
		 String result = JOptionPane.showInputDialog(frame,
					"Please enter your pin number.",
					"Debit Pin Number",
					JOptionPane.DEFAULT_OPTION);
		try {
			int x = Integer.parseInt(result);
			return x;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,"Invalid pin number.");
			return -1;
		}
		
	}

	@Override
	public boolean ValidateCard(String cardNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int GetPin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Display() {
		// TODO Auto-generated method stub

	}

}
