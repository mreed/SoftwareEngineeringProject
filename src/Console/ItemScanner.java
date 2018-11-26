/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;
import java.util.ArrayList;
import java.util.Scanner;

import BusinessLogic.Inventory;
import BusinessLogic.Item;
import Interfaces.IItemScanner;
import Interfaces.IOnItemNameScanned;
import Interfaces.IOnItemsScanned;
/**
 *
 * @author cmpun
 */
public class ItemScanner implements IItemScanner {
    
	ArrayList<IOnItemsScanned> itemListeners = new ArrayList<IOnItemsScanned>();
	ArrayList<IOnItemNameScanned> nameListeners = new ArrayList<IOnItemNameScanned>();
    //Item objects.
    ArrayList<Item> selectedItems = new ArrayList<Item>();  
    ArrayList<Item> allItems = new ArrayList<Item>(); 
    
    //Item names and prices.
    ArrayList<String> itemNames = new ArrayList<String>();
    ArrayList<Double> itemPrices = new ArrayList<Double>();
    
    /* (non-Javadoc)
	 * @see Console.IItemScanner#scanItems()
	 */
    @Override
	public void scanItems(){
        
        Scanner scan = new Scanner(System.in);
        CashierInterface cashier = new CashierInterface();
        
        //We must take the items from the inventory to display this menu.
        try { 
            
            Inventory inventory = new Inventory("create");
            allItems = inventory.getInventory();
   
        
            //Get the name and price of the items
            for(Item item : allItems ){ itemNames.add(item.getName()); }
        
            String selection;
        
            while(true){
            
                System.out.println("Items in inventory: ");
                
                System.out.println("===============");
                
                for(Item item : allItems ){
                    if(item.getQuantity() > 0){
                        System.out.println("  " + item.getName() + " " + item.getPrice());
                    }
                }
                
                System.out.println("===============");
                
                System.out.print("Enter name of item to scan.\n"
                    + "Enter TOTAL to enter you items. \n"
                    + "Enter 1 to get Subtotal\n"
                    + "Enter 2 to Cancel Checkout.\n"    
                    + "Enter selection: ");
                
                
                selection = scan.next();
            
                if(selection.equals("TOTAL")){
                    break;
                } else if(selection.equals("1")){
                    GetSubtotalPrice(selectedItems);
                } else if(selection.equals("2")){
                    return;
                } else{
                
                    if(itemNames.contains(selection)){
                        //Look for the item with the name.
                        for(Item item : allItems){
                            
                            if(item.getName().equals(selection)){
                             
                                if(!item.isAlcohol()){
                                    selectedItems.add(item);
                                }else{
                                    
                                    //Get cashier confirmation.
                                    if(cashier.Confirmation()){
                                        selectedItems.add(item);
                                    }
                                    
                                }                            
                            
                            }
                        }
                    } else{
                            System.out.print("Unknown item or incorrect selection!\n");
                        }
                
                }
            
            }
        
        } catch(Exception E){
            System.out.println("Problem while retrieving database!");
            return;
        }
        finally {
        	scan.close();
        }
        for(IOnItemsScanned listener : itemListeners) {
        	listener.OnItemsScanned(selectedItems);
        }
        
    }
    
    public void GetSubtotalPrice(ArrayList<Item> scanned){
        
        double total_price = 0;
        
        for(Item item : scanned){ 
            
            System.out.println(item.getName());
            
            total_price += item.getPrice(); 
        }
        
        System.out.println("\nThe subtotal is: " + (total_price + (total_price * 0.08f)) + "\n");
    
    }
    
    
    //This method return name of items that we are going to restock.
    /* (non-Javadoc)
	 * @see Console.IItemScanner#ScanInventoryItems(java.util.ArrayList)
	 */
    @Override
	public void ScanInventoryItems(ArrayList<Item> inventoryItems){
        
        Scanner scan = new Scanner(System.in);
        
        //Item to be restocked.
        ArrayList<String> names = new ArrayList<String>();
        String restockedItemName;
        int exit;
        
        while(true){
            
            //Show the items of the inventory.. Name - Quantity.
            for(Item item : inventoryItems){
                System.out.println(item.getName() + " " + item.getQuantity());
            }
        
            System.out.print("Enter Name of item to be restocked: ");
            restockedItemName = scan.next();
            names.add(restockedItemName);
            
            System.out.print("Enter 1 to exit, 2 to continue");
            exit = scan.nextInt();
            
            if(exit == 1){
                break;
            }
            
        }
        
        for(IOnItemNameScanned listener: nameListeners) {
        	listener.OnItemNameScanned(names);
        }
        
    }

	@Override
	public void addScanItemListener(IOnItemsScanned listener) {
		itemListeners.add(listener);
		
	}

	@Override
	public void addNameScanListener(IOnItemNameScanned listener) {
		nameListeners.add(listener);
		
	}
    
}
