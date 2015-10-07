package dbquery.eventlisteners;


import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import dbquery.database.DBConnector;
import dbquery.database.Person;

/**
 * @author Shirui
 * selection listener of the search button
 */
public class SearchClickListener implements SelectionListener {

	/**
	 * 
	 */
	private TableViewer viewer;
	
	/**
	 * 
	 */
	private Text searchText;
	
	/**
	 * Construtor
	 * @param viewer
	 * @param searchText
	 */
	public SearchClickListener(final TableViewer viewer, 
			final Text searchText) {
		this.viewer = viewer;
		this.searchText = searchText;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		try {
			if(searchText.getText().isEmpty()) {
				viewer.setInput(DBConnector.getInstance().findAllPersons());
			} else {
				Person person = DBConnector.getInstance().
						findPersonById(searchText.getText());
				if(person == null) {
					viewer.setInput(null);
					return;
				}
				ArrayList<Person> list = new ArrayList<Person>();
				list.add(person);
				viewer.setInput(list);
			}
		} catch (SQLException exc) {
			MessageDialog.openError(viewer.getControl().getShell(), "Exception", 
					exc.getLocalizedMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		
	}

}
