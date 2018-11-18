package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import be.massimo.pojo.Game;

public class GameDAO extends DAO<Game>{
	
	public GameDAO(Connection conn) {
		super(conn);
	}
	
	@Override
	public boolean create(Game obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Game (Game_Name, Game_Developers, Game_Editor, Game_Unit, Console_Id) VALUES (" + obj.getName() + "," + obj.getDevelopers() + "," + obj.getEditor() + "," + obj.getUnit() + "," + obj.getConsole().getId() + ")");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Game obj) {
		return false;
	}
	
	@Override
	public boolean update(Game obj) {
		return false;
	}
	
	@Override
	public Game find(int id) {
		return null;
	}
}
