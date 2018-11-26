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

import Interfaces.ICardReader;

public class CardReader implements ICardReader {
    
    //Returns an array of string, on the first index has card type and on the second it has card number.
    public String[] GetCardInfo(){
        
        String[] cardInfo = new String[2];
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Select Card type:\n1.-Credit Card\n2.-Debit Card.\n3.-Cancel Payment\nSelect an option: ");
        
        int type = scan.nextInt();
        
        if(type == 1){
            
            cardInfo[0] = "Credit";
            System.out.print("Enter 10 digit card number: ");
            cardInfo[1] = scan.next();
            
            return cardInfo;
            
        }else if(type == 2){
            
            cardInfo[0] = "Debit";
            System.out.print("Enter 10 digit card number: ");
            cardInfo[1] = scan.next();
            
            return cardInfo;
            
        }else{
            return cardInfo;
        }
        
    }
    
    public int Debit(){
        
        int pinNumber = GetPin();
        return pinNumber;
        
    }
    
    public void Credit(){
    
    }
    
    public boolean ValidateCard(String cardNumber){
        
        if(cardNumber.length() != 10){
            System.out.println("Card Ejected...");
            return false;
        }else{
            return true;
        }
    
    }
    
    public int GetPin(){
        
        Scanner scan = new Scanner(System.in);
        
        int pinNumber;
        System.out.print("Enter four digit pin: ");
        
        pinNumber = scan.nextInt();
        
        return pinNumber;
        
    }
    
}
