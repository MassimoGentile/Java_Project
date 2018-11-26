package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Copy (CDateAdded, Game_Id, Lender_Id) VALUES ( '" + obj.getDateAdded() + "'," + obj.getGame().getId() + "," + obj.getLender().getId() + ")");
		}catch(SQLException e) {
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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Copy WHERE Copy_Id=" + obj.getId());
		}catch(SQLException e) {
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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Copy SET CDateAdded = '" + obj.getDateAdded() + "', Game_Id =" + obj.getGame().getId() + ", Lender_Id =" + obj.getLender().getId() + " WHERE Copy_Id =" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Copy find(int id) {
		Copy copy = null;
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Copy WHERE Copy_Id =" + id);
			GameDAO gameDAO = new GameDAO(this.Connect);
			PlayerDAO playerDAO = new PlayerDAO(this.Connect);
			if(result.first())
				copy = new Copy(id, result.getString("DateAdded"), gameDAO.find(result.getInt("Game_Id")), playerDAO.find(result.getInt("Lender_Id")));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return copy;
	}
	
	@Override
	public List<Copy> getAll(){
		List<Copy> copies = new ArrayList<Copy>();
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Copy");
			GameDAO gameDAO = new GameDAO(this.Connect);
			PlayerDAO playerDAO = new PlayerDAO(this.Connect);
			if(result.first())
				copies.add(new Copy(result.getInt("Copy_Id"), result.getString("DateAdded"), gameDAO.find(result.getInt("Game_Id")), playerDAO.find(result.getInt("Lender_Id"))));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return copies;
	}
}
