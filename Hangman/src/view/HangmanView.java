package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class HangmanView extends JFrame{
	private StartPagePanel startPagePanel;
	private GamePlayPanel gamePlayPanel;
	private ResetGamePanel restartGamePanel;
	
	public HangmanView() {
		super("Duke Hangem' 3D");
		startPagePanel = new StartPagePanel();
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(startPagePanel);
		setVisible(true);
	}
	
	public void reset() {
		startPagePanel = new StartPagePanel();
		this.getContentPane().removeAll();
		this.getContentPane().add(startPagePanel);
		this.validate();
		this.repaint();
	}
	
	public String getSpecifiedWord() {
		return startPagePanel.getSpecifiedWord();
	}
	
	public String getDifficulty() {
		return startPagePanel.getDifficulty();
	}
	
	public void setSpecifiedWordError() {
		startPagePanel.setSpecifiedWordError();
	}
	
	public void addStartButtonListener(ActionListener startButtonListener) {
		startPagePanel.addStartButtonListener(startButtonListener);
	}
	
	public void addGuessButtonListener(ActionListener guessButtonListener) {
		gamePlayPanel.addGuessButtonListener(guessButtonListener);
	}
	
	public void addResetButtonListener(ActionListener restartwButtonListener) {
		restartGamePanel.addRestartButtonListener(restartwButtonListener);
	}

	public void startNewGame(int nbrOfIncorrectGuesses, String wordString) {
		gamePlayPanel = new GamePlayPanel(nbrOfIncorrectGuesses, wordString);
		this.getContentPane().removeAll();
		this.getContentPane().add(gamePlayPanel);
		this.validate();
		this.repaint();
	}
	
	public void update(int nbrOfIncorrectGuesses, String wordString) {
		gamePlayPanel = new GamePlayPanel(nbrOfIncorrectGuesses, wordString);
		this.getContentPane().removeAll();
		this.getContentPane().add(gamePlayPanel);
		this.validate();
		this.repaint();
	}
	
	public void finishGame(int nbrOfIncorrectGuesses, String status) {
		restartGamePanel = new ResetGamePanel(nbrOfIncorrectGuesses, status);
		this.getContentPane().removeAll();
		this.getContentPane().add(restartGamePanel);
		this.validate();
		this.repaint();
	}

	public String getGuess() {
		return gamePlayPanel.getGuess();
	}
	
}
