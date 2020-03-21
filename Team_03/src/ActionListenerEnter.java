import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListenerEnter.java - A class invoked when an action occurs.
 *
 *@author Ashutosh Dey
 *@version 1.0
 *@param e the event to be processed 
 *
 * Cannot avoid this class because it is default override 
 * for the Action Listenter and needs to be in a separate class
 */
public class ActionListenerEnter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MouseListener.selectedShape.setMessage(InputDialog.dialogText.getText());
	}
}
