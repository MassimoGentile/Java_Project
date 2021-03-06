package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Loan (LBeginDate, LEndDate, Borrower_Id, Lender_Id, Copy_Id) VALUES ( '" + obj.getBeginDate() + "', '" + obj.getEndDate() + "', " + obj.getBorrower().getId() + ", " + obj.getLender().getId() + ", " + obj.getCopy().getId() + ")");
		}catch(SQLException e) {
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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Loan WHERE Loan_Id=" + obj.getId());
		}catch(SQLException e) {
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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Loan SET LBeginDate = '" + obj.getBeginDate() + "', LEndDate = '" + obj.getEndDate() + "', Borrower_Id = " + obj.getBorrower().getId() + ", Lender_Id = " + obj.getLender().getId() + ", Copy_Id = " + obj.getCopy().getId() + " WHERE Loan_Id =" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Loan find(int id) {
		Loan loan = null;
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Loan WHERE Loan_Id =" + id);
			PlayerDAO playerDAO = new PlayerDAO(this.Connect);
			CopyDAO copyDAO = new CopyDAO(this.Connect);
			if(result.first())
				loan = new Loan(id, result.getString("LBeginDate"), result.getString("LEndDate"), playerDAO.find(result.getInt("Borrower_Id")), playerDAO.find(result.getInt("Lender_Id")), copyDAO.find(result.getInt("Copy_Id")));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return loan;
	}
	
	@Override
	public List<Loan> getAll(){
		List<Loan> loans = new ArrayList<Loan>();
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Loan");
			PlayerDAO playerDAO = new PlayerDAO(this.Connect);
			CopyDAO copyDAO = new CopyDAO(this.Connect);
			while(result.next())
				loans.add(new Loan(result.getInt("Loan_Id"), result.getString("LBeginDate"), result.getString("LEndDate"), playerDAO.find(result.getInt("Borrower_Id")), playerDAO.find(result.getInt("Lender_Id")), copyDAO.find(result.getInt("Copy_Id"))));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return loans;
	}
	
	public List<Loan> getOwnLoan(int id){
		List<Loan> loans = new ArrayList<Loan>();
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Loan WHERE Borrower_Id =" + id);
			PlayerDAO playerDAO = new PlayerDAO(this.Connect);
			CopyDAO copyDAO = new CopyDAO(this.Connect);
			while(result.next())
				loans.add(new Loan(result.getInt("Loan_Id"), result.getString("LBeginDate"), result.getString("LEndDate"), playerDAO.find(result.getInt("Borrower_Id")), playerDAO.find(result.getInt("Lender_Id")), copyDAO.find(result.getInt("Copy_Id"))));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return loans;
	}
}
