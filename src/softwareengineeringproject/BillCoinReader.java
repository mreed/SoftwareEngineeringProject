/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject;

/**
 *
 * @author cmpun
 */

import java.util.Scanner;

public class BillCoinReader implements IBillCoinReader {
    
    /* (non-Javadoc)
	 * @see softwareengineeringproject.IBillCoinReader#GetPayment(double)
	 */
    @Override
	public boolean GetPayment(double Total){
        
        Scanner scan = new Scanner(System.in);
        int menu_option;
        boolean quit = false;
        
        double total_entered = 0;
        
        while(true){
            
            System.out.print("1.-5 cents\n"
                    + "2.-10 cents\n"
                    + "3.-25 cents\n"
                    + "4.-1 dollar\n"
                    + "5.-5 dollars\n"
                    + "6.-10 dollars\n"
                    + "7.-20 dollars\n"
                    + "8.-50 dollars\n"
                    + "9.-100 dollars\n"
                    + "10.-Done\n"
                    + "Enter selection: ");
            
           menu_option = scan.nextInt();
           
           switch(menu_option){
               
               case 1: total_entered += 0.05;
               break;
               
               case 2: total_entered += 0.10;
               break;
               
               case 3: total_entered += 0.25;
               break;
               
               case 4: total_entered += 1.0;
               break;
               
               case 5: total_entered += 5.0;
               break;
               
               case 6: total_entered += 10.0;
               break;
               
               case 7: total_entered += 20.0;
               break;

               case 8: total_entered += 50;
               break;
               
               case 9: total_entered += 100;
               break;
               
               case 10: quit = !quit;
               break;
               
               default: System.out.println("Invalid money!");
               break;
           
           }
            
           if(quit || total_entered >= Total){
               break;
           }
        
        }
              
        double difference = total_entered-Total;
        
        if(difference == 0){
            //No change to give.
            return true;
            
        }else if(difference > 0){
            
            DispenseChange(difference);
            return true;
            
        }else{
            
            Insufficient(total_entered);
            return false;
            
        }
        
    }
    
    /* (non-Javadoc)
	 * @see softwareengineeringproject.IBillCoinReader#DispenseChange(double)
	 */
    @Override
	public void DispenseChange(double amount){
        //Give user change back.
        System.out.println("Your change: " + amount);
    }
    
    /* (non-Javadoc)
	 * @see softwareengineeringproject.IBillCoinReader#Insufficient(double)
	 */
    @Override
	public void Insufficient(double total_entered){
        System.out.println("Insufienct amount. Here is your " + total_entered + " back.");
    }
    
}
