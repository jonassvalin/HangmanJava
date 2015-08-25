package main;

import controller.HangmanController;
import model.HangmanModel;
import view.HangmanView;

public class Main {

	public static void main(String[] args) {
		HangmanModel hmModel = new HangmanModel();
		HangmanView hmView = new HangmanView();
		HangmanController hmController = new HangmanController(hmModel, hmView);
	}
	
}
