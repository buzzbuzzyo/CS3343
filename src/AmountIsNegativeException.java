
public class AmountIsNegativeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AmountIsNegativeException() {
		super("Amount is negative. Please input a positive amount.");
	}
	
}
