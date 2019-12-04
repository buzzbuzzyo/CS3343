
public class TrolleyItem {
	private Product product;
	private int quantity;
	private Company company;

	public TrolleyItem(Product product, int quantity, Company company) {
		this.product = product;
		this.quantity = quantity;
		this.company = company;
	}

	public void changeQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}

	public void subQuantity(int quantity) {
		this.quantity -= quantity;
	}

	public String toString() {
		return product.getName() + "(" + product.getPid() + ")   $" + product.getPrice() + "*" + quantity + "   $"
				+ (product.getPrice() * quantity);
	}

	public Product getProduct() {
		return this.product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public double getTotal() {
		return product.getPrice() * quantity;
	}

	public Company getCompany() {
		return company;
	}
}
