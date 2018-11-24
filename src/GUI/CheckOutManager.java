package GUI;


import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import softwareengineeringproject.CheckoutCart;
import softwareengineeringproject.Client;
import softwareengineeringproject.ICardReader;
import softwareengineeringproject.InventoryManager;
import softwareengineeringproject.Item;
import softwareengineeringproject.PaymentManager;
import softwareengineeringproject.ReceiptPrinter;
import softwareengineeringproject.TransactionManager;



public class CheckOutManager extends Controller {
    private WelcomeView welcomeView;
    private ScanItemsView scanItemsView;
	private ChooseItemToScan dialog;
	private InventoryManager inventoryManager;
	private CheckoutCart cart;
	private PaymentManager paymentManager;
	private ICardReader cardReader;
	private SelectPaymentMethodView selectPaymentMethodView;
    private TransactionManager transaction_manager;
    
	public CheckOutManager(Client client) {
		super(client);
		cardReader = new CardReaderView(client.GetFrame());
		AuthorizationCenterView auth = new AuthorizationCenterView(client.GetFrame());
		paymentManager = new PaymentManager(auth,cardReader);
		transaction_manager = new TransactionManager();
	}
	@Override
	public void Init() {
		welcomeView = new WelcomeView(client.GetFrame());
		welcomeView.Display();
		welcomeView.getBeginCheckoutButton()
			.addActionListener(e -> OnBeginCheckout(e));
	}
	//when user clicks begin checkout
	private void OnBeginCheckout(ActionEvent e) {
		welcomeView.Hide();
		scanItemsView = new ScanItemsView(client.GetFrame());
		scanItemsView.Display();
		scanItemsView.getBtnCancel().addActionListener(x -> OnCancelCheckout(x));
		scanItemsView.getBtnSearchOrKey().addActionListener(x -> OnSearchForItems(x));
		scanItemsView.getBtnSubtotal().addActionListener(x -> OnSubTotal(x));
		scanItemsView.getBtnPay().addActionListener(x -> OnPay(x));
		cart = new CheckoutCart();
		
	}
	private void OnPay(ActionEvent e) {
		scanItemsView.Hide();
		selectPaymentMethodView = new SelectPaymentMethodView(client.GetFrame());
		this.selectPaymentMethodView.Display();
		this.selectPaymentMethodView.ShowCart(cart);
		this.selectPaymentMethodView.getTotalDue().setText(String.format("$%.2f", cart.SubTotal()));
		this.selectPaymentMethodView.getBtnCancelPayment().addActionListener(x -> OnCancelPayment(x));
		this.selectPaymentMethodView.getBtnPayWithCash().addActionListener(x -> OnPayWithCash(x));
		this.selectPaymentMethodView.getBtnPayWithDebitOrCC().addActionListener(x -> OnPayWithDebitOrCC(x));
		
	}
	private void OnPayWithDebitOrCC(ActionEvent e) {
		String[] result = paymentManager.CardPayment(cart.SubTotal());
		this.selectPaymentMethodView.Hide();
		if(result[0] != "-1") {
			JOptionPane.showMessageDialog(client.GetFrame(),"Payment approved. Thank you for shopping with us.");
			ReceiptPrinter receiptPrinter = new ReceiptPrinter();
			 //print receipt
			receiptPrinter.PrintReceipt(cart.getItems(), cart.SubTotal(), result[0], result[1]);
			//update inventory
			inventoryManager.UpdateDatabaseCustomer(cart.getItems());
              
	            //Save the transaction log.
	        transaction_manager.StoreTransaction(cart.getItems(), cart.Total());
			welcomeView.Show();
		}
		else {
			JOptionPane.showMessageDialog(client.GetFrame(),"Your card was denied. Please try another payment method.");
			OnPay(null);
		}
	}

	private void OnPayWithCash(ActionEvent e) {
		paymentManager.CashPayment(cart.SubTotal());
	}
	private void OnCancelPayment(ActionEvent e) {
		selectPaymentMethodView.Hide();
		scanItemsView.Show();
	}
	private void OnSubTotal(ActionEvent x) {
		JOptionPane.showMessageDialog(null,String.format("Your Total is $%.2f", cart.SubTotal()));

	}
	//When you clicks Search for Items or Key in Item this is called
	private void OnSearchForItems(ActionEvent e) {
		
		try
		{
		inventoryManager = new InventoryManager();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Could not get inventory. Please contact your cachier for help.");
			return;
		}
		//get the items names to show in ComboBox
		ArrayList<String> itemNames = new ArrayList<String>();
		itemNames.add(" "); //create a default blank entry
		for(Item t : inventoryManager.RetrieveInventory()) {
			itemNames.add(t.getName());
		}
		String[] itemNameArray = new String[itemNames.size()];
		dialog = new ChooseItemToScan(itemNames.toArray(itemNameArray));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getOkButton().addActionListener(x -> OnItemFound(x));
		dialog.getCancelButton().addActionListener(x -> OnCancelItemSearch(x));
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	private void OnCancelItemSearch(ActionEvent e) {
		dialog.setVisible(false);
		dialog.dispose();
	}
	//user selected an item
	//need to get it from inventory
	//add it to the list of purchased Items
	//add it to current selected item.
	private void OnItemFound(ActionEvent e) {
		String itemSelected = dialog.getSelectedItem();
		dialog.setVisible(false);
		dialog.dispose();
		Item selectedItem = inventoryManager.RetrieveItem(itemSelected);
		if(selectedItem == null) {
			JOptionPane.showMessageDialog(null,"Could not find item " + itemSelected + " in inventory.");
			return;
		}
		if(selectedItem.isAlcohol() && !cart.isAuthorizedToBuyAlcohol()) {
			String result = "";
			while(result != null && !result.equals("1234")) {
				result = CashierAlcoholAuthorization();
			}
			if(result == null) { //Cacher check was cancelled return
				return;
			}
			cart.setAuthorizedToBuyAlcohol(true);
		}
		cart.AddItem(selectedItem);
		String currentItemText = String.format("Scanned %s              $ %.2f",selectedItem.getName(),selectedItem.getPrice());
		JLabel l = this.scanItemsView.getCurrentItem();
		l.setText(currentItemText);
		this.scanItemsView.AddItemFromCart(selectedItem);
		double total = cart.Total();
		this.scanItemsView.getTotalAmount().setText(String.format("$%.2f",total));
		this.scanItemsView.getBtnPay().setText(String.format("Pay $%.2f",cart.SubTotal() ));
		//l.paintImmediately(l.getVisibleRect());
	}
	private String CashierAlcoholAuthorization() {
		String cashierAuthorizationCode =  JOptionPane.showInputDialog(client.GetFrame(),
				"Enter Cashier Authorization for Alcohol Purchase (1234)",
				"Cashier Authorization",
				JOptionPane.DEFAULT_OPTION);
		return cashierAuthorizationCode;
	}
	private void OnCancelCheckout(ActionEvent e) {
		int choice = JOptionPane.showConfirmDialog(client.GetFrame(), "Are you sure you want to cancel checkout?");
		if(choice == JOptionPane.YES_OPTION) {
				scanItemsView.Hide();
				Init();
		}
	}

}
