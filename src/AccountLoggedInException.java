
public class AccountLoggedInException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountLoggedInException(String accountName) {
		super("Account " + accountName + " has already logged in. Please log out before logging in another account.");
	}
	
}
