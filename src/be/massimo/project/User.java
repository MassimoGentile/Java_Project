package be.massimo.project;

import java.util.Date;

public abstract class User {
	private int Id;
	private String Name;
	private String Firstname;
	private Date Birthday;
	private String Email;
	private String Password;
	private String Address;
	
	public User(int id, String name, String firstname, Date birthday, String email, String password, String address) {
		this.Id = id;
		this.Name = name;
		this.Firstname = firstname;
		this.Birthday = birthday;
		this.Email = email;
		this.Password = password;
		this.Address = address;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public String getFirstname() {
		return this.Firstname;
	}
	
	public Date getBirthday() {
		return this.Birthday;
	}
	
	public String getEmail() {
		return this.Email;
	}
	
	public String getPassword() {
		return this.Password;
	}
	
	public String getAddress() {
		return this.Address;
	}
}
