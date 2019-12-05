
public abstract class Account {
	private String userID;
	private String password;
	private String name;

	public Account(String userID, String password, String name) {
		this.userID = userID;
		this.password = password;
		this.name = name;
	}

	public boolean login(String userID, String password) {
		return (this.userID.equals(userID)) && (this.password.equals(password));
	}

	public String getName() {
		return name;
	}

	public String getUserID() {
		return userID;
	}

	public abstract String toString();
}
