
public class NoSuchProductException extends Exception {
	
	public NoSuchProductException() {
		super ("No such product! Please use ShowShopProduct command to show all product in shop.");
	}
	
	public NoSuchProductException(String message) {
		super(message);
	}

}
