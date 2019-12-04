public class RegisterCompany implements Command {

	@Override
	public void execute(String[] cmdParts) {
		try {
			if (cmdParts.length < 4) {
				throw new InsufficientParameterException();
			}
			String id = cmdParts[1];
			String password = cmdParts[2];
			String name = cmdParts[3];
			Company newCompany = new Company(id, password, name);
			ShopSystem shopSystem = ShopSystem.getInstance();
			shopSystem.registerCompany(newCompany);
			System.out.println("Successfully create an account, account name: " + newCompany.getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}