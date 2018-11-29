package be.massimo.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {
	
	//	ATTRIBUTES
	private int Id;
	private String BeginDate;
	private String EndDate;
	private Player Borrower;
	private Player Lender;
	private Copy C;
	
	//	GET/SET
	public int getId() {
		return this.Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}
	
	public String getBeginDate() {
		return this.BeginDate;
	}
	
	public void setBeginDate(String beginDate) {
		this.BeginDate = beginDate;
	}
	
	public String getEndDate() {
		return this.EndDate;
	}
	
	public void setEndDate(String endDate) {
		this.EndDate = endDate;
	}
	
	public Player getBorrower() {
		return this.Borrower;
	}
	
	public void setBorrower(Player borrower) {
		this.Borrower = borrower;
	}
	
	public Player getLender() {
		return this.Lender;
	}
	
	public void setLender(Player lender) {
		this.Lender = lender;
	}
	
	public Copy getCopy() {
		return this.C;
	}
	
	public void setCopy(Copy c) {
		this.C = c;
	}
	
	// 	CONSTRUCTOR(S)
	public Loan(int id, String datedebut, String datefin, Player borrower, Player lender, Copy copy) {
		this.Id = id;
		this.BeginDate = datedebut;
		this.EndDate = datefin;
		this.Borrower = borrower;
		this.Lender = lender;
		this.C = copy;
	}
	
	public Loan(String datefin, Player borrower, Player lender, Copy copy) {
		this.BeginDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		this.EndDate = datefin;
		this.Borrower = borrower;
		this.Lender = lender;
		this.C = copy;
	}
}
