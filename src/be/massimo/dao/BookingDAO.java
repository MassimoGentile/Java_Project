package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.massimo.pojo.Booking;

public class BookingDAO extends DAO<Booking>{
	
	public BookingDAO(Connection conn) {
		super(conn);
	}
	
	@Override
	public boolean create(Booking obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Booking (BBeginDateWanted, BBookingDate, BAvailable, Game_Id, Borrower_Id) VALUES ( '" + obj.getBeginDateWanted() + "', '" + obj.getBookingDate() + "', '" + obj.getAvailable() + "'," + obj.getGameWanted().getId() + ", " + obj.getBorrower().getId() + ")");
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Booking obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Booking WHERE Booking_Id=" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(Booking obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Booking SET BBeginDateWanted = '" + obj.getBeginDateWanted() + "', BBookingDate = '" + obj.getBookingDate() + "', BAvailable = '" + obj.getAvailable() + "', Game_Id =" + obj.getGameWanted().getId() + ", Borrower_Id =" + obj.getBorrower().getId() + " WHERE Booking_Id =" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Booking find(int id) {
		Booking booking = null;
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Booking WHERE Booking_Id =" + id);
			GameDAO gameDAO = new GameDAO(this.Connect);
			PlayerDAO playerDAO = new PlayerDAO(this.Connect);
			if(result.first())
				booking = new Booking(result.getString("BBeginDateWanted"), result.getString("BBookingDate"), result.getBoolean("BAvailable"), gameDAO.find(result.getInt("Game_Id")), playerDAO.find(result.getInt("Borrower_Id")));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return booking;
	}
	
	@Override 
	public List<Booking> getAll(){
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Booking");
			GameDAO gameDAO = new GameDAO(this.Connect);
			PlayerDAO playerDAO = new PlayerDAO(this.Connect);
			while(result.next())
				bookings.add(new Booking(result.getString("BBeginDateWanted"), result.getString("BBookingDate"), result.getBoolean("BAvailable"), gameDAO.find(result.getInt("Game_Id")), playerDAO.find(result.getInt("Borrower_Id"))));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}
	
	public List<Booking> getOwnBooking(int id){
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Booking WHERE Borrower_Id =" + id);
			GameDAO gameDAO = new GameDAO(this.Connect);
			PlayerDAO playerDAO = new PlayerDAO(this.Connect);
			while(result.next())
				bookings.add(new Booking(result.getString("BBeginDateWanted"), result.getString("BBookingDate"), result.getBoolean("BAvailable"), gameDAO.find(result.getInt("Game_Id")), playerDAO.find(result.getInt("Borrower_Id"))));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}
}
