package be.massimo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionAccess {
	
	private static Connection instance = null;
	
	private ConnectionAccess() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://./DB_Projet.accdb";
			instance = DriverManager.getConnection(url);
		}catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Impossible de trouver le driver pour la base de données !");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Impossible de se connecter à la base de données.");
		}
		
		if(instance == null) {
			JOptionPane.showMessageDialog(null, "La base de données est innaccessible, fermeture de la base de données");
			System.exit(0);
		}
	}
	
	public static Connection getInstance() {
		if(instance == null)
			new ConnectionAccess();
		return instance;
	}
}
