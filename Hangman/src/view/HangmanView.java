package view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The view displays all GUI components for the user. The specific screens are defined in the
 * various panels.
 * @author jonassvalin
 *
 */
public class HangmanView extends JFrame{
	private StartPagePanel startPagePanel;
	private GamePlayPanel gamePlayPanel;
	private ResetGamePanel restartGamePanel;
	
	public HangmanView() {
		super("Duke Hangem' 3D");
		startPagePanel = new StartPagePanel();
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(startPagePanel);
		setVisible(true);
	}
	
	/**
	 * Displays the start new game menu
	 */
	public void newGame() {
		startPagePanel = new StartPagePanel();
		redrawPanel(startPagePanel);
	}
	
	/**
	 * Performs an update of the game play panel based on the results of the last guess
	 */
	public void update(int nbrOfIncorrectGuesses, String wordString, String usedLetters) {
		gamePlayPanel = new GamePlayPanel(nbrOfIncorrectGuesses, wordString, usedLetters);
		redrawPanel(gamePlayPanel);
	}
	
	/**
	 * Displays the reset game panel after the user has finished the game
	 */
	public void finishGame(int nbrOfIncorrectGuesses, String status, String wordString, String word) {
		restartGamePanel = new ResetGamePanel(nbrOfIncorrectGuesses, status, wordString, word);
		redrawPanel(restartGamePanel);
	}
	
	/**
	 * Replaces the previous panel with the new
	 */
	private void redrawPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.validate();
		this.repaint();
	}
	
	/**
	 * Returns the difficulty setting chosen by the player
	 */
	public String getDifficulty() {
		return startPagePanel.getDifficulty();
	}
	
	/**
	 * Returns the guess input by the player
	 */
	public String getGuess() {
		return gamePlayPanel.getGuess();
	}
	
	/**
	 * Displays the wrong input error message
	 */
	public void setGuessError() {
		JOptionPane.showMessageDialog(this, "Please use only single alphabetical letters");
		gamePlayPanel.clearGuessField();
	}
	
	/**
	 * Adds an actionlistener for the start button
	 */
	public void addStartButtonListener(ActionListener startButtonListener) {
		startPagePanel.addButtonListener(startButtonListener);
	}
	
	/**
	 * Adds an actionlistener for the guess button
	 */
	public void addGuessButtonListener(ActionListener guessButtonListener) {
		gamePlayPanel.addButtonListener(guessButtonListener);
	}
	
	/**
	 * Adds an actionlistener for the restart button
	 */
	public void addResetButtonListener(ActionListener restartwButtonListener) {
		restartGamePanel.addRestartButtonListener(restartwButtonListener);
	}
	
}
