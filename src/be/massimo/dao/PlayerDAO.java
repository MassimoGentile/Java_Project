package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

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
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO User (UName, UFirstname, UBirthday, UAddress, UEmail, UPassword, UAdmin, UAmount, URegisterDate) VALUES (" + obj.getName() + "," + obj.getFirstname() + "," + obj.getBirthday() + "," + obj.getAddress() + "," + obj.getEmail() + "," + obj.getPassword() + "," + obj.getAdmin() + "," + obj.getAmount() + "," + obj.getRegisterDate() + ")");
		}catch(SQLException e) {
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
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(Player obj) {
		try {
			this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE User SET UName =" + obj.getName() + ", UFirstname =" + obj.getFirstname() + ", UBirthday =" + obj.getBirthday() + ", UAddress =" + obj.getAddress() + ", UEmail =" + obj.getEmail() + ", UPassword =" + obj.getPassword() + ", UAdmin =" + obj.getAdmin() + ", UAmount =" + obj.getAmount() + ", URegisterDate =" + obj.getRegisterDate() + " WHERE User_Id =" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Player find(int id) {
		Player player = null;
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Player WHERE Player_Id =" + id);
			if(result.first())
				player = new Player(id, result.getString("UName"), result.getString("UFirstname"), result.getDate("UBirthday"), result.getString("UAddress"), result.getString("UEmail"), result.getString("UPassword"), result.getBoolean("UAdmin"), result.getInt("UAmount"), result.getDate("URegisterDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
}
