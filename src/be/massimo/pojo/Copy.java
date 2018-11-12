package be.massimo.pojo;

import java.time.LocalDateTime;

public class Copy {
	
	//	Attributes
	private Game G;
	private LocalDateTime DateAdded;
	private Lender L;
	
	//	GET/SET
	public Game getGame() {
		return this.G;
	}
	
	public void setGame(Game g) {
		this.G = g;
	}
	
	public LocalDateTime getDateAdded() {
		return this.DateAdded;
	}
	
	public void setDateAdded(LocalDateTime dateAdded) {
		this.DateAdded = dateAdded;
	}
	
	public Lender getLender() {
		return this.L;
	}
	
	public void setLender(Lender l) {
		this.L = l;
	}
	
	//	CONSTRUCTOR(S)
	public Copy(Game game, Lender lender) {
		this.G = game;
		this.DateAdded = LocalDateTime.now();
		this.L = lender;
	}
}
