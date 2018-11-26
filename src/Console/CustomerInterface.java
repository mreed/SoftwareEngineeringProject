/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

/**
 *
 * @author cmpun
 */

import java.util.Scanner;

import BusinessLogic.Item;

import java.util.ArrayList;

public class CustomerInterface {
    
    CheckOutManager checkout_manager;
    
    public void DisplayWelcome(){
        
        checkout_manager = new CheckOutManager();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        
        System.out.print("Press 1 to Start Checkout: \n");
        int input = scan.nextInt();
        
        if(input == 1){
            ScanItems();
        }
      
    }
    
    public void ScanItems(){
       
        System.out.println("Please scan items: ");       
        checkout_manager.RequestScanItems();
        
    }
    
    public void DisplayScannedItems(ArrayList<Item> items){
        
        for(Item i : items){ System.out.println(i.getName() + " " + i.getPrice()); }
           
    }
    
    public void DisplayTotal(double total_price){
        System.out.println("The total price is: " + (total_price + (total_price * 0.08f)));
    }
    
    public int Request_Payment(){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Select Payment Method:\n"
                + "1.-Credit\\Debit\n2.-Cash\n3.-Cancel Payment\n4.-Cancel Checkout\nSelect: ");
        
        int input = scan.nextInt();
        
        return input;
    }
    
    public void CardPaymentDenied(){
        System.out.println("Your card was denied...");
    }
    
    public void PaymentCancelled(){
        System.out.println("Payment cancelled...");
    }
    
    public void EnterCashMessage(){
        System.out.println("Please enter cash: ");
    }
    
    public void Completed(){
        System.out.println("Transaction has been completed...");
        DisplayWelcome();
    }
    
    public void Terminate(){
        System.out.println("Transaction terminated...");
        DisplayWelcome();
    }
   
}
