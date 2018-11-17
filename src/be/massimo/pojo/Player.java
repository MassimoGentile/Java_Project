package be.massimo.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Player extends User{
	
	// 	ATTRIBUTES
	private int Amount;
	private LocalDateTime RegisterDate;
	private List<Booking> ListBooking;
	private List<Copy> ListCopy;
	
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
	
	public List<Booking> getListBokking(){
		return this.ListBooking;
	}
	
	public void setListBooking(List<Booking> listBooking) {
		this.ListBooking = listBooking;
	}
	
	public List<Copy> getListCopy(){
		return this.ListCopy;
	}
	
	public void setListCopy(List<Copy> listCopy) {
		this.ListCopy = listCopy;
	}
	
	//	CONSTRUCTOR(S)
	public Player(int id, String name, String firstname, Date birthday, String email, String password, String address) {
		super(id, name, firstname, birthday, email, password, address);
		this.Amount = 10;
		this.RegisterDate = LocalDateTime.now();
		this.ListBooking = new ArrayList<Booking>();
		this.ListCopy = new ArrayList<Copy>();
	}
	
	public Player(int id, String email, String password) {
		super(id, email, password);
		this.Amount = 10;
		this.RegisterDate = LocalDateTime.now();
		this.ListBooking = new ArrayList<Booking>();
		this.ListCopy = new ArrayList<Copy>();
	}
}
