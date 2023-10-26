
public abstract class User {
	protected String login;
	protected String password;
	protected String type;
	protected String name;
	
	public User(String login, String password,String type,String name)
	{
		this.login=login;
		this.password=password;
		this.type=type;
		this.name=name;
		
		
		
		
		
	}
	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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

}
