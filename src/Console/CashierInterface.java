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

public class CashierInterface {
    
    public boolean Confirmation(){
        
        Scanner scan = new Scanner(System.in);
        
        double confirmation_code;
        
        System.out.print("Enter user age: ");
        
        int age = scan.nextInt();
        
        if(age >= 21){
            System.out.print("Enter confirmation number: ");
            scan.nextInt();
            return true;
        }else{
            System.out.print("The user cannot buy this!\n");
            return false;
        }
        
    }
    
}
