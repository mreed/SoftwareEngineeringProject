package Interfaces;

public interface IBillCoinReader {

	boolean GetPayment(double Total);

	void DispenseChange(double amount);

	void Insufficient(double total_entered);

}