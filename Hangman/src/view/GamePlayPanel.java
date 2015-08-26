package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;

import javax.swing.*;

import main.Main;

/**
 * Defines the game play panel
 * @author jonassvalin
 *
 */
public class GamePlayPanel extends HangmanPanel {
	private JLabel headLine;
	private JLabel hangImage;
	private JLabel wordLine;
	private JLabel usedLetters;
	private JTextField guessLetterField;
	private GridBagConstraints cs;

	protected GamePlayPanel(int nbrOfIncorrectGuesses, String wordString, String usedLettersString) {
		super(new GridBagLayout());
		cs = new GridBagConstraints();
		
		headLine = new JLabel("Time to guess some words!");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 3;
		this.add(headLine, cs);
		
		URL url = Main.class.getResource("/hang" + nbrOfIncorrectGuesses + ".gif");
		ImageIcon image = (new ImageIcon(((new ImageIcon(url)).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
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
		
		button = new JButton("Submit Guess");
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 1;
		this.add(button, cs);
		
		wordLine = new JLabel(wordString);
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 3;
		this.add(wordLine, cs);
		
		usedLetters = new JLabel(usedLettersString);
		cs.gridx = 0;
		cs.gridy = 4;
		cs.gridwidth = 3;
		this.add(usedLetters, cs);
	}
	
	/**
	 * Returns the guess input by the player
	 */
	protected String getGuess() {
		return guessLetterField.getText().toUpperCase();
	}

	/**
	 * Clears the guess field
	 */
	protected void clearGuessField() {
		guessLetterField.setText("");
	}
	
}