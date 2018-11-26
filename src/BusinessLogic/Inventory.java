/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

/**
 *
 * @author cmpun
 */

import java.util.ArrayList;
import java.io.*;

public class Inventory {
    
    private ArrayList<Item> Items = new ArrayList<Item>(); 
    
     //Creates Inventory.
     public Inventory(String create) throws Exception{
         
        //Get the File.
        File file = new File("./src/softwareengineeringproject/DatabaseFile.txt");
         
        BufferedReader br = new BufferedReader(new FileReader(file)); 
  
        String st; 
        String[] itemsInfo = new String[4];
        
        String Name;
        double Price;
        boolean IsAlcohol;
        int Discount;
        int Quantity;
        
        while ((st = br.readLine()) != null) {
            
            itemsInfo = st.split(",");
            
            //Parse variables.
            Name = itemsInfo[0];
            Price = Double.parseDouble(itemsInfo[1]);
            IsAlcohol = Boolean.parseBoolean(itemsInfo[2]);
            Discount = Integer.parseInt(itemsInfo[3]);
            Quantity = Integer.parseInt(itemsInfo[4]);
            
            //Add to items
            Items.add(new Item(Name, Price, IsAlcohol, Discount, Quantity));
            
        }
        br.close();
     }
     
     public Inventory(){}
     
     public ArrayList<Item> getInventory(){
         return Items;
     }
     
     public void UpdateInventory(ArrayList<Item> Items){
         
         try{
            FileWriter fileWriter = new FileWriter("./src/softwareengineeringproject/DatabaseFile.txt");
            
            for(Item item : Items){
                fileWriter.write(item.Name + "," + item.Price + "," + item.isAlcohol() + "," + item.Discount + "," + item.Quantity + "\n");
            }
            
            fileWriter.close();

        }catch(Exception E){
            System.out.println("Exception: " + E.getMessage());
        }
         
     }
     
}
