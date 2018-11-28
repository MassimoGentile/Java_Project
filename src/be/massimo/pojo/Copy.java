package be.massimo.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Copy {
	
	//	Attributes
	private int Id;
	private String DateAdded;
	private Game G;
	private Player Lender;
	
	//	GET/SET
	public int getId() {
		return this.Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}
	
	public String getDateAdded() {
		return this.DateAdded;
	}
	
	public void setDateAdded(String dateAdded) {
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
		this.DateAdded = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		this.G = game;
		this.Lender = lender;
	}
	
	public Copy(int id, String dateAdded, Game game, Player lender) {
		this.Id = id;
		this.DateAdded = dateAdded;
		this.G= game;
		this.Lender = lender;
	}
	
	public Copy(Game game, Player lender) {
		this.DateAdded = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		this.G = game;
		this.Lender = lender;
	}
}
