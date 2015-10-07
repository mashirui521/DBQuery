package dbquery;


import org.eclipse.jface.viewers.ColumnLabelProvider;

import dbquery.database.Person;

public class TableColumnLabelProvider extends ColumnLabelProvider {
	
	/**
	 * 
	 */
	private String title;
	
	/**
	 * @param title
	 */
	public TableColumnLabelProvider(final String title) {
		this.title = title;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {

		Person person = (Person) element;
		String text;
		
		switch (title) {
		case "ID":
			text = person.getId();
			break;
		case "Last Name":
			text = person.getLastName();
			break;
		case "First Name":
			text = person.getFirstName();
			break;
		case "Gender":
			text = person.getGender();
			break;
		case "Date of Birth":
			text = person.getDateOfBirth();
			break;
		default:
			text = null;
			break;
		}
		
		return text;
	}
	
}
