
public class CreateProduct implements Command{

	@Override
	public void execute(String[] cmdParts) {
		try {
			if(cmdParts.length < 5) {
				throw new InsufficientParameterException();
			}
			ShopSystem shopSystem = ShopSystem.getInstance();
			String productName = cmdParts[2];
			double productPrice = Double.parseDouble(cmdParts[3]);
			int productStock = Integer.parseInt(cmdParts[4]);
			
			if(shopSystem.createProductForCompany(productName, productPrice, productStock)) {
				System.out.println("Successfully create the product.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		

	}

}
