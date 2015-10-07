package dbquery;


import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import dbquery.database.DBConnector;
import dbquery.eventlisteners.SearchClickListener;

public class DatabaseView extends ViewPart {

	/**
	 * 
	 */
	public static final String ID = "DBQuery.DatabaseView";
	
	/**
	 * 
	 */
	private Text searchText;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);

		searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
		searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
		        | GridData.HORIZONTAL_ALIGN_FILL));
		final Button searchButton = new Button(parent, SWT.NONE);
		searchButton.setText("search");
		
		TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	    
		createColums(parent, viewer);
		
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(DBConnector.getInstance().getList());
		
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		searchButton.addSelectionListener(new SearchClickListener(viewer, searchText));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		searchText.setFocus();
	}
	
	/**
	 * @param parent
	 * @param viewer
	 */
	private void createColums(final Composite parent, final TableViewer viewer) {
		String[] titles = {"ID", "First Name", "Last Name", "Gender", "Date of Birth"};
		
		for(int i = 0; i < titles.length; i++) {
			final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
					SWT.NONE);
			final TableColumn column = viewerColumn.getColumn();
			column.setText(titles[i]);
			column.setWidth(100);
			column.setResizable(true);
			column.setMoveable(true);
			
			viewerColumn.setLabelProvider(new TableColumnLabelProvider(titles[i]));
		}
		
	}

}
