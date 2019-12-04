
public class CreateProduct implements Command {

	@Override
	public void execute(String[] cmdParts) {
		try {
			if (cmdParts.length < 4) {
				throw new InsufficientParameterException();
			}
			ShopSystem shopSystem = ShopSystem.getInstance();
			String productName = cmdParts[1];
			double productPrice = Double.parseDouble(cmdParts[2]);
			int productStock = Integer.parseInt(cmdParts[3]);
			if (productStock < 0) {
				throw new AmountIsNegativeException();
			}
			shopSystem.createProductForCompany(productName, productPrice, productStock);
			System.out.println("Successfully create the product.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
