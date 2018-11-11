package be.massimo.project;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Borrower extends Player{
	
	//	ATTRIBUTES
	private List<Booking> ListBooking;
	
	// 	GET/SET
	
	public List<Booking> getListBooking(){
		return this.ListBooking;
	}
	
	public void setListBooking(List<Booking> listBooking) {
		this.ListBooking = listBooking;
	}
	
	// 	CONSTRUCTOR(S)
	public Borrower(int id, String name, String firstname, Date birthday, String email, String password, String address, LocalDateTime registerDate, List<Booking> listBooking) {
		super(id, name, firstname, birthday, email, password, address, registerDate);
		this.ListBooking = listBooking;
	}
	
	public Borrower(int id, String email, String password, List<Booking> listBooking) {
		super(id, email, password);
		this.ListBooking = listBooking;
	}
}
