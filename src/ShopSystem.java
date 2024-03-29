import java.util.ArrayList;

public class ShopSystem {

	private static ShopSystem instance = new ShopSystem();;
	private ProductController productController;
	private AccountController accountController;
	private TransactionController transactionController;
	private Account currentAccount;

	private ShopSystem() {
		productController = ProductController.getInstance();
		accountController = AccountController.getInstance();
		transactionController = TransactionController.getInstance();
	}

	public static ShopSystem getInstance() {
		return instance;
	}

	public void setCurrentAccount(Account account) {
		this.currentAccount = account;
	}

	public Account accountLogin(String id, String password)
			throws NoSuchAccountException, AccountLoggedInException, WrongPasswordException {
		if (currentAccount == null) {
			Account account = accountController.searchAccountById(id);
			if (account != null) {
				if (account.login(id, password)) {
					setCurrentAccount(account);
				} else {
					throw new WrongPasswordException();
				}
			}
			return account;
		}
		throw new AccountLoggedInException(currentAccount.getName());
	}

	public void accountLogOut() throws AccountIsEmptyException {
		if (currentAccount != null) {
			setCurrentAccount(null);
		} else {
			throw new AccountIsEmptyException();
		}
	}

	public void registerCompany(Company company) throws AccountIsExistingException, AccountLoggedInException {
		if (currentAccount == null) {
			if (!accountController.checkExist(company.getUserID())) {
				accountController.addAccount(company);
			} else {
				throw new AccountIsExistingException();
			}
		} else {
			throw new AccountLoggedInException(currentAccount.getName());
		}
	}

	public void registerCustomer(Customer customer) throws AccountIsExistingException, AccountLoggedInException {
		if (currentAccount== null) {
			if (!accountController.checkExist(customer.getUserID())) {
				accountController.addAccount(customer);
			} else {
				throw new AccountIsExistingException();
			}
		} else {
			throw new AccountLoggedInException(currentAccount.getName());
		}

	}

	public void showCurrentAccountTrolley() throws AccountIsNotCustomerException, AccountIsEmptyException {
		if (currentAccountIsCustomer()) {
			ArrayList<TrolleyItem> shoppingTrolley = ((Customer) currentAccount).getTrolley();
			int count = 1;
			System.out.println("Account: " + currentAccount.getName() + " ," + shoppingTrolley.size()
					+ " item(s) in your shopping trolley.");
			for (TrolleyItem item : shoppingTrolley) {
				System.out.println(count + ". " + item.toString());
				count++;
			}
		}
	}

	public void showShopProduct(String ShopID) throws AccountIsNotCustomerException, AccountIsEmptyException,
			NoSuchCompanyException, NoSuchAccountException {
		if (currentAccountIsCustomer()) {
			try {
				Account company = accountController.searchAccountById(ShopID);
				ArrayList<Product> productList = ((Company) company).getProductList();
				System.out
						.println("Shop ID: " + company.getUserID() + ", " + productList.size() + " products in total.");
				int count = 1;
				for (Product p : productList) {
					System.out.println(count + ". " + p.toString());
					count++;
				}
			} catch (NoSuchAccountException e) {
				throw new NoSuchCompanyException();
			}
		}
	}

	public void showAllShop() throws AccountIsEmptyException, AccountIsNotCustomerException {
		if (currentAccountIsCustomer()) {
			accountController.listAllCompany();
		}
	}

	public void addItemToCustomerTrolley(Product product, int quantity, Company company)
			throws AccountIsEmptyException, AccountIsNotCustomerException {
		if (currentAccountIsCustomer()) {
			ArrayList<TrolleyItem> customerTrolley = ((Customer) currentAccount).getTrolley();
			for (TrolleyItem item : customerTrolley) {
				if (item.getProduct().equals(product)) {
					item.addQuantity(quantity);
					return;
				}
			}
			customerTrolley.add(new TrolleyItem(product, quantity, company));
		}
	}

	public void removeItemFromTrolley(int pid, int quantity) throws WrongQuantityException, AccountIsEmptyException,
			AccountIsNotCustomerException, NoSuchProductException {

		if (currentAccountIsCustomer()) {
			TrolleyItem customerItem = ((Customer) currentAccount).searchTrolleyByPid(pid);

			if (customerItem.getQuantity() > quantity) {
				customerItem.subQuantity(quantity);
			} else if (customerItem.getQuantity() == quantity) {
				((Customer) currentAccount).removeTrolleyItem(customerItem);
			} else
				throw new WrongQuantityException();

		}
	}

	public Company searchCompanyById(String company) throws NoSuchCompanyException, NoSuchAccountException {
		return (Company) accountController.searchAccountById(company);
	}

	public Product searchProductInCompany(Company company, int pid) throws NoSuchProductException {
		return company.searchProductByPid(pid);
	}

	public boolean currentAccountIsCustomer() throws AccountIsEmptyException, AccountIsNotCustomerException {
		if (currentAccount == null) {
			throw new AccountIsEmptyException();
		} else if (currentAccount instanceof Customer) {
			return true;
		} else {
			throw new AccountIsNotCustomerException();
		}
	}

	public boolean currentAccountIsCompany() throws AccountIsEmptyException, AccountIsNotCompanyException {
		if (currentAccount == null) {
			throw new AccountIsEmptyException();
		} else if (currentAccount instanceof Company) {
			return true;
		} else {
			throw new AccountIsNotCompanyException();
		}
	}

	public void createProductForCompany(String productName, double productPrice, int productStock)
			throws AccountIsEmptyException, AccountIsNotCompanyException {
		if (currentAccountIsCompany()) {
			productController.createProductForCompany(currentAccount, productName, productPrice, productStock);
		}
	}

	public void depositToCurrentAccount(int amount)
			throws AccountIsEmptyException, AccountIsNotCustomerException, AmountIsNegativeException {
		if (currentAccountIsCustomer()) {
			if (amount < 0) {
				throw new AmountIsNegativeException();
			}
			((Customer) currentAccount).deposit(amount);
		}
	}

	public void checkout() throws BalanceIsNotEnoughException, NoItemInShoppingTrolleyException,
			AccountIsEmptyException, AccountIsNotCustomerException {
		if (currentAccountIsCustomer()) {
			double amount = transactionController.completeTransaction((Customer) currentAccount);
			upgradeMembership((Customer) currentAccount, amount);
		}
	}

	public void upgradeMembership(Customer customer, double amount) {
		accountController.upgradeMembership(customer, amount);
	}

	public void fillProductForCompany(int productID, int quantity)
			throws AccountIsEmptyException, AccountIsNotCompanyException, NoSuchProductException {
		if (currentAccountIsCompany()) {
			productController.fillProductForCompany((Company) currentAccount, productID, quantity);
		}
	}

	public void showSaleRecord() throws AccountIsEmptyException, AccountIsNotCompanyException {
		if (currentAccountIsCompany()) {
			((Company) currentAccount).showSaleRecord();
		}

	}

	public void showStatus() throws AccountIsEmptyException, AccountIsNotCompanyException {
		if (currentAccountIsCompany()) {
			ArrayList<Product> productList = ((Company) currentAccount).getProductList();
			System.out.println("------------------ Stock Status ------------------");
			productList.forEach(product -> {
				System.out.println(product);
			});
		}
	}

	public void removeProductFromCompany(int productID)
			throws AccountIsEmptyException, AccountIsNotCompanyException, NoSuchProductException {
		if (currentAccountIsCompany()) {
			Product product = ((Company) currentAccount).searchProductByPid(productID);
			((Company) currentAccount).removeProduct(product);
		}
	}
}
