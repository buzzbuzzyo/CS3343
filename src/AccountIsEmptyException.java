
public class AccountIsEmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountIsEmptyException() {
		super("There is no account login.");
	}
	
	public AccountIsEmptyException(String message) {
		super(message);
	}
}
