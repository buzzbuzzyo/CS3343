
public class ShowTrolley implements Command{

	@Override
	public void execute(String[] cmdParts) {
		ShopSystem shopSystem = ShopSystem.getInstance();
		try {
			shopSystem.showCurrentAccountTrolley(); 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
	}

}
