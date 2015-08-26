package view;

import java.awt.GridBagLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 * Defines the abstract hang man panel
 * @author jonassvalin
 *
 */
public abstract class HangmanPanel extends JPanel {
	protected JButton button;
	
	protected HangmanPanel(GridBagLayout gb) {
		super(gb);
	}
	
	/**
	 * Adds an actionlistener for the panel button
	 */
	protected void addButtonListener(ActionListener restartButtonListener) {
		button.addActionListener(restartButtonListener);
	}

}
