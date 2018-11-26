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

public class RestockerInterface {
    
    public void Displaymenu(){
        
        System.out.print("Press 1 to Restock.");
        Restock();
    }
    
    public void Restock(){
        
        String item;
        int quantity;
        
        while(true){
            
            //Get an item.
            //Gets a quantity.
            
            //Breaks the while loop when specified.
            
            //Look for item in the database.
            ///If it is not there tells restocker about it.
            
            //If it is there add the quatity, to the current quatity.
            break;
            
        }
        
        
    }
    
    public int getQuantity(String name){
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter quantity for " + name + " : ");
        
        return(scan.nextInt());
        
    }
    
    public void DisplayQuantity(String name, int quantity){
        System.out.println("The new quantity for: " + name + " is " + quantity);
    }
    
    public String[] getNewItemInfo(String name){
        
        Scanner scan = new Scanner(System.in);
        
        String Price;
        String Quantity;
        String IsAlcohol;
        String Discount;
        
        System.out.println("Enter info for new item: " + name);
        
        System.out.print("Enter price: ");
        Price = scan.next();
        
        System.out.print("Enter quantity: ");
        Quantity = scan.next();
        
        System.out.print("Enter description (true if alcohol / false if not): ");
        IsAlcohol = scan.next();
        
        System.out.print("Enter discount percent: ");
        Discount = scan.next();
        
        //Encapsulate in a string an send.
        String[] info = new String[4];
        
        info[0] = Price;
        info[1] = Quantity;
        info[2] = IsAlcohol;
        info[3] = Discount;
        
        return info;
        
    }
    
}
