package sqlutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.*;

/***
 * Manage all the interaction with the database
 * @author blorenzo
 *
 */
public class ConnectionManager {

	public ConnectionManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/***
	 * Create a new connection to the database
	 * @return Connection
	 */
	public Connection connect(){
		
		// Intitialize var
		ContextPath context = new ContextPath();
		String pathProperiesFile = context.getPath("resources/config.properties"); 
		String driver, host, port, database, user, pass, key;
		Connection connection;
		
		// Read the properties file
		FileManager fm = new FileManager();
		driver   = fm.readFile(pathProperiesFile, "driver");
		host     = fm.readFile(pathProperiesFile, "host");
		port     = fm.readFile(pathProperiesFile, "port");
		database = fm.readFile(pathProperiesFile, "database");
		user     = fm.readFile(pathProperiesFile, "user");
		pass     = fm.readFile(pathProperiesFile, "pass");
		
		// Get the KEY for encrypt and decrypt
		key = fm.readFile(context.getPath("resources/appkey.properties"), "KEY");
		AES aes = new AES(key);
		
		// Do the connection with mysql
		try {
			String connectionString = String.format("jdbc:mysql://%1s:%2s/%3s?relaxAutoCommit=true",host,port,aes.decrypt(database));
			Class.forName(driver);
			connection = DriverManager.getConnection(connectionString,aes.decrypt(user),aes.decrypt(pass));
			System.out.println("INF: Data base connected!");
			return connection;
		} catch (SQLException | ClassNotFoundException e){
			// Reg log
			//logger.error("ERR: Could not connect to database - " + e);
			System.out.println("ERR: Could not connect to database - " + e.toString());
		}
		return null;
		
	}

	/***
	 * Disconnect current session from database
	 * @param con Connection
	 */
	public void disconnect(Connection con){
		
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("ERR: Could not close the connection - " + e.toString());
		}
	}

	/***
	 * Commit all changes until now
	 * @param con Connection
	 * @return error code
	 */
	public int commit(Connection con){
		int result = 0;
		
		try {
			con.commit();
		} catch (SQLException e) {
			System.out.println("ERR: Could not commit changes - " + e.toString());
			result = e.getErrorCode();
		} 
		
		return result;
	}

	/***
	 * Rollback all changes
	 * @param con Connection
	 * @return error code
	 */
	public int rollback(Connection con){
		int result = 0;
		
		try{
			con.rollback();
		} catch (SQLException e){
			System.out.println("ERR: Could not rollback changes - " + e.toString());
			result = e.getErrorCode();
		}
		
		return result;
	}
}