package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Booking (BBeginDateWanted, BBookingDate, Game_Id, Borrower_Id) VALUES (" + obj.getBeginDateWanted() + "," + obj.getBookingDate() + "," + obj.getGameWanted().getId() + "," + obj.getBorrower().getId() + ")");
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
					ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Booking WHERE Booking_Id=" + obj.getId());
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
					ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Booking SET BBeginDateWanted =" + obj.getBeginDateWanted() + ", BBookingDate =" + obj.getBookingDate() + ", Game_Id =" + obj.getGameWanted().getId() + ", Borrower_Id =" + obj.getBorrower().getId() + " WHERE Booking_Id =" + obj.getId());
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
				booking = new Booking(result.getDate("BBeginDateWanted"), result.getDate("BBookingDate"), gameDAO.find(result.getInt("Game_Id")), playerDAO.find(result.getInt("User_Id")));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return booking;
	}
}
