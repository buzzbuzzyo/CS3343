
public class RemoveProductFromCompany implements Command{
	@Override
	public void execute(String[] cmdParts) {
		try {
			if(cmdParts.length != 2) {
				throw new InsufficientParameterException();
			}
			ShopSystem shopSystem = ShopSystem.getInstance();
			int productID = Integer.parseInt(cmdParts[1]);
			shopSystem.removeProductFromCompany(productID);
			System.out.printf("Product %s was removed from product list.\n",productID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
