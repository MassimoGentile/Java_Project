package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import be.massimo.dao.BookingDAO;
import be.massimo.dao.ConnectionAccess;
import be.massimo.pojo.Booking;

public class BookingBusiness {
	
	private Connection conn;
	
	public BookingBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public List<Booking> getOwnBooking(int id){
		return new BookingDAO(conn).getOwnBooking(id);
	}
}
