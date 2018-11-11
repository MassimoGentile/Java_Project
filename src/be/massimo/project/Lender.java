package be.massimo.project;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Lender extends Player{
	
	//	ATTRIBUTES
	private List<Copy> ListCopy;
	
	// GET/SET
	public List<Copy> getListCopy(){
		return this.ListCopy;
	}
	
	public void setListCopy(List<Copy> listCopy) {
		this.ListCopy = listCopy;
	}
	
	//	CONSTRUCTOR(S)
	public Lender(int id, String name, String firstname, Date birthday, String email, String password, String address, LocalDateTime registerDate, List<Copy> listCopy) {
		super(id, name, firstname, birthday, email, password, address, registerDate);
		this.ListCopy = listCopy;
	}
	
	public Lender(int id, String email, String password, List<Copy> listCopy) {
		super(id, email, password);
		this.ListCopy = listCopy;
	}
}
