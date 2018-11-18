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
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Game WHERE Game_Id=" + obj.getId());
		}catch(Exception e) {
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
					ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Game SET Game_Name =" + obj.getName() + ", Game_Developers =" + obj.getDevelopers() + ", Game_Editor =" + obj.getEditor() + ", Game_Unit =" + obj.getUnit() + ", Console_Id =" + obj.getConsole().getId() + " WHERE Game_Id =" + obj.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Game find(int id) {
		return null;
	}
}
