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
			Date birthday = new SimpleDateFormat("yyyy/MM/dd").parse(cmdParts[4]);
			double balance = Double.parseDouble(cmdParts[5]);
			Customer newCustomer = new Customer(id, pw, name, birthday, balance);
			ShopSystem shopSystem = ShopSystem.getInstance();
			if(shopSystem.registerCustomer(newCustomer)) {
				System.out.println("Successfully create Account,  Account name:  "+ newCustomer.getName());
			}
		} catch (ParseException e) {
			System.out.println("Wrong format for birth. Please input birthday in dd/MM/yyyy format.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  
		
	}

}
