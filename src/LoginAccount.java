
public class LoginAccount implements Command{
	@Override
	public void execute(String[] cmdParts) {
		try {
			if(cmdParts.length < 3) {
				throw new InsufficientParameterException();
			}
			String id = cmdParts[1];
			String password = cmdParts[2];
			ShopSystem shopSystem = ShopSystem.getInstance();
			Account account = shopSystem.accountLogin(id, password);
			if (account != null) {
				System.out.println("Successfully login, Welcome " + account.getName() + "!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
