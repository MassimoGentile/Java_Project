package be.massimo.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Player extends User{
	
	// 	ATTRIBUTES
	private int Amount;
	private LocalDateTime RegisterDate;
	
	// 	GET/SET
	public int getAmount() {
		return this.Amount;
	}
	
	public void setAmount(int amount) {
		this.Amount = amount;
	}
	
	public LocalDateTime getRegisterDate() {
		return this.RegisterDate;
	}
	
	//	CONSTRUCTOR(S)
	public Player(int id, String name, String firstname, Date birthday, String email, String password, String address, LocalDateTime registerDate) {
		super(id, name, firstname, birthday, email, password, address);
		this.Amount = 10;
		this.RegisterDate = registerDate;
	}
	
	public Player(int id, String email, String password) {
		super(id, email, password);
		this.Amount = 10;
		this.RegisterDate = LocalDateTime.now();
	}
}
