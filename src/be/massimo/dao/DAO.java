package be.massimo.dao;

import java.sql.Connection;

public abstract class DAO<T> {
	
	protected Connection Connect = ConnectionAccess.getInstance();
	
	public DAO(Connection conn) {
		this.Connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(int id);
}
