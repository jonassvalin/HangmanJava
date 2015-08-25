package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import word.RandomWord;
import word.SpecifiedWord;
import word.Word;

public class HangmanModel {
	private final static int MAX_INCORRECT = 9;
	private List<String> usedLetters;
	private int nbrOfIncorrectGuesses;
	private String status;
	private Word word;
	
	public HangmanModel () {
		reset();
	}
	
	public void reset() {
		nbrOfIncorrectGuesses = 0;
		usedLetters = new ArrayList<String>();
		status = "ongoing";
	}
	
	public Word getWord() {
		return word;
	}
	
	public int getNbrOfIncorrectGuesses() {
		return nbrOfIncorrectGuesses;
	}
	
	public String getWordString() {
		return word.getWordString();
	}
	
	public void createWord(String specified, String difficulty) {
		if (specified.length() == 0) word = new RandomWord();
		else if (checkSpecifiedWord(specified)) word = new SpecifiedWord(specified);
		else word = null;
	}

	private boolean checkSpecifiedWord(String specified) {
		return specified.matches("[A-Z]+");
	}

	public void checkGuess(String guess) {
		if (!usedLetters.contains(guess)) usedLetters.add(guess);
		if (!word.getWord().contains(guess)) {
			nbrOfIncorrectGuesses++;
		} else {
			word.setFound(guess);
		}
	}
	
	public String checkStatus() {
		if (word.allCharactersFound()) {
			status = "win";
		} else if (nbrOfIncorrectGuesses > MAX_INCORRECT) {
			status = "lose";
		}
		return status;
	}
	
}
