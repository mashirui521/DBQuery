package dbquery;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;

import dbquery.dialogs.SettingDatabaseDialog;

public class DatabaseSettingHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		SettingDatabaseDialog dialog =  new SettingDatabaseDialog(
				HandlerUtil.getActiveWorkbenchWindow(event).getShell());
		dialog.create();
		
		if(dialog.open() == Window.OK) {
			
		}
		
		return null;
	}

}
