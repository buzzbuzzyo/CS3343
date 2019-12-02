
public class LogoutAccount implements Command{
	@Override
	public void execute(String[] cmdParts) {
		ShopSystem shopSystem = ShopSystem.getInstance();
		try {
			if(shopSystem.accountLogOut())
				System.out.println("Sucessfully logged out! See you next time!");

		} catch (AccountIsEmptyException e) {
			System.out.println(e);
		}
	}
}
