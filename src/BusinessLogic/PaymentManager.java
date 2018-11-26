/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Console.AuthorizationCenter;
import Console.BillCoinReader;
import Console.CardReader;
import Interfaces.IAuthorizationCenter;
import Interfaces.IBillCoinReader;
import Interfaces.ICardReader;

/**
 *
 * @author cmpun
 */
public class PaymentManager {
    ICardReader card_reader;
    IBillCoinReader cash_reader;
    IAuthorizationCenter auth_center;
	public PaymentManager() {
		card_reader = new CardReader();
		auth_center = new AuthorizationCenter();
		cash_reader = new BillCoinReader();
	}
	public PaymentManager(IAuthorizationCenter auth, ICardReader cardReader, IBillCoinReader billCoinReader) {
		this.card_reader = cardReader;
		auth_center = auth;
		this.cash_reader = billCoinReader;
	}

    public String[] CardPayment(double Total){
        
        //Get the card info.
        String[] cardInfo = card_reader.GetCardInfo();
        
        //Payment info.
        String[] paymentInfo = new String[2];
        
        if(cardInfo[0] == "Debit"){
        
            int PIN = card_reader.Debit();
            
            String auth_number = auth_center.Verify(cardInfo[1], PIN, Total);
            
            if(auth_number != "-1"){
                
               paymentInfo[0] = auth_number;
               paymentInfo[1] = cardInfo[1];
               
               return paymentInfo;
                
            }else{
              
                //Payment was denied
                paymentInfo[0] = "-1";
                return paymentInfo;

            }
            
        } else if(cardInfo[0] == "Credit"){
            
            int PIN = 0;
            
            String auth_number = auth_center.Verify(cardInfo[1], PIN, Total);
            
            if(auth_number != "-1"){
                
               paymentInfo[0] = auth_number;
               paymentInfo[1] = cardInfo[1];
               
               return paymentInfo;
                
            }else{
              
                //Payment was denied
                paymentInfo[0] = "-1";
                return paymentInfo;

            }
           
        }else{
            return null;
        }
        
    }
    
    public boolean CashPayment(double Total){
    
       return cash_reader.GetPayment(Total);
        
    }
    
}
