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

public class InventoryManager {
    
    
    ArrayList<Item> Items = new ArrayList<Item>();
    
    ItemScanner itemScanner = new ItemScanner();
    
    RestockerInterface restockerInterface = new RestockerInterface();
    
    public void ScanItems(){
        
        ArrayList<String> scannedItems = new ArrayList<String>();
        ArrayList<String> itemNames = new ArrayList<String>();
       
        try{
            
            //Pull the list of Items from the database, by creating an instance of Inventory.
            Inventory inventory = new Inventory("create");
            Items = inventory.getInventory();
            
            //Get the names of the items that we have in inventory.
            for(Item item : Items){
                itemNames.add(item.Name);
            }
            
            //Get the items to scan from the scanner (we receive the name of the items.)
            scannedItems = itemScanner.ScanInventoryItems(Items);
            
            for(String name : scannedItems){
                
                //Name is in the list of items that we have in inventory.
                if(itemNames.contains(name)){
                    
                    //Go to the item with that name, and get the new quantity.
                    for(Item item : Items){
                        if(item.Name.equals(name)){
                            item.Quantity += restockerInterface.getQuantity(name);
                            restockerInterface.DisplayQuantity(item.Name, item.Quantity);
                        }
                    }
                    
                }else{
                    
                    //Get the new item information.
                    String[] info = restockerInterface.getNewItemInfo(name);
                    
                    //String Name, double Price, boolean isAlcohol, int Discount, int Quantity
                    
                    double P = Double.parseDouble(info[0]);
                    int Q = Integer.parseInt(info[1]);
                    boolean Des = Boolean.parseBoolean(info[2]);
                    int Dis = Integer.parseInt(info[3]);
                    
                    Items.add(new Item(name, P, Des, Dis, Q));
                    
                    
                }
                
            }
            
            UpdateDatabase(Items);
            
        }catch(Exception E){
            System.out.println("Exception " + E.getMessage());
        }
        
    }
    
    //Updates an item given a list of items
    public void UpdateDatabase(ArrayList<Item> items){
        
        Inventory inventory = new Inventory();
        inventory.UpdateInventory(items);
        
    }
    
    //Updates the data base given an updated item. Return true if updated successfully.
    public boolean UpdateDatabase(Item updated_item){
        
        //item must
        ArrayList<Item> updatedList = new ArrayList<Item>();
        ArrayList<Item> allItems = new ArrayList<Item>();
        
        boolean found = false;
        
        try{
            
            Inventory inventory = new Inventory("create");
            allItems = inventory.getInventory();
            
            for(Item item : allItems){
                if(item.Name.equals(updated_item.Name)){
                    found = true;
                    item.setPrice(updated_item.Price);
                    item.setDiscount(updated_item.Discount);
                    item.setIsAlcohol(updated_item.isAlcohol());
                }
            }
            
            if(found){
                UpdateDatabase(allItems);
                return true;
            }else{
                return false;
            }
            
            
        } catch(Exception E){
            return false;
        }
    
    }
    
    //Returns an item given a name, return "not found", if the item is not on the database.
    public Item RetrieveItem(String name){
        
        try{
            
            Inventory inventory = new Inventory("create");
            ArrayList<Item> allItems = new ArrayList<Item>();
            allItems = inventory.getInventory();
            
            for(Item item : allItems){
                if(item.Name.equals(name)){
                    return item;
                }
            }
            
            return null;
        
        } catch(Exception E){
            return null;
        }
    }
    
    public ArrayList<Item> RetrieveInventory(){
        try{
            
            Inventory inventory = new Inventory("create");            
            return(inventory.getInventory());
            
        }catch(Exception E){
            return null;
        }
    }
    
    //Decreases the quantity of the objects in the database.
    public void UpdateDatabaseCustomer(ArrayList<Item> scannedItems){
        
        ArrayList<Item> allItems = RetrieveInventory();
        ArrayList<Item> allNames = new ArrayList<Item>();
        
        for(Item i : allItems){
            for(Item j : scannedItems){
                if(j.Name.equals(i.Name)){
                    i.Quantity -= 1;
                }
            }
        }
        
        UpdateDatabase(allItems);
        
    }
    
    
}
