package be.massimo.pojo;

import java.util.Date;

public class Admin extends User{
	
	public Admin(int id, String name, String firstname, Date birthday, String email, String password, String address) {
		super(id, name, firstname, birthday, email, password, address);
	}
	
}
