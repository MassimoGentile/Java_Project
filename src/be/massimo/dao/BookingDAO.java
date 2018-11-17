package be.massimo.dao;

import java.sql.Connection;

import be.massimo.pojo.Booking;

public class BookingDAO extends DAO<Booking>{
	
	public BookingDAO(Connection conn) {
		super(conn);
	}
	
	@Override
	public boolean create(Booking obj) {
		return false;
	}
	
	@Override
	public boolean delete(Booking obj) {
		return false;
	}
	
	@Override
	public boolean update(Booking obj) {
		return false;
	}
	
	@Override
	public Booking find(int id) {
		return null;
	}
}
