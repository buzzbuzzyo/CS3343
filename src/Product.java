
public class Product {
	private int pid;
	private String name;
	private double price;
	private int stock;
	
	public Product(int pid, String name, double price, int stock) {
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public void addStock(int amount) {
		stock += amount;
	}
	
	public String toString() {
		return String.format("%d: %s, $%f, %d in stock", pid, name, price, stock);
	}
	
	public int getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public void soldProduct(int number) {
		stock -= number;
	}
}
