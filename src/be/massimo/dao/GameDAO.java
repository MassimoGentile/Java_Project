package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Game (GName, GReleaseYear, GEditor, GUnit, Console_Id) VALUES (" + obj.getName() + "," + obj.getReleaseYear() + "," + obj.getEditor() + "," + obj.getUnit() + "," + obj.getConsole().getId() + ")");
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Game obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Game WHERE Game_Id=" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(Game obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Game SET GName =" + obj.getName() + ", GReleaseYear =" + obj.getReleaseYear() + ", GEditor =" + obj.getEditor() + ", GUnit =" + obj.getUnit() + ", Console_Id =" + obj.getConsole().getId() + " WHERE Game_Id =" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Game find(int id) {
		Game game = null;
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Game WHERE Game_Id =" + id);
			ConsoleDAO consoleDAO = new ConsoleDAO(this.Connect);
			if(result.first())
				game = new Game(id, result.getString("GName"), result.getInt("GReleaseYear"), result.getString("GEditor"), result.getInt("GUnit"), consoleDAO.find(result.getInt("Console_Id")));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return game;
	}
}
