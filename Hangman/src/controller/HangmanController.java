package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.HangmanView;
import main.Constants;
import model.HangmanModel;

/**
 * The controller handles the interaction between the model and the view.
 * @author jonassvalin
 *
 */
public class HangmanController {
	private HangmanModel hmModel;
	private HangmanView hmView;
	
	public HangmanController(HangmanModel hmModel, HangmanView hmView) {
		this.hmModel = hmModel;
		this.hmView = hmView;
		this.hmView.addStartButtonListener(new StartButtonListener());
	}
	
	/**
	 * Listens for the initiation of a new game by the user. If no specified word is set
	 * a random word is chosen, if the input of the specified word is incorrect an error
	 * is displayed
	 */
	class StartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			hmModel.createWord(hmView.getDifficulty());
				hmView.update(hmModel.getNbrOfIncorrectGuesses(), hmModel.getHiddenWordString(), hmModel.getUsedLetters());
				hmView.addGuessButtonListener(new GuessButtonListener());
		}
	}
	
	/**
	 * Listens for a new guess submission by the user. First checks if the format of the guess is correct then
	 * whether or not the guess affects the outcome of the game (i.e. win, lose or keep playing)
	 */
	class GuessButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(hmModel.checkGuess(hmView.getGuess())) {
				String status = hmModel.checkStatus();
				if (status.equals(Constants.ONGOING)) {
					hmView.update(hmModel.getNbrOfIncorrectGuesses(), hmModel.getHiddenWordString(), hmModel.getUsedLetters());
					hmView.addGuessButtonListener(new GuessButtonListener());
				} else {
					hmView.finishGame(hmModel.getNbrOfIncorrectGuesses(), status, hmModel.getHiddenWordString(), hmModel.getWord().toString());
					hmView.addResetButtonListener(new ResetButtonListener());
				}
			} else {
				hmView.setGuessError();
			}
		}
	}
	
	/**
	 * Listens for a game reset by the user. Returns to start menu.
	 */
	class ResetButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			hmModel.newGame();
			hmView.newGame();
			hmView.addStartButtonListener(new StartButtonListener());
		}
	}
}
