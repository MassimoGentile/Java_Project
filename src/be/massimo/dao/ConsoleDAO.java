package be.massimo.dao;

import java.sql.Connection;

import be.massimo.pojo.Console;


public class ConsoleDAO extends DAO<Console>{
	
	public ConsoleDAO(Connection conn) {
		super(conn);
	}
	
	@Override
	public boolean create(Console obj) {
		return false;
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
