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
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Loan (Loan_BeginDate, Loan_EndDate, Borrower_Id, Lender_Id, Copy_Id) VALUES (" + obj.getBeginDate() + "," + obj.getEndDate() + "," + obj.getBorrower().getId() + "," + obj.getLender().getId() + "," + obj.getCopy().getId() + ")");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Loan obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Loan WHERE Loan_Id=" + obj.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(Loan obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Loan SET Loan_BeginDate =" + obj.getBeginDate() + ", Loan_EndDate =" + obj.getEndDate() + ", Borrower_Id =" + obj.getBorrower().getId() + ", Lender_Id =" + obj.getLender().getId() + ", Copy_Id =" + obj.getCopy().getId() + " WHERE Loan_Id =" + obj.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Loan find(int id) {
		return null;
	}
}
