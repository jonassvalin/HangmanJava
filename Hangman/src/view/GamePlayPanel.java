package view;

import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class GamePlayPanel extends JPanel {
	private JLabel headLine;
	private JLabel hangImage;
	private JTextField guessLetterField;
	private JButton guessButton;
	private GridBagConstraints cs;

	protected GamePlayPanel(int amountOfGuesses, String wordString) {
		super(new GridBagLayout());
		cs = new GridBagConstraints();
		
		headLine = new JLabel("Time to guess some words!");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 3;
		this.add(headLine, cs);
		
		ImageIcon image = (new ImageIcon(((new ImageIcon("resources/hang" + amountOfGuesses + ".gif")).getImage()).getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		hangImage = new JLabel("", image, JLabel.CENTER);
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 3;
		this.add(hangImage, cs);

		guessLetterField = new JTextField(5);
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		this.add(guessLetterField, cs);
		
		guessButton = new JButton("Submit Guess");
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 1;
		this.add(guessButton, cs);
		
		headLine = new JLabel(wordString);
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 3;
		this.add(headLine, cs);
	}
	
	protected String getGuess() {
		return guessLetterField.getText().toUpperCase();
	}
	
	protected void addGuessButtonListener(ActionListener guessButtonListener) {
		guessButton.addActionListener(guessButtonListener);
	}
	
}