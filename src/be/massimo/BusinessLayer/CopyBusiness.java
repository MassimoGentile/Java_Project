package be.massimo.BusinessLayer;

import java.sql.Connection;

import be.massimo.dao.ConnectionAccess;

public class CopyBusiness {
	
	private Connection conn;
	
	public CopyBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
}
