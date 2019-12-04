
public class NoSuchProductException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchProductException(String string) {
		super ("No such product! Please use ShowShopProduct command to show all product in shop.");
	}

	public NoSuchProductException() {
		super("No such product!" );
	}
	
}
