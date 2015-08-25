package word;

import java.util.HashMap;

public class SpecifiedWord extends Word {
	
	public SpecifiedWord(String word) {
		this.word = word;
		this.length = word.length();
		characters = new HashMap<Integer, String>();
		for (int i = 0; i < getLength(); i++) {
			characters.put(i, "hidden");
		}
	}

}
