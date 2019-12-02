
public class NoSuchCompanyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchCompanyException() {
		super("No such company! Please use showAllShop command to see all existing shop!");
	}
	
	public NoSuchCompanyException(String message) {
		super(message);
	}
}
