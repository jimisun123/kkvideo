package kkvideo.admin.bean;

public class AdminUser {
	
	private String usertoken;
	private String username;
	private String password;
	
	public AdminUser() {
	}
	
	public AdminUser(String username, String password, String usertoken) {
		super();
		this.username = username;
		this.password = password;
		this.usertoken = usertoken;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertoken() {
		return usertoken;
	}

	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}

}
