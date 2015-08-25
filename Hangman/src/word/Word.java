package word;

import java.util.HashMap;

public abstract class Word {
	protected String word;
	protected int length;
	protected HashMap<Integer, String> characters;
	
	public String getWord() {
		return word;
	}

	public int getLength() {
		return length;
	}
	
	public boolean allCharactersFound() {
		for (int i = 0; i < getLength(); i++) {
			if (characters.get(i).equals("hidden")) {
				return false;
			}
		}
		return true;
	}
	
	public String getWordString() {
		StringBuilder wordString = new StringBuilder();
		for (int i = 0; i < getLength(); i++) {
			if (characterStatus(i).equals("hidden")) {
				wordString.append("_ ");
			} else {
				wordString.append(getChar(i) + " ");
			}
		}
		return wordString.toString();
	}
	
	public String characterStatus(int i) {
		return characters.get(i);
	}
	
	public String getChar(int i) {
		return Character.toString(word.charAt(i));
	}
	
	public void setFound(String guess) {
		for (int i = 0; i < getLength(); i++) {
			if (getChar(i).equals(guess)) {
				characters.put(i, "found");
			}
		}
	}
	
}
