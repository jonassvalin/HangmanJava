package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;

import javax.swing.*;

import main.Constants;
import main.Main;

/**
 * Defines the start page panel
 * @author jonassvalin
 *
 */
public class StartPagePanel extends HangmanPanel {
	private final String[] difficultySettings = {Constants.EASY, Constants.MEDIUM, Constants.HARD};
	private JLabel headLine;
	private JLabel difficultyLabel;
	private JLabel startLabel;
	private JLabel dukeImage;
	private JComboBox difficultyChooser;
	private GridBagConstraints cs;

	protected StartPagePanel() {
		super(new GridBagLayout());
		cs = new GridBagConstraints();
		
		headLine = new JLabel("Welcome to Duke Hangem' 3D");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 3;
		this.add(headLine, cs);
		
		URL url = Main.class.getResource("/duke.jpg");
		ImageIcon image = (new ImageIcon(((new ImageIcon(url)).getImage()).getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		dukeImage = new JLabel("", image, JLabel.CENTER);
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 3;
		this.add(dukeImage, cs);
		
		difficultyLabel = new JLabel("Choose difficulty: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		this.add(difficultyLabel, cs);

		difficultyChooser = new JComboBox(difficultySettings);
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		this.add(difficultyChooser, cs);
		
		startLabel = new JLabel("Start New Game: ");
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 1;
		this.add(startLabel, cs);

		button = new JButton("Go!");
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		this.add(button, cs);
	}
	
	/**
	 * Returns the difficulty setting chosen by the player
	 */
	protected String getDifficulty() {
		return (String) difficultyChooser.getSelectedItem();
	}
	
}
