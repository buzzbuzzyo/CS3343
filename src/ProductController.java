
public class ProductController {
	//start from 10000
	private int pidCounter = 10000;
	private static ProductController instance = new ProductController();
	

	public static ProductController getInstance() {
		return instance;
	}
	
	public Product createProductForCompany(Account currentAccount, String name, double price, int stock) {
		Product product = new Product(pidCounter++,name,price,stock);
		((Company) currentAccount).addProduct(product);
		return product;
		
	}
}
