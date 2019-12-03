
public class Platinum implements Membership{
	private static Platinum instance = new Platinum();
	
	public static Platinum getInstance() {
		return instance;
	}
	@Override
	public double getDiscount() {
		return 0.85;
	}
	
}
