package dbquery.dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import dbquery.database.DBConnector;
import dbquery.database.Database;

public class SettingDatabaseDialog extends TitleAreaDialog{

	private Text textServerName;
	private Text textPort;
	private Text textDatabaseName;
	private Text textUsername;
	private Text textPassword;
	
	/**
	 * database
	 */
	private Database db;
	
	/**
	 * @param parentShell
	 */
	public SettingDatabaseDialog(Shell parentShell) {
		super(parentShell);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#create()
	 */
	@Override
	public void create() {
		super.create();
		setTitle("Setting Database");
		setMessage("please enter the informations about the database", 
				IMessageProvider.INFORMATION);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		GridLayout layout = new GridLayout(2, false);
	    container.setLayout(layout);
	    
	    GridData gridData = new GridData();
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    
	    
	    Label labelServerName = new Label(container, SWT.NONE);
	    labelServerName.setText("Server Name: ");
	    
	    textServerName = new Text(container, SWT.BORDER);
	    textServerName.setLayoutData(gridData);
	    
	    Label labelPort = new Label(container, SWT.NONE);
	    labelPort.setText("Port: ");
	    
	    textPort = new Text(container, SWT.BORDER);
	    textPort.setLayoutData(gridData);
	    
	    Label labelDatabaseName = new Label(container, SWT.NONE);
	    labelDatabaseName.setText("Database Name: ");
	    
	    textDatabaseName = new Text(container, SWT.BORDER);
	    textDatabaseName.setLayoutData(gridData);
	    
	    Label labelUsername = new Label(container, SWT.NONE);
	    labelUsername.setText("Username: ");
	    
	    textUsername = new Text(container, SWT.BORDER);
	    textUsername.setLayoutData(gridData);
	    
	    Label labelPassword = new Label(container, SWT.NONE);
	    labelPassword.setText("Password: ");
	    
	    textPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
	    textPassword.setLayoutData(gridData);
	    
	    if((db = DBConnector.getInstance().getDatabase()) == null) {
	    	db = new Database();
	    	DBConnector.getInstance().setupDB(db);
	    }
	    
	    textServerName.setText(db.getServerName() != null ? 
	    		db.getServerName() : "");
	    textPort.setText(Integer.toString(db.getPort()));
	    textDatabaseName.setText(db.getDatabaseName() != null ?
	    		db.getDatabaseName() : "");
	    textUsername.setText(db.getUsername() != null ?
	    		db.getUsername() : "");
	    textPassword.setText(db.getPassword() != null ?
	    		db.getPassword() : "");
	    
		return area;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#isResizable()
	 */
	@Override
	protected boolean isResizable() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		
		db.setServerName(textServerName.getText());
		db.setPort(Integer.parseInt(textPort.getText()));
		db.setDatabaseName(textDatabaseName.getText());
		db.setUsername(textUsername.getText());
		db.setPassword(textPassword.getText());
		
		try {
			DBConnector.getInstance().connect();
			MessageDialog.openInformation(getShell(), "Info", 
					"Setting database successfully");
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Setting failed", 
					"Cannot connect the database. "+ e.getLocalizedMessage());
			return;
		}
		
		super.okPressed();
	}
}
