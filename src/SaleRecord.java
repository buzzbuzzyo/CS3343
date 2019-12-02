import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleRecord {
	private Customer customer;
	private TrolleyItem item;
	private Date date;
	
	public SaleRecord(Customer customer, TrolleyItem item) {
		this.customer = customer;
		this.item = item;
		date = new Date();
	}
	
	public String toString() {
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
	    String strDate = formatter.format(date);
	    int quantity = item.getQuantity();
	    Product product = item.getProduct();
	    
		return strDate + " " + customer.getName() + ": " + product.getName() + "(" + product.getPid() + ")*" + quantity; 
	}
}
