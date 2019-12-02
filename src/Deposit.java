
public class Deposit implements Command{
	
	@Override
	public void execute(String[] cmdParts) {
		try {
			if(cmdParts.length < 2) {
				throw new InsufficientParameterException();
			}
			ShopSystem shopSystem = ShopSystem.getInstance();
			int amount = Integer.parseInt(cmdParts[1]);
			if(shopSystem.depositToCurrentAccount(amount)) {
				System.out.println("Successfully added value to your account!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
