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

public class Transaction {
    
    String Date;
    String processed_items;
    double Total;
    
    public Transaction(String Date, String processed_items, double Total){
        
        this.Date = Date;
        this.processed_items = processed_items;
        this.Total =  Total;
        
    }
    
    
}
