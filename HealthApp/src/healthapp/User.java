package healthapp;

public abstract class User {
	public String username;
	public String password;
	public String fName;
	public String lName;
	public int pNum;

	public User(String username, String password, String fName, String lName, int pNum) {
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.pNum = pNum;

	}

	// login done through the HealthApp class
	public void logout() {
		System.exit(0);
	}
}
