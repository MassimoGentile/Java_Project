package be.massimo.project;

import java.time.LocalDateTime;

public class Loan {
	
	//	ATTRIBUTES
	private int Id;
	private LocalDateTime BeginDate;
	private LocalDateTime EndDate;
	private Borrower B;
	private Lender L;
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
	
	public Borrower getBorrower() {
		return this.B;
	}
	
	public void setBorrower(Borrower b) {
		this.B = b;
	}
	
	public Lender getLender() {
		return this.L;
	}
	
	public void setLender(Lender l) {
		this.L = l;
	}
	
	public Copy getCopy() {
		return this.C;
	}
	
	public void setCopy(Copy c) {
		this.C = c;
	}
	
	// 	CONSTRUCTOR(S)
	public Loan(int id, LocalDateTime datedebut, LocalDateTime datefin, Borrower b, Lender l) {
		this.Id = id;
		this.BeginDate = datedebut;
		this.EndDate = datefin;
		this.B = b;
		this.L = l;
	}
}
