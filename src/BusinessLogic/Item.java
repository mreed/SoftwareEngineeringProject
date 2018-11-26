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
public class Item {
    
    String Name;
    double Price;
    
    //Is alcohol if true.
    private boolean isAlcohol = false;
    
    int Discount;
    int Quantity;
    
    public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getName() {
    	return Name;
    }
    public Item(){
    }
    
    public Item(String Name){
        this.Name = Name;
    }
    
    public Item(String Name, double Price){
        this.Name = Name;
        this.Price = Price;
    }
    
    public Item(String Name, double Price, boolean isAlcohol){
        this.Name = Name;
        this.Price = Price;
        this.setAlcohol(isAlcohol);
    }
    
    public Item(String Name, double Price, boolean isAlcohol, int Discount, int Quantity){
        this.Name = Name;
        this.Price = Price;
        this.setAlcohol(isAlcohol);
        this.Discount = Discount;
        this.Quantity = Quantity;
    }
    
    public void setPrice(double Price){
        this.Price = Price;
    }
    
    public void setIsAlcohol(boolean isAlcohol){
        this.setAlcohol(isAlcohol);
    }
    
    public void setDiscount(int Discount){
        this.Discount = Discount;
    }
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.Price;
	}
	public boolean isAlcohol() {
		return isAlcohol;
	}
	public void setAlcohol(boolean isAlcohol) {
		this.isAlcohol = isAlcohol;
	}
    
}
