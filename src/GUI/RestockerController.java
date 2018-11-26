package GUI;

import softwareengineeringproject.Client;

public class RestockerController extends Controller {

	private RestockerView restockerView;

	public RestockerController(Client client) {
		super(client);
	}

	@Override
	public void Init() {
		restockerView = new RestockerView(client.GetFrame());
		restockerView.Display();
	}

}
