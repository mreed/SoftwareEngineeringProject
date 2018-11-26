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
		 view.getRestockerInterfaceButton()
		 	.addActionListener(e -> OnChooseRestockerInterface(e));
		 view.getManagerInterface().addActionListener(e -> OnChooseManagerInterface(e));
		 
	}
	private void OnChooseManagerInterface(ActionEvent e) {
		view.Hide();
		client.ShowManagerInterface();
	}

	public void OnChooseCustomerInterface(ActionEvent e) {
		view.Hide();
		client.ShowCustomerInterface();
	}
	public void OnChooseRestockerInterface(ActionEvent e) {
		view.Hide();
		client.ShowRestockerInterface();
	}

}
