package be.massimo.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player extends User{
	
	// 	ATTRIBUTES
	private Boolean Admin;
	private int Amount;
	private LocalDateTime RegisterDate;
	private List<Booking> ListBooking;
	private List<Copy> ListCopy;
	
	// 	GET/SET
	public Boolean getAdmin() {
		return this.Admin;
	}
	
	public void setAdmin(Boolean admin) {
		this.Admin = admin;
	}
	
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
	
	public void addBooking(Booking booking) {
		if(!this.ListBooking.contains(booking))
			this.ListBooking.add(booking);
	}
	
	public void removeBooking(Booking booking) {
		this.ListBooking.remove(booking);
	}
	
	public List<Copy> getListCopy(){
		return this.ListCopy;
	}
	
	public void setListCopy(List<Copy> listCopy) {
		this.ListCopy = listCopy;
	}
	
	public void addCopy(Copy copy) {
		if(!this.ListCopy.contains(copy))
			this.ListCopy.add(copy);
	}
	
	public void removeCopy(Copy copy) {
		this.ListCopy.remove(copy);
	}
	
	//	CONSTRUCTOR(S)
	public Player(int id, String name, String firstname, Date birthday, String email, String password, String address) {
		super(id, name, firstname, birthday, email, password, address);
		this.Admin = false;
		this.Amount = 10;
		this.RegisterDate = LocalDateTime.now();
		this.ListBooking = new ArrayList<Booking>();
		this.ListCopy = new ArrayList<Copy>();
	}
	
	public Player(String name, String firstname, Date birthday, String email, String password, String address) {
		super(name, firstname, birthday, email, password, address);
		this.Admin = false;
		this.Amount = 10;
		this.RegisterDate = LocalDateTime.now();
		this.ListBooking = new ArrayList<Booking>();
		this.ListCopy = new ArrayList<Copy>();
	}
	
	public Player(String email, String password) {
		super(email, password);
		this.Admin = false;
		this.Amount = 10;
		this.RegisterDate = LocalDateTime.now();
		this.ListBooking = new ArrayList<Booking>();
		this.ListCopy = new ArrayList<Copy>();
	}
	
	public Player(int id, String name, String firstname, Date birthday, String email, String password, String address, Boolean admin, int amount, LocalDateTime registerDate) {
		super(id, name, firstname, birthday, email, password, address);
		this.Admin = admin;
		this.Amount = amount;
		this.RegisterDate = registerDate;
		this.ListBooking = new ArrayList<Booking>();
		this.ListCopy = new ArrayList<Copy>();
	}
}
