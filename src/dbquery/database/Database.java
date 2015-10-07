package dbquery.database;



/**
 * @author Shirui
 * This class refers to a connection configuration of the mysql database. 
 */
public class Database {
	
	/**
	 * server name
	 */
	private String serverName;
	
	/**
	 * port 
	 */
	private int port;
	
	/**
	 * database name
	 */
	private String databaseName;
	
	/**
	 * user name
	 */
	private String username;
	
	/**
	 * password
	 */
	private String password;
	
	/**
	 * @return
	 */
	public String getServerName() {
		return serverName;
	}
	
	/**
	 * @param serverName
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	/**
	 * @return
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * @param databaseName
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
