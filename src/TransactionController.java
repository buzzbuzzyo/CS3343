import java.util.ArrayList;

public class TransactionController {
	private static TransactionController instance = new TransactionController();
	private double birthdayDiscount = 0.95;
	
	public static TransactionController getInstance() {
		return instance;
	}
	
	public double completeTransaction(Customer customer) throws BalanceIsNotEnoughException, NoItemInShoppingTrolleyException {
		ArrayList<TrolleyItem> itemList = customer.getTrolley();
		double totalAmount = calculateProductAmount(itemList);
		totalAmount = calculateMembershipDiscount(customer, totalAmount);
		Membership membership = customer.getMembership();
		
		if(customer.isBirthdayToday()) {
			totalAmount *= birthdayDiscount;
		}
		
		if(customer.getBalance() < totalAmount)
			throw new BalanceIsNotEnoughException();
		if(itemList.isEmpty()) {
			throw new NoItemInShoppingTrolleyException();
		}
		
		customer.withdraw(totalAmount);
		recordTransaction(customer, itemList);
		updateStockStatus(itemList);

		
		if(customer.isBirthdayToday()) {
			System.out.println("You are enjoying your birthday discount! " + (100 - birthdayDiscount*100) + " % off!");
		}
		System.out.println("You are enjoying your " + membership.toString() + " membership discount! "+ (100 - membership.getDiscount()*100) + " % off!");
		System.out.println("You have spent $" + totalAmount + " in total.");
		int count = 1;
		for (TrolleyItem item:itemList) {
			System.out.println(count + ". " + item.toString());
			count++;
		}
		customer.emptyTrolley();
		return totalAmount;
	}
	
	public double calculateProductAmount(ArrayList<TrolleyItem> itemList) {
		double totalAmount = 0;
		for (TrolleyItem item: itemList) {
			totalAmount += item.getTotal();
		}
		return totalAmount;
	}
	
	public double calculateMembershipDiscount(Customer customer, double amount) {
		Membership membership = customer.getMembership();
		return membership.getDiscount()*amount;
	}
	
	public void recordTransaction(Customer customer, ArrayList<TrolleyItem> itemList) {
		for (TrolleyItem item: itemList) {
			Company company = item.getCompany();
			company.recordTransaction(customer, item);
		}
	}
 	
	public void updateStockStatus(ArrayList<TrolleyItem> itemList) {
		for (TrolleyItem item: itemList) {
			Product product = item.getProduct();
			int quantity = item.getQuantity();
			product.soldProduct(quantity);
		}
	}
}
