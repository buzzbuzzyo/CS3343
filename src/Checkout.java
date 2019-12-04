
public class Checkout implements Command{

	@Override
	public void execute(String[] cmdParts) {
		try { 
			ShopSystem shopSystem = ShopSystem.getInstance();
			shopSystem.checkout();
			System.out.println("Successfully checked-out!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
