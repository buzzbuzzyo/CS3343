import java.util.ArrayList;

public class TransactionController {
	private static TransactionController instance = new TransactionController();
	private double birthdayDiscount = 0.95;

	public static TransactionController getInstance() {
		return instance;
	}

	public double completeTransaction(Customer customer)
			throws BalanceIsNotEnoughException, NoItemInShoppingTrolleyException {
		ArrayList<TrolleyItem> itemList = customer.getTrolley();
		itemList.removeIf(item -> {
			Company itemCompany = item.getCompany();
			Product itemProduct = item.getProduct();
			if (!itemCompany.checkExistProduct(itemProduct)) {
				System.out.printf("%s has been sold out. Automatically removed.\n", itemProduct.getName());
				return true;
			} else {
				return false;
			}
		});
		double totalAmount = calculateProductAmount(itemList, customer);
		Membership membership = customer.getMembership();
		if (customer.getBalance() < totalAmount)
			throw new BalanceIsNotEnoughException();
		if (itemList.isEmpty()) {
			throw new NoItemInShoppingTrolleyException();
		}
		customer.withdraw(totalAmount);
		recordTransaction(customer, itemList);
		updateStockStatus(itemList);
		if (customer.isBirthdayToday()) {
			System.out
					.println("You are enjoying your birthday discount! " + (100 - birthdayDiscount * 100) + " % off!");
		}
		System.out.println("You are enjoying your " + membership.toString() + " membership discount! "
				+ (100 - membership.getDiscount() * 100) + " % off!");
		System.out.println("You have spent $" + totalAmount + " in total.");
		itemList.forEach(item -> {
			System.out.println(itemList.indexOf(item) + 1 + ". " + item.toString());
		});
		customer.emptyTrolley();
		return totalAmount;
	}

	private void recordTransaction(Customer customer, ArrayList<TrolleyItem> itemList) {
		Membership membership = customer.getMembership();
		for (TrolleyItem item : itemList) {
			Company company = item.getCompany();
			double totalAmount = item.getTotal() * membership.getDiscount();
			if (customer.isBirthdayToday()) {
				totalAmount *= birthdayDiscount;
			}
			company.recordTransaction(customer, item, totalAmount);
		}
	}

	public double calculateProductAmount(ArrayList<TrolleyItem> itemList, Customer customer) {
		double totalAmount = 0;
		for (TrolleyItem item : itemList) {
			totalAmount += item.getTotal();
		}
		Membership membership = customer.getMembership();
		if (customer.isBirthdayToday()) {
			totalAmount *= birthdayDiscount;
		}
		return membership.getDiscount() * totalAmount;
	}

	public void updateStockStatus(ArrayList<TrolleyItem> itemList) {
		for (TrolleyItem item : itemList) {
			Product product = item.getProduct();
			int quantity = item.getQuantity();
			product.soldProduct(quantity);
		}
	}
}
