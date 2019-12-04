import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleRecord {
	private Customer customer;
	private TrolleyItem item;
	private Date date;
	private double totalAmount;
	
	public SaleRecord(Customer customer, TrolleyItem item, double totalAmount) {
		this.customer = customer;
		this.item = item;
		date = new Date();
		this.totalAmount = totalAmount;
	}
	
	public String toString() {
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
	    String strDate = formatter.format(date);
	    int quantity = item.getQuantity();
	    Product product = item.getProduct();
	    
		return strDate + " " + product.getName() + "*" + quantity +  " " + customer.getName() + " ($" + totalAmount + " in total)";
	}
}
