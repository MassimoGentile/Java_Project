package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.GameDAO;
import be.massimo.pojo.Game;

public class GameBusiness {

	private Connection conn;
	
	public GameBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public List<Game> getAll(){
		return new GameDAO(conn).getAll();
	}
}
