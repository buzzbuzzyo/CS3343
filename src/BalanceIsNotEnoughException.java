
public class BalanceIsNotEnoughException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BalanceIsNotEnoughException() {
		super("The balance is not enough to complete the payment!");
	}

}
