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

public class CheckOutManager {
    
    ItemScanner itemScanner = new ItemScanner();
    
    PaymentManager paymentManager = new PaymentManager();
    ReceiptPrinter receiptPrinter = new ReceiptPrinter();
    
    TransactionManager transaction_manager = new TransactionManager();
    InventoryManager inventory_manager = new InventoryManager();
    
    ArrayList<Item> scanned_items = new ArrayList<Item>();
    
    //1-credit, 2-debit, 3-cash
    int payment_method;
    
    public void RequestScanItems(){
        
        double Total;
        CustomerInterface customer_interface = new CustomerInterface();
        
        //Get scanned items.
        scanned_items = itemScanner.scanItems();
        
        if(scanned_items == null){ customer_interface.DisplayWelcome(); }
        
        //Show the scanned items in the customer interface.
        customer_interface.DisplayScannedItems(scanned_items);
        
        //Get total price.
        Total = Get_Total(scanned_items);
        
        //Display the total.
        customer_interface.DisplayTotal(Total);
        
        String[] paymentInfo = new String[2];
        
        String cardNumber = new String();
        String auth_number = new String();
        
        boolean terminate = false;
        
        while(true){
            
            //Request Payment
            payment_method = customer_interface.Request_Payment();
            
            if(payment_method == 1){
                
                //Call Payment with Card Payment.
                paymentInfo = paymentManager.CardPayment(Total);
                
                if(paymentInfo[0].equals("-1")){
                    
                    //Card was denied.
                    customer_interface.CardPaymentDenied();
                    
                }else{
                    
                    //Extact the payment info.
                    cardNumber = paymentInfo[1];
                    auth_number = paymentInfo[0];
                    break;
                    
                }
                
                
            } else if(payment_method == 2){
                
                //Cash payment.
                if(paymentManager.CashPayment(Total)){
                    
                    //Since no card number or authorization number is needed.
                    cardNumber = "----";
                    auth_number = "----";
                    break;
                    
                }else{
                    
                    //Cancel transaction.
                    terminate = true;
                    break;
                }
                
            } else if(payment_method == 3){
                
                //Transaction is cancelled.
                customer_interface.PaymentCancelled();
                
            } else {
                
                customer_interface.Terminate();
                
            }
            
        }
        
        if(terminate){
            customer_interface.Terminate();
        }else{
            
            //Print receipt.
            receiptPrinter.PrintReceipt(scanned_items, Total, cardNumber, auth_number);
            
            //Update the database with the items that were purchased.
            inventory_manager.UpdateDatabaseCustomer(scanned_items);
                    
            //Save the transaction log.
            transaction_manager.StoreTransaction(scanned_items, Total);
            
            customer_interface.Completed();
        }
        
    }
    
    public double Get_Total(ArrayList<Item> items){
        
        double total_price= 0;
        
        for(Item i : items){ 
        
            total_price += i.Price; 
        
        }
        
        return total_price;
        
    }
    
}
