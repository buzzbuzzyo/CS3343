

public class RemoveFromTrolley implements Command{
	Company company;
	Product product;
	int quantity;
	Account user;

	@Override
	public void execute(String[] cmdParts) {
		try {
			if(cmdParts.length < 4) {
				throw new InsufficientParameterException();
			}
			ShopSystem shopSystem = ShopSystem.getInstance();
			company = shopSystem.searchCompanyById(cmdParts[1]);
			product = shopSystem.searchProductInCompany(company,Integer.parseInt(cmdParts[2]));
			quantity = Integer.parseInt(cmdParts[3]);
			shopSystem.removeItemFromTrolley(product, quantity);
			System.out.println("Successfully removed the item from shopping trolley.");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
