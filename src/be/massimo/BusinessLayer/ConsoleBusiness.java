package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.ConsoleDAO;
import be.massimo.pojo.Console;

public class ConsoleBusiness {
	
	private Connection conn;
	
	public ConsoleBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public List<Console> getAll(){
		return new ConsoleDAO(conn).getAll();
	}
}
