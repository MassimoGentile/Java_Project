package be.massimo.pojo;

import java.time.LocalDateTime;

public class Copy {
	
	//	Attributes
	private Game G;
	private LocalDateTime DateAdded;
	private Player Lender;
	
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
	
	public Player getLender() {
		return this.Lender;
	}
	
	public void setLender(Player lender) {
		this.Lender = lender;
	}
	
	//	CONSTRUCTOR(S)
	public Copy(Game game, Player lender) {
		this.G = game;
		this.DateAdded = LocalDateTime.now();
		this.Lender = lender;
	}
}