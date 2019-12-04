
public class Gold implements Membership{
	private static Gold instance = new Gold();
	
	public static Gold getInstance() {
		return instance;
	}
	@Override
	public double getDiscount() {
		return 0.90;
	}
	
	public String toString() {
		return "Gold";
	}
	
}
