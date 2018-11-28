package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.LoanDAO;
import be.massimo.pojo.Loan;

public class LoanBusiness {
	
	private Connection conn;
	
	public LoanBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public List<Loan> getOwnLoan(int id){
		return new LoanDAO(conn).getOwnLoan(id);
	}
}
