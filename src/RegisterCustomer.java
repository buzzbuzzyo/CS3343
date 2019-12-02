import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterCustomer implements Command{
	
	@Override
	public void execute(String[] cmdParts) {
		try {
			if(cmdParts.length < 6) {
				throw new InsufficientParameterException();
			}
			String id = cmdParts[1];
			String pw = cmdParts[2];
			String name = cmdParts[3];
			Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(cmdParts[4]);
			double balance = Double.parseDouble(cmdParts[5]);
			Customer newCustomer = new Customer(id, pw, name, birthday, balance);
			ShopSystem shopSystem = ShopSystem.getInstance();
			if(shopSystem.registerCustomer(newCustomer)) {
				System.out.println("Successfully create Account,  Account name:  "+ newCustomer.getName());
			} else {
				System.out.println("The id is existed. Please choose another id.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  
		
	}

}
