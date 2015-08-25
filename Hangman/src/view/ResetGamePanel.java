package view;

import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class ResetGamePanel extends JPanel {
	private JLabel headLine;
	private JLabel hangImage;
	private JTextField guessLetterField;
	private JButton restartButton;
	private GridBagConstraints cs;

	protected ResetGamePanel(int nbrOfIncorrectGuesses, String status) {
		super(new GridBagLayout());
		cs = new GridBagConstraints();
		
		headLine = new JLabel("You " + status + "!");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 3;
		this.add(headLine, cs);
		
		ImageIcon image = (new ImageIcon(((new ImageIcon("resources/hang" + nbrOfIncorrectGuesses + ".gif")).getImage()).getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		hangImage = new JLabel("", image, JLabel.CENTER);
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 3;
		this.add(hangImage, cs);
		
		restartButton = new JButton("Restart Game");
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 3;
		this.add(restartButton, cs);
	}
	
	
	protected void addRestartButtonListener(ActionListener restartButtonListener) {
		restartButton.addActionListener(restartButtonListener);
	}
	
}