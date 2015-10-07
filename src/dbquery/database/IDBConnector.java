package dbquery.database;

import java.sql.SQLException;
import java.util.Collection;

/**
 * @author Shirui
 * The interface contains functions using DAO pattern
 */
public interface IDBConnector {
	
	/**
	 * @return a list of persons
	 * @throws SQLException
	 */
	public Collection<Person> findAllPersons() throws SQLException;
	
	/**
	 * @param id
	 * @return the person with the required id
	 * @throws SQLException
	 */
	public Person findPersonById(String id) throws SQLException;
	
	/**
	 * create a person
	 * @param person
	 */
	public void create(Person person);
	
	/**
	 * delete a person
	 * @param person
	 */
	public void delete(Person person);
	
	/**
	 * update a person information
	 * @param person
	 */
	public void update(Person person);
}
