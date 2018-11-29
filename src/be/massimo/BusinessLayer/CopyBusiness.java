package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.ConsoleDAO;
import be.massimo.dao.CopyDAO;
import be.massimo.dao.GameDAO;
import be.massimo.pojo.Console;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Game;
import be.massimo.pojo.Player;

public class CopyBusiness {
	
	private Connection conn;
	
	public CopyBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public List<Copy> getCopies(){
		return new CopyDAO(conn).getAll();
	}
	
	public List<Copy> getOwnCopy(int id){
		return new CopyDAO(conn).getOwnCopy(id);
	}
	
	public List<Copy> findAll(int id) {
		return new CopyDAO(conn).findAll(id);
	}
	
	public Game findGame(int id) {
		return new GameDAO(conn).find(id);
	}
	
	public Console findConsole(int id) {
		return new ConsoleDAO(conn).find(id);
	}
}
