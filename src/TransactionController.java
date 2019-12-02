import java.util.ArrayList;

public class TransactionController {
	private static TransactionController instance = new TransactionController();
	
	public static TransactionController getInstance() {
		return instance;
	}
	
	public boolean completeTransaction(Customer customer) throws BalanceIsNotEnoughException, NoItemInShoppingTrolleyException {
		ArrayList<TrolleyItem> itemList = customer.getTrolley();
		double totalAmount = calculateTotalAmount(itemList);
		if(customer.getBalance() < totalAmount)
			throw new BalanceIsNotEnoughException();
		if(itemList.isEmpty()) {
			throw new NoItemInShoppingTrolleyException();
		}
		
		
		customer.withdraw(totalAmount);
		recordTransaction(customer, itemList);
		System.out.println("You have spent $" + totalAmount + " in total.");
		return true;
	}
	
	public double calculateTotalAmount(ArrayList<TrolleyItem> itemList) {
		double totalAmount = 0;
		for (TrolleyItem item: itemList) {
			totalAmount += item.getTotal();
		}
		return totalAmount;
	}
	
	public void recordTransaction(Customer customer, ArrayList<TrolleyItem> itemList) {
		for (TrolleyItem item: itemList) {
			Company company = item.getCompany();
			company.recordTransaction(customer, item);
		}
	}
}
