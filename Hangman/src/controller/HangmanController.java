package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.HangmanView;
import model.HangmanModel;

public class HangmanController {
	private HangmanModel hmModel;
	private HangmanView hmView;
	
	public HangmanController(HangmanModel hmModel, HangmanView hmView) {
		this.hmModel = hmModel;
		this.hmView = hmView;
		this.hmView.addStartButtonListener(new StartButtonListener());
	}
	
	class StartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			hmModel.createWord(hmView.getSpecifiedWord(), hmView.getDifficulty());
			if (hmModel.getWord() != null) {
				hmView.startNewGame(hmModel.getNbrOfIncorrectGuesses(), hmModel.getWordString());
				hmView.addGuessButtonListener(new GuessButtonListener());
			} else {
				hmView.setSpecifiedWordError();
			}
		}
	}
	
	class GuessButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			hmModel.checkGuess(hmView.getGuess());
			String status = hmModel.checkStatus();
			if (status.equals("ongoing")) {
				hmView.update(hmModel.getNbrOfIncorrectGuesses(), hmModel.getWordString());
				hmView.addGuessButtonListener(new GuessButtonListener());
			} else {
				hmView.finishGame(hmModel.getNbrOfIncorrectGuesses(), status);
				hmView.addResetButtonListener(new ResetButtonListener());
			}
		}
	}
	
	class ResetButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			hmModel.reset();
			hmView.reset();
			hmView.addStartButtonListener(new StartButtonListener());
		}
	}
}
