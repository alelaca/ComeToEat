package sqlutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
	
	private ConnectionManager manager;
	private Connection connection;
	
	public Query(){
		
		this.manager    = new ConnectionManager();
		this.connection = this.manager.connect();
	}
	
	
	public ConnectionManager getManager() {
		return manager;
	}


	public Connection getConnection() {
		return connection;
	}


	public int insert(String query){
		
		int result = 0;
		Statement stm = null;
		
		try {
			stm = this.connection.createStatement();
			stm.executeUpdate(query);
		} catch (SQLException e1) {
			result = e1.getErrorCode();
			System.out.println(e1.toString());
			this.manager.rollback(this.connection);	
		} finally {
			this.manager.commit(this.connection);
		}
		
		return result;
	}
	
	public ResultSet select(String query){
		
		ResultSet rs = null;
		Statement stm = null;
		
		try {
			stm = this.connection.createStatement();
			rs  = stm.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("ERR: Could not execute the query - " + e.toString());
		}
		
		return rs;
	}
	
}
