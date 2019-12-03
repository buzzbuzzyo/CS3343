
public class AccountIsExistingException extends Exception {
	
	public AccountIsExistingException() {
		super("This id is existing. Please choose another id.");
	}
	
}
