package biblio.dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {

	public ConnectionFactory() {}
	
	public Connection getConnection(String chemin) {
		Properties configProperties  = new Properties();
		try {
			configProperties.load(new FileInputStream(chemin));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String nomPilote = configProperties.getProperty("jdbc.driver.class");
		String URLBD = configProperties.getProperty("jdbc.url");
		String authorizationID = configProperties.getProperty("jdbc.login");
		String password = configProperties.getProperty("jdbc.password");
		Connection con = null;
		try {
			Class.forName(nomPilote);
		} catch (ClassNotFoundException e) {
			System.err.println("classe introuvable");
		}
		try {
			con = DriverManager.getConnection(URLBD, authorizationID, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public Connection getConnectionSansAutoCommit(String chemin) {
		Properties configProperties  = new Properties();
		try {
			configProperties.load(new FileInputStream(chemin));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String nomPilote = configProperties.getProperty("jdbc.driver.class");
		String URLBD = configProperties.getProperty("jdbc.url");
		String authorizationID = configProperties.getProperty("jdbc.login");
		String password = configProperties.getProperty("jdbc.password");
		Connection con = null;
		try {
			Class.forName(nomPilote);
		} catch (ClassNotFoundException e) {
			System.err.println("classe introuvable");
		}
		try {
			con = DriverManager.getConnection(URLBD, authorizationID, password);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}