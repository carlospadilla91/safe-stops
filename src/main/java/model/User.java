package model;

public class User {
	
	private Integer id;
	private String username;
	private String email;
	private String password;
	
	public User() {}
	
	public User(Integer id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		User user = (User) obj;
		
		return (user.username.equals(this.username) && user.id == this.id);
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + ", Username: " + this.username + ", Email: " + this.email + ", Password: " + this.password;
	}

	
}
