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

import java.text.SimpleDateFormat;  
import java.util.Date; 

public class TransactionManager {
    
    public void StoreTransaction(ArrayList<Item> items, double Price){
        
        TransactionLog transactions_log = new TransactionLog();
        
        //Get the current date in a string.
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        
        String formated_date = formatter.format((date));  
        String processed_items = ProcessItems(items);
        
        Transaction transaction = new Transaction(formated_date, processed_items, Price);
        
        transactions_log.PushTransaction(transaction);
        
    }
    
    //Process Items into a string that can be logged.
    public String ProcessItems(ArrayList<Item> items){
        
        String items_processed = new String();
        
        items_processed = "";
        
        for(Item item : items){
            items_processed = item.Name + "-";
        }
        
        return items_processed;
        
    }
    
    public ArrayList<Transaction> RetriveTransactionsByDate(String Date){
        
        TransactionLog transactions_log = new TransactionLog();
        ArrayList<Transaction> allTransactions = new ArrayList<Transaction>();
        ArrayList<Transaction> filtered_transactions = new ArrayList<Transaction>();
        
        try{
            
            allTransactions = transactions_log.GetAllTransactions();
        
            //Return only the transactions that occurred in the date.
            for(Transaction trans : allTransactions){
                if(trans.Date.equals(Date)){
                    filtered_transactions.add(trans);
                }
            }
            
        } catch(Exception E){
            System.out.print("Exception caught:  " + E.getMessage());
        }

        //Get the transaction from a date
        return filtered_transactions;
    }
    
}
