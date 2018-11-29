package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import be.massimo.dao.BookingDAO;
import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.CopyDAO;
import be.massimo.dao.PlayerDAO;
import be.massimo.pojo.Booking;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Game;
import be.massimo.pojo.Player;

public class PlayerBusiness {
	
	private Connection conn;
	
	public PlayerBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public Player Login(String email, String password) {
		if(email != null && password != null) {
			List<Player> listPlayer = new PlayerDAO(conn).getAll();
			for(int i = 0; i < listPlayer.size(); i++) {
				if(listPlayer.get(i).getEmail().equals(email) && listPlayer.get(i).getPassword().equals(password))
					return new PlayerDAO(conn).find(listPlayer.get(i).getId());
			}
		}
		return null;
	}
	
	public boolean Registration(String name, String firstname, String birthday, String address, String email, String password) {
		if(name != null && firstname != null && birthday != null && address != null && email != null && password != null) {
			Player player = new Player(name, firstname, birthday, address, email, password);
			if(new PlayerDAO(conn).create(player))
				return true;
			else
				return false;
		}else
			return false;
	}
	
	public Player Modification(int id, String name, String firstname, String birthday, String address, String email, String password) {
		if(id != 0 && name != null && firstname != null && birthday != null && address != null && email != null && password != null) {
			PlayerDAO playerDAO = new PlayerDAO(conn);
			Player player = playerDAO.find(id);
			player.setName(name);
			player.setFirstname(firstname);
			player.setBirthday(birthday);
			player.setAddress(address);
			player.setEmail(email);
			player.setPassword(password);
			playerDAO.update(player);
			return player;
		}else
			return null;
	}
	
	public boolean Remove(Player player) {
		if(player != null) {
			PlayerDAO playerDAO = new PlayerDAO(conn);
			playerDAO.delete(player);
			return true;
		}else
			return false;
	}
	
	public Player AddBooking(Player player, String beginDateWanted, Game game) {
		if(player != null && beginDateWanted != null && game != null) {
			Booking booking = new Booking(beginDateWanted, game, player);
			BookingDAO bookingDAO = new BookingDAO(conn);
			bookingDAO.create(booking);
			PlayerDAO playerDAO = new PlayerDAO(conn);
			return playerDAO.find(player.getId());
		}else
			return null;
	}
	
	public Player RemoveBooking(Player player, int id) {
		if(player != null && id > 0) {
			BookingDAO bookingDAO = new BookingDAO(conn);
			Booking booking = bookingDAO.find(id);
			bookingDAO.delete(booking);
			PlayerDAO playerDAO = new PlayerDAO(conn);
			return playerDAO.find(player.getId());
		}else
			return null;
	}
	
	public Player AddCopy(Game game, Player player) {
		if(game != null && player != null) {
			Copy copy = new Copy(game,player);
			CopyDAO copyDAO = new CopyDAO(conn);
			copyDAO.create(copy);
			PlayerDAO playerDAO = new PlayerDAO(conn);
			return playerDAO.find(player.getId());
		}else
			return null;
	}
	
	public Player RemoveCopy(Player player, int id) {
		if(player != null && id > 0) {
			CopyDAO copyDAO = new CopyDAO(conn);
			Copy copy = copyDAO.find(id);
			copyDAO.delete(copy);
			PlayerDAO playerDAO = new PlayerDAO(conn);
			return playerDAO.find(player.getId());
		}else
			return null;
	}
}
