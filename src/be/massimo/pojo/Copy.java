package be.massimo.pojo;

import java.time.LocalDateTime;

public class Copy {
	
	//	Attributes
	private int Id;
	private LocalDateTime DateAdded;
	private Game G;
	private Player Lender;
	
	//	GET/SET
	public int getId() {
		return this.Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}
	
	public LocalDateTime getDateAdded() {
		return this.DateAdded;
	}
	
	public void setDateAdded(LocalDateTime dateAdded) {
		this.DateAdded = dateAdded;
	}
	
	public Game getGame() {
		return this.G;
	}
	
	public void setGame(Game g) {
		this.G = g;
	}
	
	public Player getLender() {
		return this.Lender;
	}
	
	public void setLender(Player lender) {
		this.Lender = lender;
	}
	
	//	CONSTRUCTOR(S)
	public Copy(int id, Game game, Player lender) {
		this.Id = id;
		this.DateAdded = LocalDateTime.now();
		this.G = game;
		this.Lender = lender;
	}
}
