
public class Normal implements Membership{
	private static Normal instance = new Normal();
	
	public static Normal getInstance() {
		return instance;
	}
	
	@Override
	public double getDiscount() {
		return 1.0;
	}

	
}
