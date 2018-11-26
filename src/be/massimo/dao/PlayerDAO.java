package be.massimo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO User (UName, UFirstname, UBirthday, UAddress, UEmail, UPassword, UAdmin, UAmount, URegisterDate) VALUES ( '" + obj.getName() + "', '" + obj.getFirstname() + "', '" + obj.getBirthday() + "', '" + obj.getAddress() + "', '" + obj.getEmail() + "', '" + obj.getPassword() + "', '" + obj.getAdmin() + "', " + obj.getAmount() + ", '" + obj.getRegisterDate() + "')");
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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM User WHERE User_Id=" + obj.getId());
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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE User SET UName = '" + obj.getName() + "', UFirstname = '" + obj.getFirstname() + "', UBirthday = '" + obj.getBirthday() + "', UAddress = '" + obj.getAddress() + "', UEmail = '" + obj.getEmail() + "', UPassword = '" + obj.getPassword() + "', UAdmin = '" + obj.getAdmin() + "', UAmount =" + obj.getAmount() + ", URegisterDate = '" + obj.getRegisterDate() + "' WHERE User_Id =" + obj.getId());
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Player find(int id) {
		Player player = null;
		
		//PLAYER SELECTION
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM User WHERE User_Id =" + id);
			if(result.first())
				player = new Player(id, result.getString("UName"), result.getString("UFirstname"), result.getString("UBirthday"), result.getString("UAddress"), result.getString("UEmail"), result.getString("UPassword"), result.getBoolean("UAdmin"), result.getInt("UAmount"), result.getString("URegisterDate"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//SELECTION OF ALL BOOKING OF THE PLAYER
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Booking WHERE Borrower_Id =" + id);
			BookingDAO bookingDAO = new BookingDAO(this.Connect);
			while(result.next())
				player.addBooking(bookingDAO.find(result.getInt("Booking_Id")));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//SELECTION OF ALL COPY OF THE PLAYER
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Copy WHERE Lender_Id =" + id);
			CopyDAO copyDAO = new CopyDAO(this.Connect);
			while(result.next())
				player.addCopy(copyDAO.find(result.getInt("Copy_Id")));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
	
	@Override
	public List<Player> getAll(){
		List<Player> players = new ArrayList<Player>();
		try {
			ResultSet result = this.Connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM User");
			if(result.first())
				players.add(new Player(result.getInt("User_Id"), result.getString("UName"), result.getString("UFirstname"), result.getString("UBirthday"), result.getString("UAddress"), result.getString("UEmail"), result.getString("UPassword"), result.getBoolean("UAdmin"), result.getInt("UAmount"), result.getString("URegisterDate")));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return players;
	}
}
