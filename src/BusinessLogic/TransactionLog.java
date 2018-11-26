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
import java.io.*;
import java.util.ArrayList;

public class TransactionLog {
    
    public TransactionLog(){}
    
    
    public void PushTransaction(Transaction new_transaction){
        
        //Push the transaction in the database.
        try{
            
            FileWriter fileWriter = new FileWriter("./src/softwareengineeringproject/TransactionLog.txt", true);

            fileWriter.write(new_transaction.Date + "," + new_transaction.processed_items + "," + new_transaction.Total + "\n");
            
            fileWriter.close();

        }catch(Exception E){
            
            System.out.println("Unable to enter transaction into Log...");
        
        }
        
    }
    
    public  ArrayList<Transaction> GetAllTransactions() throws Exception{
        
        ArrayList<Transaction> allTransactions = new ArrayList<Transaction>();
        
        //Get the File.
        File file = new File("./src/softwareengineeringproject/TransactionLog.txt");
         
        BufferedReader br = new BufferedReader(new FileReader(file)); 
  
        String st; 
        String[] itemsInfo = new String[3];
        
        String Date = new String();
        String processed_items = new String();
        double Total = 0;
        
        while ((st = br.readLine()) != null) {    
            
            itemsInfo = st.split(",");
            Date = itemsInfo[0];
            processed_items = itemsInfo[1];
            Total = Double.parseDouble(itemsInfo[2]);
        
        }
        
        allTransactions.add(new Transaction(Date, processed_items, Total));
        
        return allTransactions;
    
    }
    
    
}
