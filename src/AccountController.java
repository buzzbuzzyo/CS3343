import java.util.HashMap;

public class AccountController {
	private HashMap<String, Account> accountMap = new HashMap<String, Account>();
	private static AccountController instance = new AccountController();
	
	public static AccountController getInstance() {
		return instance;
	}
	
	public void listAllCompany() {
		accountMap.forEach((id,account)->{
			if(account instanceof Company) {
				System.out.println(account.toString());
			}
		});
	}
	
	public void listAllCustomer() {
		accountMap.forEach((id,account)->{
			if(account instanceof Customer) {
				System.out.println(account.toString());
			}
		});
	}
	
	public void addAccount(Account account) {
		accountMap.put(account.getUserID(), account);
	}
	
	public boolean checkExist(String userID) {
		if(accountMap.containsKey(userID)) {
			return true;
		}
		return false;
	}

	
	public Account searchAccountById(String userID) throws NoSuchAccountException {
		if(accountMap.containsKey(userID)) {
			return accountMap.get(userID);
		}
		else {
			throw new NoSuchAccountException();
		}
	}

	public HashMap<String, Account> getAccountMap() {
		return accountMap;
	}

	public void setAccountMap(HashMap<String, Account> accountMap) {
		this.accountMap = accountMap;
	}
	
	public void upgradeMembership(Customer customer, double amount) {
		Membership member = customer.getMembership();
		if(!(member instanceof Platinum)) {
			if(amount >= 4000) {
				customer.setMembership(Platinum.getInstance());
			}else if(amount >= 2000) {
				customer.setMembership(Gold.getInstance());
			}else if(amount >= 1000) {
				customer.setMembership(Sliver.getInstance());
			}
		}
	}

}
