package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import be.massimo.pojo.Loan;


public class LoanDAO extends DAO<Loan>{
	
	public LoanDAO(Connection conn) {
		super(conn);
	}
	
	@Override
	public boolean create(Loan obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Loan (Loan_BeginDate, Loan_EndDate, User_Id, Copy_Id, Booking_Id) VALUES (" + obj.getBeginDate() + "," + obj.getEndDate() + "," + obj.getLender().getId() + "," + obj.getCopy().getId() + "," + obj.getBooking().getId() + ")");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Loan obj) {
		return false;
	}
	
	@Override
	public boolean update(Loan obj) {
		return false;
	}
	
	@Override
	public Loan find(int id) {
		return null;
	}
}
