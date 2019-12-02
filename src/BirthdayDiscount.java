
public class BirthdayDiscount extends ProductDiscount {
	
	
	public BirthdayDiscount(double discountRate) {
		super(discountRate);
	}
	
	public boolean isValidDiscount() {
		return false;
	}

}
