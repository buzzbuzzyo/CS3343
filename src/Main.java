import java.util.*;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean running = true;
		System.out.println("Hello, this is city shopper!");
		System.out.println("Testing version: 1.0");

		/*
		 * /*********************** FOR DEVELOPER TESTING!
		 * ****************************** runOperation("regCompany cityu 1234 cityu");
		 * runOperation("login cityu 1234");
		 * runOperation("regCompany cityu 1234 cityu");
		 * runOperation("createProduct apple 5 500");
		 * runOperation("createProduct orange 10 500");
		 * runOperation("createProduct yoyoSin 1 500"); runOperation("showStatus");
		 * runOperation("fill 10000 300"); runOperation("logout");
		 * runOperation("regCustomer tkleung 1234 Sam 2019/11/28 500");
		 * runOperation("login tkleung 1234"); runOperation("showAllShop");
		 * runOperation("showShopProduct cityu");
		 * runOperation("addToTrolley cityu 10000 10");
		 * runOperation("addToTrolley cityu 10001 10");
		 * runOperation("addToTrolley cityu 10002 50");
		 * runOperation("removeFromTrolley 10000 10");
		 * runOperation("removeFromTrolley 10001 2"); runOperation("logout");
		 * runOperation("login cityu 1234"); runOperation("remove 10001");
		 * runOperation("logout"); runOperation("login tkleung 1234");
		 * runOperation("addToTrolley cityu 10001 10"); runOperation("checkout");
		 * //*********************** FOR DEVELOPER TESTING!
		 ******************************/

		while (running) {
			System.out.print("Please input your cmd: ");
			String cmdLine = scanner.nextLine();
			runOperation(cmdLine);
		}
	}

	public static void runOperation(String cmdLine) {

		/************************
		 * FOR DEVELOPER TESTING! ******************************
		 * System.out.println("************************************");
		 * System.out.println(cmdLine); //*********************** FOR DEVELOPER TESTING!
		 ******************************/

		String[] cmdParts = cmdLine.split(" ");
		switch (cmdParts[0]) {
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
		case "remove":
			(new RemoveProductFromCompany()).execute(cmdParts);
			break;
		default:
			System.out.println("Invalid input.");
		}
	}
}
