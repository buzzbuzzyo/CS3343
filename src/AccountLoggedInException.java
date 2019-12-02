
public class AccountLoggedInException extends Exception {
	
	public AccountLoggedInException(String accountName) {
		super("Account " + accountName + " has already logged in. Please log out before logging in another account.");
	}
}
