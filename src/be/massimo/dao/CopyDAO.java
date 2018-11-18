package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import be.massimo.pojo.Copy;


public class CopyDAO extends DAO<Copy>{

	public CopyDAO(Connection conn) {
		super(conn);
	}
	
	@Override
	public boolean create(Copy obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Copy (Copy_DateAdded, Game_Id) VALUES (" + obj.getDateAdded() + "," + obj.getGame().getId() + ")");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Copy obj) {
		return false;
	}
	
	@Override
	public boolean update(Copy obj) {
		return false;
	}
	
	@Override
	public Copy find(int id) {
		return null;
	}
}
