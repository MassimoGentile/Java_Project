package be.massimo.pojo;

import java.time.LocalDateTime;

public class Copy {
	
	//	Attributes
	private int Id;
	private Game G;
	private LocalDateTime DateAdded;
	private Player Lender;
	
	//	GET/SET
	public int getId() {
		return this.Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}
	
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
	public Copy(int id, Game game, Player lender) {
		this.Id = id;
		this.G = game;
		this.DateAdded = LocalDateTime.now();
		this.Lender = lender;
	}
}
