
public class InsufficientParameterException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientParameterException() {
		super("Insufficient parameter!");
	}
	
	public InsufficientParameterException(String message) {
		super(message);
	}

}
