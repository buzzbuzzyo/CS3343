
public class AmountIsNegativeException extends Exception {

	public AmountIsNegativeException() {
		super("Amount is negative. Please input a positive amount.");
	}
	
	public AmountIsNegativeException(String message) {
		super(message);
	}
}
