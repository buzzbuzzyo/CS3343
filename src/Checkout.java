
public class Checkout implements Command{

	@Override
	public void execute(String[] cmdParts) {
		try { 
			ShopSystem shopSystem = ShopSystem.getInstance();
			if(shopSystem.checkout()) {
				System.out.println("Successfully checked-out!");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
