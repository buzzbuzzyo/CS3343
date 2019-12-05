
public class RemoveFromTrolley implements Command {

	@Override
	public void execute(String[] cmdParts) {
		try {
			if (cmdParts.length < 3) {
				throw new InsufficientParameterException();
			}
			int pid = Integer.parseInt(cmdParts[1]);
			int quantity = Integer.parseInt(cmdParts[2]);
			ShopSystem shopSystem = ShopSystem.getInstance();
			shopSystem.removeItemFromTrolley(pid, quantity);
			System.out.println("Successfully removed the item from shopping trolley.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
