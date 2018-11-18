package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import be.massimo.pojo.Player;


public class PlayerDAO extends DAO<Player>{
	
	public PlayerDAO(Connection conn) {
		super(conn);
	}
	
	@Override
	public boolean create(Player obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO User (User_Name, User_Firstname, User_Birthday, User_Address, User_Email, User_Password, User_Admin, User_Amount, User_RegisterDate) VALUES (" + obj.getName() + "," + obj.getFirstname() + "," + obj.getBirthday() + "," + obj.getAddress() + "," + obj.getEmail() + "," + obj.getPassword() + "," + obj.getAdmin() + "," + obj.getAmount() + "," + obj.getRegisterDate() + ")");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Player obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM User WHERE User_Id=" + obj.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(Player obj) {
		return false;
	}
	
	@Override
	public Player find(int id) {
		return null;
	}
}
