package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.PlayerDAO;
import be.massimo.pojo.Player;

public class PlayerBusiness {
	
	private Connection conn;
	
	public PlayerBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public Player Login(String email, String password) {
		if(email != null && password != null) {
			List<Player> listPlayer = new PlayerDAO(conn).findAll();
			for(int i = 0; i < listPlayer.size(); i++) {
				if(listPlayer.get(i).getEmail().equals(email) && listPlayer.get(i).getPassword().equals(password))
					return listPlayer.get(i);
			}
		}
		return null;
	}
	
	public boolean Registration(String name, String firstname, Date birthday, String address, String email, String password) {
		if(name != null && firstname != null && birthday != null && address != null && email != null && password != null) {
			Player player = new Player(name, firstname, birthday, address, email, password);
			if(new PlayerDAO(conn).create(player))
				return true;
			else
				return false;
		}else
			return false;
	}
	
	public boolean Modification(String name, String firstname, Date birthday, String address, String email, String password) {
		if(name != null && firstname != null && birthday != null && address != null && email != null && password != null) {
			Player player = new Player(name, firstname, birthday, address, email, password);
			if(new PlayerDAO(conn).update(player))
				return true;
			else
				return false;
		}else
			return false;
	}
	
	public boolean Remove(String name, String firstname, Date birthday, String address, String email, String password) {
		if(name != null && firstname != null && birthday != null && address != null && email != null && password != null) {
			Player player = new Player(name, firstname, birthday, address, email, password);
			if(new PlayerDAO(conn).delete(player))
				return true;
			else
				return false;
		}else
			return false;
	}
}
