package view;

import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import word.RandomWord;
import word.SpecifiedWord;
import word.Word;

public class StartPagePanel extends JPanel {
	private final String[] difficultySettings = {"Easy", "Medium", "Hard"};
	private String chosenDifficulty;
	private JLabel headLine;
	private JLabel difficultyLabel;
	private JLabel startLabel;
	private JLabel dukeImage;
	private JLabel orLabel;
	private JLabel specifiedLabel;
	private JComboBox difficultyChooser;
	private JTextField specifiedWordField;
	private JButton startButton;
	private GridBagConstraints cs;

	protected StartPagePanel() {
		super(new GridBagLayout());
		cs = new GridBagConstraints();
		
		headLine = new JLabel("Welcome to Duke Hangem' 3D");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 3;
		this.add(headLine, cs);
		
		ImageIcon image = (new ImageIcon(((new ImageIcon("resources/duke.jpg")).getImage()).getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
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
		chosenDifficulty = "Easy";
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		this.add(difficultyChooser, cs);
		
		orLabel = new JLabel("(or)");
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 3;
		this.add(orLabel, cs);
		
		specifiedLabel = new JLabel("Specify word: ");
		specifiedLabel.setToolTipText("Leave blank if you want to use a randomly generated word");
		cs.gridx = 0;
		cs.gridy = 4;
		cs.gridwidth = 1;
		this.add(specifiedLabel, cs);

		specifiedWordField = new JTextField(20);
		specifiedWordField.setToolTipText("Leave blank if you want to use a randomly generated word");
		cs.gridx = 1;
		cs.gridy = 4;
		cs.gridwidth = 2;
		this.add(specifiedWordField, cs);
		
		startLabel = new JLabel("Start New Game: ");
		cs.gridx = 0;
		cs.gridy = 5;
		cs.gridwidth = 1;
		this.add(startLabel, cs);

		startButton = new JButton("Go!");
		chosenDifficulty = "Easy";
		cs.gridx = 1;
		cs.gridy = 5;
		cs.gridwidth = 2;
		this.add(startButton, cs);
	}
	
	protected String getSpecifiedWord() {
		return specifiedWordField.getText().toUpperCase();
	}
	
	protected String getDifficulty() {
		return (String) difficultyChooser.getSelectedItem();
	}
	
	protected void addStartButtonListener(ActionListener startButtonListener) {
		startButton.addActionListener(startButtonListener);
	}
	protected void setSpecifiedWordError() {
		specifiedWordField.setText("(Use only alphabetic characters)");
	}
	
}
