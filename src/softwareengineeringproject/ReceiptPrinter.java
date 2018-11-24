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

import java.util.ArrayList;

public class ReceiptPrinter {
    
    public void PrintReceipt(ArrayList<Item> scannedItems, double Total, String cardNumber, String auth_number){
        
        for(int i = 0; i < 2; i++){
            
            System.out.println("Receipt " + i);
            
            //Total with tax
            double tax_total = Total + (Total * 0.08f);
        
            System.out.println("--------------------");
        
            //First print the items
            for(Item it : scannedItems){ System.out.println(it.Name + " " + it.Price); }
        
            //---------
            System.out.println("=====================");
        
            System.out.println(String.format("Subtotal: %.2f", Total));
            System.out.println(String.format("Tax:  %.2f", Total * 0.08f));
            System.out.println(String.format("Total: %.2f", tax_total));
        
            String last_four = "";
        
            System.out.println("========================");
        
            System.out.println("Payment Information:");
        
            for(int j = cardNumber.length()-1; j >= cardNumber.length()-4; j--){
                last_four = cardNumber.charAt(j) + last_four; 
            }
        
            System.out.println("Last four card digits: " + last_four);
            System.out.println("Authorization Number: " + auth_number);

            System.out.println("========================");
            
        }  
        
    }
    
}
