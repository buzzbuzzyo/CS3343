import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Customer extends Account{
	private double balance;
	private Date birthday;  
	private ArrayList<TrolleyItem> shoppingTrolley;
	private Membership member;
	
	public Customer(String userID, String password, String name, Date birthday, double balance) {
		super(userID, password, name);
		this.birthday = birthday;
		this.balance = balance;
		this.shoppingTrolley = new ArrayList<TrolleyItem>();
		this.member = Normal.getInstance();
		
	}
	public Membership getMembership() {
		return member;
	}
	
	public String getName() {
		return super.getName();
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean isBirthdayToday() {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		Calendar bday = Calendar.getInstance();
		calendar.setTime(today);
		bday.setTime(birthday);
		
		return (calendar.get(Calendar.MONTH) == bday.get(Calendar.MONTH)) &&  (calendar.get(Calendar.DAY_OF_MONTH) == bday.get(Calendar.DAY_OF_MONTH));
		
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
	public void setMembership(Membership member) {
		this.member = member;
		
	}
	public void emptyTrolley() {
		shoppingTrolley.clear();
		
	}
	
	
}
