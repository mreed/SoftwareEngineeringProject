package softwareengineeringproject;



import BusinessLogic.TimerDevice;


public class Main {
	   public static void main(String[] args) {
	        //Start timer.
	        TimerDevice t = new TimerDevice();
			   Client client = new Client();
			   client.Start();

	   }
}
