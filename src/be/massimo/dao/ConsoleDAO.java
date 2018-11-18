package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;

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
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Console (Console_Name, Console_Version) VALUES (" + obj.getName() + "," + obj.getVersion() + ")");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Console obj) {
		return false;
	}
	
	@Override
	public boolean update(Console obj) {
		return false;
	}
	
	@Override
	public Console find(int id) {
		return null;
	}
}
