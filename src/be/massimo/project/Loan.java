package be.massimo.project;

import java.util.Date;

public class Loan {
	
	private int Id;
	private Date DateDebut;
	private Date DateFin;
	private Borrower B;
	private Lender L;
	
	public Loan(int id, Date datedebut, Date datefin, Borrower b, Lender l) {
		this.Id = id;
		this.DateDebut = datedebut;
		this.DateFin = datefin;
		this.B = b;
		this.L = l;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public Date getDateDebut() {
		return this.DateDebut;
	}
	
	public Date getDateFin() {
		return this.DateFin;
	}
	
	public Borrower getBorrower() {
		return this.B;
	}
	
	public Lender getLender() {
		return this.L;
	}
}
