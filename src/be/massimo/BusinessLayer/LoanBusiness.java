package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.CopyDAO;
import be.massimo.dao.LoanDAO;
import be.massimo.dao.PlayerDAO;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Loan;
import be.massimo.pojo.Player;

public class LoanBusiness {
	
	private Connection conn;
	
	public LoanBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public List<Loan> getOwnLoan(int id){
		return new LoanDAO(conn).getOwnLoan(id);
	}
	
	public void MakeLoan(String endDate, Player borrower, Copy copy) {
		if(copy.getAvailable() != false) {
			LoanDAO loanDAO = new LoanDAO(conn);
			PlayerDAO playerDAO = new PlayerDAO(conn);
			loanDAO.create(new Loan(endDate, borrower, playerDAO.find(copy.getLender().getId()), copy));
			copy.setAvailable(false);
			CopyDAO copyDAO = new CopyDAO(conn);
			copyDAO.update(copy);
			JOptionPane.showMessageDialog(null, "Loan Create With Success", "Error", JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null, "This copy is unavailable", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void RemoveLoan(Loan loan) {
		LoanDAO loanDAO = new LoanDAO(conn);
		loanDAO.delete(loan);
		CopyDAO copyDAO = new CopyDAO(conn);
		loan.getCopy().setAvailable(true);
		copyDAO.update(loan.getCopy());
		JOptionPane.showMessageDialog(null, "Loan Successfully Remove", "Remove Success", JOptionPane.INFORMATION_MESSAGE);
	}
}
