package GUI;

import java.awt.event.ActionEvent;

import softwareengineeringproject.Client;



public class ChooseUIController extends Controller {
	private ChooseUIView view;
	public ChooseUIController(Client client) {
		super(client);
	}

	@Override
	public void Init() {
		 view = new ChooseUIView(client.GetFrame());
		 view.Display();
		 view.getCustomerInterfaceButton()
		 	.addActionListener(e -> OnChooseCustomerInterface(e));
		 
	}
	public void OnChooseCustomerInterface(ActionEvent e) {
		view.Hide();
		client.ShowCustomerInterface();
	}

}
