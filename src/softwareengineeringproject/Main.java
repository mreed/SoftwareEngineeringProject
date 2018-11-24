package softwareengineeringproject;

import java.util.Scanner;


public class Main {
	   public static void main(String[] args) {
		   Scanner scan = new Scanner(System.in);
		   
		   int option;
		   System.out.print("1. Run as Client\n2. Run as Server\n");
		   option = scan.nextInt();
		   
		   if(option == 1) {
			   Client client = new Client();
			   client.Start();
		   }
		   else if(option == 2) {
			   Server server = new Server();
			   server.Start();
		   }
		   
		   scan.close();
	   }
}
