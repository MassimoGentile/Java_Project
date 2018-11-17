package be.massimo.dao;

import java.sql.Connection;

import be.massimo.pojo.Game;

public class GameDAO extends DAO<Game>{
	
	public GameDAO(Connection conn) {
		super(conn);
	}
	
	@Override
	public boolean create(Game obj) {
		return false;
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
