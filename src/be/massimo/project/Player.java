package be.massimo.project;

import java.util.Date;

public class Player extends User{
	
	private int Amount;
	private Date RegisterDate;
	
	public Player(int id, String name, String firstname, Date birthday, String email, String password, String address, int amount, Date registerDate) {
		super(id, name, firstname, birthday, email, password, address);
		this.Amount = amount;
		this.RegisterDate = registerDate;
	}
	
	public int getAmount() {
		return this.Amount;
	}
	
	public Date getRegisterDate() {
		return this.RegisterDate;
	}
	
}
