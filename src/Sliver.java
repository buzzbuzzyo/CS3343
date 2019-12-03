
public class Sliver implements Membership{
	private static Sliver instance = new Sliver();
	
	public static Sliver getInstance() {
		return instance;
	}
	@Override
	public double getDiscount() {
		return 0.95;
	}
	
}
