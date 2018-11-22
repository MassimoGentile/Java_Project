package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.massimo.pojo.Console;


public class ConsoleDAO extends DAO<Console>{
	
	public ConsoleDAO(Connection conn) {
		super(conn);
	}
	
	@Override
	public boolean create(Console obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Console (CName, CVersion) VALUES ( '" + obj.getName() + "', '" + obj.getVersion() + "')");
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Console obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Console WHERE Console_Id=" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(Console obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Console SET CName = '" + obj.getName() + "', CVersion = '" + obj.getVersion() + "' WHERE Console_Id =" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Console find(int id) {
		Console console = null;
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Console WHERE Console_Id = " + id);
			if(result.first())
				console = new Console(id, result.getString("CName"), result.getString("CVersion"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return console;
	}
}
