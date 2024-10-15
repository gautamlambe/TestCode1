package lambegautam.gradecode1.pack1;
//this class store all the user/customer related information/data
public class User {
	private String userName;
	private String emialId;
    private String password;
	private long supercoin;
	
	//constructor of user class to get input at time of creation of object
	
	public User(String userName, String password, String emailId, long supercoin) {
		super();
		this.userName = userName;
		this.emialId = emailId;
		this.password = password;
		this.supercoin = supercoin;
	}

	//getters and setter so that we can get and set value of private variables
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmialId() {
		return emialId;
	}

	public void setEmialId(String emialId) {
		this.emialId = emialId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getSupercoin() {
		return supercoin;
	}

	public void setSupercoin(long supercoin) {
		this.supercoin = supercoin;
	}
	
	
	
	
	
}
