
public class ShowAllShop implements Command {

	@Override
	public void execute(String[] cmdParts) {
		try {
			ShopSystem shopSystem = ShopSystem.getInstance();
			shopSystem.showAllShop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
