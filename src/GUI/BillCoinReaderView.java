package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sun.javafx.binding.StringFormatter;

import softwareengineeringproject.IBillCoinReader;


public class BillCoinReaderView extends View implements IBillCoinReader {

	public BillCoinReaderView(JFrame frame) {
		super(frame);
	}

	@Override
	public boolean GetPayment(double Total) {
		double totalEntered = 0.0;
		boolean quit = false;
		while(true) {
			String[] money = {"Penny","Nickle","Dime","Quarter","Dollar Bill",
					"5 Dollar Bill","10 Dollar Bill","20 Dollar Bill","50 Dollar Bill",
					"100 Dollar Bill","Done"};
			String result = (String)JOptionPane.showInputDialog(
					frame,
					"Enter next bill or coin, Amount still due " + (Total - totalEntered),
					"Total " + Total,
					JOptionPane.QUESTION_MESSAGE,
					null,
					money,
					null);
			if(result == null) { //user clicked cancel
				Insufficient(totalEntered);
				return false;
			}
			switch(result)
			{
			case "Penny": totalEntered += .01;
			break;
			case "Nickle": totalEntered += .05;
			break;
			case "Dime": totalEntered += .10;
			break;
			case "Quarter": totalEntered += .25;
			break;
			case "Dollar Bill": totalEntered += 1.0;
			break;
			case "5 Dollar Bill": totalEntered += 5.0;
			break;
			case "10 Dollar Bill": totalEntered += 10.0;
			break;
			case "20 Dollar Bill": totalEntered += 20.0;
			break;
			case "50 Dollar Bill": totalEntered += 50.0;
			break;
			case "100 Dollar Bill": totalEntered += 100.0;
			break;
			case "Done":
			default: 
				quit = !quit;
				break;
				
			}
			if(quit || totalEntered >= Total)
				break;
		}
		
		double difference = totalEntered - Total;
		
		if(difference == 0) {
			return true;
		}
		else if(difference > 0) {
			DispenseChange(difference);
			return true;
		}
		else {
			Insufficient(totalEntered);
			return false;
		}
		
	
	}

	@Override
	public void DispenseChange(double amount) {
		JOptionPane.showMessageDialog(frame,String.format("Your Change: $%.2f", amount));
	}

	@Override
	public void Insufficient(double total_entered) {
		String formatted = String.format("Insufficient amount. Here is your $%.02f back", total_entered);
		JOptionPane.showMessageDialog(frame,formatted);

	}

	@Override
	public void Display() {
		
	}

}
