import java.util.ArrayList;
import java.util.Date;

public class Customer extends Account{
	private double balance;
	private Date birthday;  
	private ArrayList<TrolleyItem> shoppingTrolley;
	
	public Customer(String uID, String pw, String n, Date bd, double b) {
		super(uID, pw, n);
		birthday = bd;
		balance = b;
		shoppingTrolley = new ArrayList<TrolleyItem>();
	}
	
	public String getName() {
		return super.getName();
	}
	
	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return super.getName() + ", current balance: " + balance + ", no. items in trolley: " + shoppingTrolley.size();
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	//yoyo 1130
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public ArrayList<TrolleyItem> getTrolley(){
		return shoppingTrolley;
	}
	
	public void setTrolley(ArrayList<TrolleyItem> shoppingTrolley) {
		this.shoppingTrolley = shoppingTrolley;
	}
	
}
