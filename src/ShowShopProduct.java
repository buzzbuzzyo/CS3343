
public class ShowShopProduct implements Command {

	@Override
	public void execute(String[] cmdParts) {
		try {
			if (cmdParts.length < 2) {
				throw new InsufficientParameterException();
			}
			ShopSystem shopSystem = ShopSystem.getInstance();
			shopSystem.showShopProduct(cmdParts[1]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
