package view;

import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

/**
 * Defines the reset game panel
 * @author jonassvalin
 *
 */
public class ResetGamePanel extends HangmanPanel {
	private JLabel headLine;
	private JLabel hangImage;
	private JLabel wordLine;
	private GridBagConstraints cs;

	protected ResetGamePanel(int nbrOfIncorrectGuesses, String status, String wordString, String word) {
		super(new GridBagLayout());
		cs = new GridBagConstraints();
		
		headLine = new JLabel("You " + status + "! The correct answer is: " + word);
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 3;
		this.add(headLine, cs);
		
		ImageIcon image = (new ImageIcon(((new ImageIcon("resources/hang" + nbrOfIncorrectGuesses + ".gif")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		hangImage = new JLabel("", image, JLabel.CENTER);
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 3;
		this.add(hangImage, cs);
		
		wordLine = new JLabel(wordString);
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 3;
		this.add(wordLine, cs);
		
		button = new JButton("Restart Game");
		cs.gridx = 1;
		cs.gridy = 4;
		cs.gridwidth = 3;
		this.add(button, cs);
	}
	
	/**
	 * Adds an actionlistener for the start button
	 */
	protected void addRestartButtonListener(ActionListener restartButtonListener) {
		button.addActionListener(restartButtonListener);
	}
	
}