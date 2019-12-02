
public class NoSuchAccountException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchAccountException() {
		super("Account not found! Check your userID and password!");
	}
	
	public NoSuchAccountException(String message) {
		super(message);
	}
}
