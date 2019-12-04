import java.util.*;
public class Main {
	private static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		boolean running = true;
		System.out.println("Hello, this is city shopper!");
		System.out.println("Testing version: 1.0");
        while(running) {
        	System.out.print("Please input your cmd: ");
        	String cmdLine = scanner.nextLine();
        	runOperation(cmdLine);
        }
	}
        
	public static void runOperation(String cmdLine) {
		String[] cmdParts = cmdLine.split(" ");
    	switch(cmdParts[0]) {
    		case "regCompany":
    			(new RegisterCompany()).execute(cmdParts);
    			break;
    		case "regCustomer":
    			(new RegisterCustomer()).execute(cmdParts);
    			break;
    		case "login":
    			(new LoginAccount()).execute(cmdParts);
    			break;
    		case "logout":
    			(new LogoutAccount()).execute(cmdParts);
    			break;
    		case "showAllShop":
    			(new ShowAllShop()).execute(cmdParts);
    			break;
    		case "showShopProduct":
    			(new ShowShopProduct()).execute(cmdParts);
    			break;
    		case "createProduct":
    			(new CreateProduct()).execute(cmdParts);
    			break;
    		case "addToTrolley":
    			(new AddToTrolley()).execute(cmdParts);
    			break;
    		case "removeFromTrolley":
    			(new RemoveFromTrolley()).execute(cmdParts);
    			break;
    		case "showTrolley":
    			(new ShowTrolley()).execute(cmdParts);
    			break;
    		case "deposit":
    			(new Deposit()).execute(cmdParts);
    			break;
    		case "fill":
    			(new FillProduct()).execute(cmdParts);
    			break;
    		case "checkout":
    			(new Checkout()).execute(cmdParts);
    			break;
    		case "showSaleRecord":
    			(new ShowSaleRecord()).execute(cmdParts);
    			break;
    		case "showStatus":
    			(new ShowStatus()).execute(cmdParts);
    			break;
    		default:
    			System.out.println("Invalid input.");
    	}
	}
}

