
public class AccountIsExistingException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1958679560508011439L;

	public AccountIsExistingException() {
		super("This id is existing. Please choose another id.");
	}
	
}
