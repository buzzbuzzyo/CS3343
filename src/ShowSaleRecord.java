
public class ShowSaleRecord implements Command{

	@Override
	public void execute(String[] cmdParts) {
		try {
			ShopSystem shopSystem = ShopSystem.getInstance();
			shopSystem.showSaleRecord();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
	}

}
