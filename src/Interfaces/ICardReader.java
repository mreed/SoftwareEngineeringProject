package Interfaces;

public interface ICardReader {
	public String[] GetCardInfo();
	public int Debit();
	public boolean ValidateCard(String cardNumber);
	public int GetPin();
}
