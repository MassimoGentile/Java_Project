package be.massimo.pojo;

import java.util.Date;

public abstract class User {
	
	//	ATTRIBUTES
	private int Id;
	private String Name;
	private String Firstname;
	private Date Birthday;
	private String Address;
	private String Email;
	private String Password;
	
	//	GET/SET
	public int getId() {
		return this.Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public String getFirstname() {
		return this.Firstname;
	}
	
	public void setFirstname(String firstname) {
		this.Firstname = firstname;
	}
	
	public Date getBirthday() {
		return this.Birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.Birthday = birthday;
	}
	
	public String getAddress() {
		return this.Address;
	}
	
	public void setAddress(String address) {
		this.Address = address;
	}
	
	public String getEmail() {
		return this.Email;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public String getPassword() {
		return this.Password;
	}
	
	public void setPassword(String password) {
		this.Password = password;
	}
	
	//	CONSTRUCTOR(S)
	public User(int id, String name, String firstname, Date birthday, String address, String email, String password) {
		this.Id = id;
		this.Name = name;
		this.Firstname = firstname;
		this.Birthday = birthday;
		this.Address = address;
		this.Email = email;
		this.Password = password;
	}
	
	public User(String name, String firstname, Date birthday, String address, String email, String password) {
		this.Name = name;
		this.Firstname = firstname;
		this.Birthday = birthday;
		this.Address = address;
		this.Email = email;
		this.Password = password;
	}
	
	public User(String email, String password) {
		this.Name = "";
		this.Firstname = "";
		this.Birthday = new Date();
		this.Address = "";
		this.Email = email;
		this.Password = password;
	}
}
