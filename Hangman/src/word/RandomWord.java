package word;

import java.util.HashMap;

import main.Constants;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * The random word defines a word randomly generated using the WordsAPI, see https://www.wordsapi.com/
 * @author jonassvalin
 *
 */
public class RandomWord implements Word {
	private final static String BASE_URL = "https://wordsapiv1.p.mashape.com/words?random=true&";
	private final static String API_KEY = "xJkqXGguDTmshoNIaGVnrMZlFPmUp1WrnZLjsn8DDx3DFQhNq5";
	private final static String HIDDEN = "hidden";
	private final static String FOUND = "found";
	private HashMap<Integer, String> characters;
	private String word;
	private int length;
	
	public RandomWord(String difficulty) {
		String url = createURL(difficulty);
		word = findNewWord(url, difficulty);
		length = word.length();
		characters = new HashMap<Integer, String>();
		for (int i = 0; i < getLength(); i++) {
			characters.put(i, HIDDEN);
		}
	}
	
	/**
	 * Returns a string representation of the word
	 */
	public String toString() {
		return word;
	}

	/**
	 * Returns the length of the word
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Returns true if all characters of the word have been found
	 */
	public boolean allCharactersFound() {
		for (int i = 0; i < getLength(); i++) {
			if (characters.get(i).equals(HIDDEN)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns a string consisting of the found characters and underlines for the hidden ones
	 */
	public String getHiddenWordString() {
		StringBuilder wordString = new StringBuilder();
		for (int i = 0; i < getLength(); i++) {
			if (characterStatus(i).equals(HIDDEN)) {
				wordString.append("_ ");
			} else {
				wordString.append(getChar(i) + " ");
			}
		}
		return wordString.toString();
	}
	
	/**
	 * Sets the status of the characters that match the guess to found
	 */
	public void setFound(String guess) {
		for (int i = 0; i < getLength(); i++) {
			if (getChar(i).equals(guess)) {
				characters.put(i, FOUND);
			}
		}
	}
	
	/**
	 * Returns the status (hidden or found) for the character at position i
	 */
	private String characterStatus(int i) {
		return characters.get(i);
	}
	
	/**
	 * Returns the character at position i
	 */
	private String getChar(int i) {
		return Character.toString(word.charAt(i));
	}

	/**
	 * Finds a new word from the WordsAPI using the baseURL and 
	 */
	private String findNewWord(String url, String difficulty) {
		HttpResponse<JsonNode> response;
		JsonNode responseNode;
		JSONObject jsonWord = new JSONObject();
		try {
			response = Unirest.get(url)
					.header("X-Mashape-Key", API_KEY)
					.header("Accept", "application/json")
					.asJson();
			responseNode = response.getBody();
			jsonWord = responseNode.getObject();
		} catch (UnirestException e) {
			System.out.println("ERROR: Unable to connect to WordsAPI, please try again.");
			System.exit(0);
		}
		String potentialWord = jsonWord.get("word").toString().toUpperCase();
		String frequency = "";
		try {
			frequency = jsonWord.get("frequency").toString();
		} catch (org.json.JSONException e) {
			return findNewWord(url, difficulty);
		}
		if (wordAccepted(potentialWord, difficulty, Double.parseDouble(frequency))) return potentialWord;
		else return findNewWord(url, difficulty);
	}

	/**
	 * Returns true if the randomly generated word meets the criteria for the game.
	 * The criteria are that it only inlcudes letters and has a frequency that matches
	 * the difficulty setting chosen by the player.
	 */
	private boolean wordAccepted(String potentialWord, String difficulty,
			double frequency) {
		boolean accepted = false;
		if (!potentialWord.matches("[A-Z]+")) return false;
		if (difficulty.equals(Constants.EASY)) {
			if (frequency > 4) accepted = true;
		} else if (difficulty.equals(Constants.MEDIUM)) {
			if (frequency < 4 && frequency > 3) accepted = true;
		} else if (difficulty.equals(Constants.HARD)) {
			if (frequency < 2.5) accepted = true;
		}
		return accepted;
	}

	/**
	 * Creates the url for the word request. Depending on the difficulty different
	 * minimum and maximum lengths of the random word are chosen.
	 */
	private String createURL(String difficulty) {
		StringBuilder url = new StringBuilder();
		url.append(BASE_URL);
		String minLength = "";
		String maxLength = "";
		if (difficulty.equals(Constants.EASY)) {
			minLength = "3";
			maxLength = "4";
		} else if (difficulty.equals(Constants.MEDIUM)) {
			minLength = "5";
			maxLength = "7";
		} else if (difficulty.equals(Constants.HARD)) {
			minLength = "8";
			maxLength = "12";
		}
		url.append("lettersMin=" + minLength + "&lettersMax=" + maxLength);
		return url.toString();
	}

}
