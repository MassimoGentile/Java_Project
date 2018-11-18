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
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Copy (Copy_DateAdded, Game_Id, Lender_Id) VALUES (" + obj.getDateAdded() + "," + obj.getGame().getId() + "," + obj.getLender().getId() + ")");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Copy obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Copy WHERE Copy_Id=" + obj.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(Copy obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Copy SET Copy_DateAdded =" + obj.getDateAdded() + ", Game_Id =" + obj.getGame().getId() + ", Lender_Id =" + obj.getLender().getId() + " WHERE Copy_Id =" + obj.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Copy find(int id) {
		return null;
	}
}
