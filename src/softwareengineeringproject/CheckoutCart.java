package softwareengineeringproject;

import java.util.ArrayList;


public class CheckoutCart {
	private ArrayList<Item> items = new ArrayList<Item>();
	private double taxrate = 0.08;
	private boolean isAuthorizedToBuyAlcohol = false;
	
	public boolean isAuthorizedToBuyAlcohol() {
		return isAuthorizedToBuyAlcohol;
	}
	public void setAuthorizedToBuyAlcohol(boolean isAuthorizedToBuyAlcohol) {
		this.isAuthorizedToBuyAlcohol = isAuthorizedToBuyAlcohol;
	}
	public ArrayList<Item> getItems(){
		return items;
	}
	public void AddItem(Item item) {
		items.add(item);
	}
	public double SubTotal() {
		 double total_price = 0;
	        
	        for(Item item : items){ 

	            total_price += item.Price; 
	        }
	        
	       // System.out.println("\nThe subtotal is: " + (total_price + (total_price * 0.08f)) + "\n");
	      return total_price + (total_price * taxrate);
	}
	public double TotalTax() {
		double total_price = Total();
		return taxrate * total_price;
	}
	public double Total() {
		 double total_price = 0;
	        
	        for(Item item : items){ 

	            total_price += item.Price; 
	        }
	      return total_price;
	}
	
}
