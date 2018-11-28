package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import be.massimo.dao.ConnectionAccess;
import be.massimo.dao.CopyDAO;
import be.massimo.pojo.Copy;

public class CopyBusiness {
	
	private Connection conn;
	
	public CopyBusiness() {
		conn = ConnectionAccess.getInstance();
	}
	
	public List<Copy> getOwnCopy(int id){
		return new CopyDAO(conn).getOwnCopy(id);
	}
}
