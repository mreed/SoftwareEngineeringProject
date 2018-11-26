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

import BusinessLogic.InventoryManager;
import BusinessLogic.Item;

import java.util.ArrayList;

public class ManagerInterface {
    
    public void DisplayMenu(){
        
        Scanner scan = new Scanner(System.in);
        int selection;
        
        while(true){
            
            System.out.print("Manager Menu.\n1.-View\n2.-Update.\n3.-Exit.\n"
                    + "4.-Select an option: ");
            
            selection = scan.nextInt();
            
            switch(selection){
                
                case 1: View();
                break;
                
                case 2: Update();
                break;
                
                case 3: Exit();
                break;
                
            }
            
        }
        
    }
    
    public void Update(){
        
        //List of items.
        ArrayList<Item> retrievedItems = new ArrayList<Item>();
        Scanner scan = new Scanner(System.in);
        
        //User input.
        String requested_item;
        int option;
        
        InventoryManager inventory_manager = new InventoryManager();
        
        printItems(inventory_manager.RetrieveInventory());
        
        System.out.print("Enter item to Update: ");
        requested_item = scan.next();
        
        Item retrievedItem = inventory_manager.RetrieveItem(requested_item);
        
        //Get the item object.
        if(retrievedItem != null){
            
            //Display item current info.
            System.out.println("Item info.");
            System.out.println("Name: " + retrievedItem.getName());
            System.out.println("Price: " + retrievedItem.getPrice());
            System.out.println("Quantity in stock: " + retrievedItem.getQuantity());
            System.out.println("Discount percent: " + retrievedItem.getDiscount());
            System.out.println("Description (Is Alcohol): " + retrievedItem.isAlcohol());
            
            //Ask for the information to change in the item.
            System.out.print("Which information do you want to change?\n"
                    + "1.-Price.\n"
                    + "2.-Discount percent.\n"
                    + "3.-Description (Is Alcohol)\n"
                    + "Select an option: ");
           
            option = scan.nextInt();
            
            switch(option){
                
                case 1: System.out.print("Enter new price: ");
                        retrievedItem.setPrice(scan.nextDouble());
                        break;
                
                case 2: System.out.print("Enter new discount percent: ");
                        retrievedItem.setDiscount(scan.nextInt());
                        break;
                        
                case 3: System.out.print("Enter new description (Is Alcohol if true): ");
                        retrievedItem.setAlcohol(scan.nextBoolean());
                        break;
                
                default: System.out.println("Invalid input!!");
                         break;
            }
            
            //Display item new info.
            System.out.println("Item new info.");
            System.out.println("Name: " + retrievedItem.getName());
            System.out.println("Price: " + retrievedItem.getPrice());
            System.out.println("Quantity in stock: " + retrievedItem.getQuantity());
            System.out.println("Discount percent: " + retrievedItem.getDiscount());
            System.out.println("Description (Is Alcohol): " + retrievedItem.isAlcohol());
            
            //Update the item in the DB.
            inventory_manager.UpdateDatabase(retrievedItem);
            
        }else{
            System.out.println("Item not found!!!!");
        }        
            
    }
    
    public void View(){
        
        ArrayList<Item> retrievedItems = new ArrayList<Item>();
        Scanner scan = new Scanner(System.in);
        String requested_item;
        
        InventoryManager inventoryManager = new InventoryManager();
        
        printItems(inventoryManager.RetrieveInventory());
        
        System.out.print("Enter item to view: ");
        requested_item = scan.next();
        
        Item retrievedItem = inventoryManager.RetrieveItem(requested_item);
        
        if(retrievedItem != null){
            
            System.out.println("Item info.");
            System.out.println("Name: " + retrievedItem.getName());
            System.out.println("Price: " + retrievedItem.getPrice());
            System.out.println("Quantity in stock: " + retrievedItem.getQuantity());
            System.out.println("Discount percent: " + retrievedItem.getDiscount());
            System.out.println("Description (Is Alcohol): " + retrievedItem.isAlcohol());
        
        } else{
            System.out.println("Item not found!!!!");
        }        
        
    }
    
    public void printItems(ArrayList<Item> items){
        
        System.out.println("\n=====================\n");
        for(Item item : items){
            System.out.println(item.getName() + " " + item.getQuantity());
        }
        System.out.println("\n=====================\n");
    }
    
    public void Exit(){
        System.out.println("Program has been terminated.");
        System.exit(0);
    }
    
}
