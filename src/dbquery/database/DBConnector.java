package dbquery.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * @author Shirui
 * a singleton database connector
 */
public class DBConnector implements IDBConnector{
	
	/**
	 * The instance of the class
	 */
	private static DBConnector _dbConnector;
	
	/**
	 * The database to connect 
	 */
	private Database db;
	
	/**
	 * A connection to mysql
	 */
	private MysqlDataSource _dataSource;
	
	/**
	 * The list storing the returned informations
	 */
	private static Collection<Person> _personList;
	
	/**
	 * Constructor
	 */
	private DBConnector() {
		
	}
	
	/**
	 * @return The connector instance
	 */
	public static DBConnector getInstance() {
		if(_dbConnector == null) {
			_dbConnector = new DBConnector();
		}
		
		return _dbConnector;
	}
	
	/**
	 * setup a database to the connector
	 * @param db
	 */
	public void setupDB(Database db) {
		this.db = db;
	}
	
	/**
	 * get the result list
	 * @return
	 */
	public Collection<Person> getList() {
		return _personList;
	}
	
	/**
	 * get database
	 * @return
	 */
	public Database getDatabase() {
		return db;
	}
	
	/**
	 * connect to the database
	 * @return
	 * @throws Exception
	 */
	public Connection connect() throws Exception{
		if(db == null) {
			new Exception("No database");
		}
		
		if(_dataSource == null) {
			_dataSource = new MysqlDataSource();
		}
		
		_dataSource.setServerName(db.getServerName());
		_dataSource.setPort(db.getPort());
		_dataSource.setDatabaseName(db.getDatabaseName());
		_dataSource.setUser(db.getUsername());
		_dataSource.setPassword(db.getPassword());
		
		return _dataSource.getConnection();
	}

	/* (non-Javadoc)
	 * @see dbquery.database.IDBConnector#findAllPersons()
	 */
	@Override
	public Collection<Person> findAllPersons() throws SQLException {
		if(db == null) {
			return null;
		}
		return executeQuery("SELECT * FROM Persons");
	}

	/* (non-Javadoc)
	 * @see dbquery.database.IDBConnector#findPersonById(java.lang.String)
	 */
	@Override
	public Person findPersonById(final String id) throws SQLException {
		if(db == null) {
			return null;
		}
		
		String sql = "SELECT * FROM Persons WHERE ID='" + id + "'";
		ArrayList<Person> list = ((ArrayList<Person>) executeQuery(sql));
		if(list.size() == 0) {
			return null;
		}
		
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see dbquery.database.IDBConnector#create(dbquery.database.Person)
	 */
	@Override
	public void create(Person person) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dbquery.database.IDBConnector#delete(dbquery.database.Person)
	 */
	@Override
	public void delete(Person person) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dbquery.database.IDBConnector#update(dbquery.database.Person)
	 */
	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * create a statement in the connection
	 * @return statement
	 * @throws SQLException
	 */
	private Statement getStatement() throws SQLException {
		return _dataSource.getConnection().createStatement();
	}
	
	/**
	 * execute a sql instruction
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private boolean executeSql(String sql) throws SQLException {
		return getStatement().execute(sql);
	}
	
	/**
	 * execute a database query
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private Collection<Person> executeQuery(String sql) throws SQLException {
		_personList = new ArrayList<Person>();
		ResultSet rset = getStatement().executeQuery(sql);
		while(rset.next()) {
			Person person = new Person();
			person.setId(rset.getString("ID"));
			person.setFirstName(rset.getString("FIRSTNAME"));
			person.setLastName(rset.getString("LASTNAME"));
			person.setGender(rset.getString("GENDER"));
			person.setDateOfBirth(rset.getString("DATE_OF_BIRTH"));
			_personList.add(person);
		}
		
		return _personList;
	}
}
