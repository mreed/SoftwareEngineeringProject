package GUI;

import softwareengineeringproject.Client;

public abstract class Controller {
	protected Client client;
	public Controller(Client client) {
		this.client = client;
	}
	public abstract void Init();
}