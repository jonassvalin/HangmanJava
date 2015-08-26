package model;

import java.util.ArrayList;
import java.util.List;

import main.Constants;
import word.RandomWord;
import word.Word;

/**
 * The model contains all information regarding the state of the game, including the
 * current word, letters used and number of incorrect guesses.
 * @author jonassvalin
 *
 */
public class HangmanModel {
	private final static int MAX_INCORRECT = 9;
	private List<String> usedLetters;
	private int nbrOfIncorrectGuesses;
	private String status;
	private Word word;
	
	public HangmanModel () {
		newGame();
	}
	
	/**
	 * Defines the start of a new game
	 */
	public void newGame() {
		nbrOfIncorrectGuesses = 0;
		usedLetters = new ArrayList<String>();
		status = Constants.ONGOING;
	}
	
	/**
	 * Returns the current word
	 */
	public Word getWord() {
		return word;
	}
	
	/**
	 * Returns the current number of incorrect guesses
	 */
	public int getNbrOfIncorrectGuesses() {
		return nbrOfIncorrectGuesses;
	}
	
	/**
	 * Creates a new word object based on either the specified word input or a
	 * randomly generated word.
	 */
	public void createWord(String difficulty) {
		word = new RandomWord(difficulty);
	}
	
	/**
	 * Returns the word encrypted as a string with _ for hidden characters
	 */
	public String getHiddenWordString() {
		return word.getHiddenWordString();
	}
	
	/**
	 * Returns a string of all letters that have been guessed so far
	 */
	public String getUsedLetters() {
		StringBuilder usedLettersString = new StringBuilder();
		usedLettersString.append("Used letters: ");
		for (int i = 0; i < usedLetters.size(); i++) {
			usedLettersString.append(usedLetters.get(i) + " ");
		}
		return usedLettersString.toString();
	}

	/**
	 * First checks if the guess input is of correct format. If so checks whether the
	 * guess is correct or not.
	 */
	public boolean checkGuess(String guess) {
		if (!guess.matches("[A-Z]")) return false;
		if (!usedLetters.contains(guess)) usedLetters.add(guess);
		if (!word.toString().contains(guess)) {
			nbrOfIncorrectGuesses++;
		} else {
			word.setFound(guess);
		}
		return true;
	}
	
	/**
	 * Checks if the user has won, lost or is still playing.
	 */
	public String checkStatus() {
		if (word.allCharactersFound()) {
			status = Constants.WIN;
		} else if (nbrOfIncorrectGuesses > MAX_INCORRECT) {
			status = Constants.LOSE;
		}
		return status;
	}
}
