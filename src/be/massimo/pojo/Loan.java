package be.massimo.pojo;

import java.time.LocalDateTime;

public class Loan {
	
	//	ATTRIBUTES
	private int Id;
	private LocalDateTime BeginDate;
	private LocalDateTime EndDate;
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
	
	public LocalDateTime getBeginDate() {
		return this.BeginDate;
	}
	
	public void setBeginDate(LocalDateTime beginDate) {
		this.BeginDate = beginDate;
	}
	
	public LocalDateTime getEndDate() {
		return this.EndDate;
	}
	
	public void setEndDate(LocalDateTime endDate) {
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
	public Loan(int id, LocalDateTime datedebut, LocalDateTime datefin, Player borrower, Player lender) {
		this.Id = id;
		this.BeginDate = datedebut;
		this.EndDate = datefin;
		this.Borrower = borrower;
		this.Lender = lender;
	}
}
