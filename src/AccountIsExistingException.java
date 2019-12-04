
public class AccountIsExistingException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountIsExistingException() {
		super("This id is existing. Please choose another id.");
	}
	
	public AccountIsExistingException(String message) {
		super(message);
	}

}
