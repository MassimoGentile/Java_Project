package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import be.massimo.dao.BookingDAO;
import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.CopyDAO;
import be.massimo.dao.LoanDAO;
import be.massimo.dao.PlayerDAO;
import be.massimo.pojo.Booking;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Game;
import be.massimo.pojo.Loan;
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
					return listPlayer.get(i);
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
	
	public void UpdateUnit() {
		PlayerDAO playerDAO = new PlayerDAO(conn);
		List<Player> playerL = playerDAO.getAll();
		for(int i = 0; i < playerL.size(); i++) {
			CopyDAO copyDAO = new CopyDAO(conn);
			List<Copy> copyF = copyDAO.getOwnCopy(playerL.get(i).getId());
			List<Copy> copyL = new ArrayList<Copy>();
			for(int t = 0; t < copyF.size(); t++) {
				if(copyF.get(t).getAvailable() == false)
					copyL.add(copyF.get(t));
			}
			int amount = playerL.get(i).getAmount();
			for(int j = 0; j < copyL.size(); j++) 
				amount += copyL.get(j).getGame().getUnit();
			LoanDAO loanDAO = new LoanDAO(conn);
			List<Loan> loanL = loanDAO.getOwnLoan(playerL.get(i).getId());
			for(int x = 0; x < loanL.size(); x++)
				amount -= loanL.get(x).getCopy().getGame().getUnit();
			playerL.get(i).setAmount(amount);
			if(amount <= 0) {
				List<Integer> index = new ArrayList<Integer>();
				for(int y = 0; y < loanL.size(); y++)
					index.add(loanL.get(y).getId());
				for(int z = 0; z < index.size(); z++) {
					Loan l = loanDAO.find(loanL.get(z).getId());
					loanDAO.delete(l);
				}
			}
			playerDAO.update(playerL.get(i));
		}
	}
}
