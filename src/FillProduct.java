
public class FillProduct implements Command {

	@Override
	public void execute(String[] cmdParts) {
		try {
			if (cmdParts.length != 3) {
				throw new InsufficientParameterException();
			}
			ShopSystem shopSystem = ShopSystem.getInstance();
			int productID = Integer.parseInt(cmdParts[1]);
			int quantity = Integer.parseInt(cmdParts[2]);
			if (quantity < 0) {
				throw new AmountIsNegativeException();
			}
			shopSystem.fillProductForCompany(productID, quantity);
			System.out.printf("Successfully fill the product %s with quantity of %s. \n", productID, quantity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
