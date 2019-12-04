
public class ShowStatus implements Command {

	@Override
	public void execute(String[] cmdParts) {
		try {
			ShopSystem shopSystem = ShopSystem.getInstance();
			shopSystem.showStatus();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
