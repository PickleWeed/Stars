
public class LoginInfo {
	
	private String  username;
	private String  password;
	private String type;
	private String  key ;

	public LoginInfo(String username, String password, String type, String key)
	{
		this.username = username;
		this.password = password;
		this.type = type;
		this.key = key;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
