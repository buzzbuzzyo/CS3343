
public class AccountIsNotCustomerException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountIsNotCustomerException() {
		super("please login your customer account.");
	}
	
	public AccountIsNotCustomerException(String message) {
		super(message);
	}

}
