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

public class SoftwareEngineeringProject {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        int option;
        System.out.println("1.-Customer mode\n2.-Manager Mode\nSelect an option: ");
        
        option = scan.nextInt();
        
        CustomerInterface customer_interface = new CustomerInterface();
        InventoryManager inventoryManager = new InventoryManager();

        switch(option){
            
            case 1: customer_interface.DisplayWelcome();
            break;
            
            case 2: inventoryManager.ScanItems();
            break;
            
            default: System.out.println("Invalid input!");
            break;
            
        }
        
    }
    
}
