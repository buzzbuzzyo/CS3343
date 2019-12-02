
public class InsufficientParameterException extends Exception {
	
	public InsufficientParameterException() {
		super("Insufficient parameter!");
	}
	
	public InsufficientParameterException(String message) {
		super(message);
	}

}
