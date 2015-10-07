package dbquery.database;

/**
 * @author Shirui
 * This class refers a person model.
 */
public final class Person {
	
	/**
	 * Identity
	 */
	private String id;
	
	/**
	 * First name
	 */
	private String firstName;
	
	/**
	 * Last name
	 */
	private String lastName;
	
	/**
	 * Gender
	 */
	private String gender;
	
	/**
	 * Date of Birth
	 */
	private String dateOfBirth;
	
	/**
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
