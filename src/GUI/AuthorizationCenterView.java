package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Interfaces.IAuthorizationCenter;

public class AuthorizationCenterView extends View implements IAuthorizationCenter {

	public AuthorizationCenterView(JFrame frame) {
		super(frame);
	}

	@Override
	public String Verify(String cardNumber, int PIN, double Total) {
		String[] approvals = {"Approve","Disapprove"};
		String result = (String)JOptionPane.showInputDialog(frame,
				String.format("Approve %s for %.2f?", cardNumber,Total),
				"Authorization Center",
				JOptionPane.QUESTION_MESSAGE,
				null,
				approvals,
				null);
	    if(result == "Approve") {
	    	return "12929d9dk2di";
	    			
	    }
	    return "-1";
	}

	@Override
	public void Display() {
		// TODO Auto-generated method stub

	}

}
