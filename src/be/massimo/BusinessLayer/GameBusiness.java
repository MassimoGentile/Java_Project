package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.GameDAO;
import be.massimo.pojo.Console;
import be.massimo.pojo.Game;

public class GameBusiness {

	private Connection conn;
	
	public GameBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public List<Game> getAll(){
		return new GameDAO(conn).getAll();
	}
	
	public void Modification(int id, String name, int releaseYear, String editor, int unit, Console console) {
		if(id > 0 && name != null && releaseYear != 0 && editor != null && unit != 0 && console != null) {
			GameDAO gameDAO = new GameDAO(conn);
			gameDAO.update(new Game(id, name, releaseYear, editor, unit, console));
			JOptionPane.showMessageDialog(null, "Game Updated !", "Success", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
}
