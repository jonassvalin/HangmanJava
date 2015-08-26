package word;

/**
 * Defines necessary functionalities for objects implementing Word
 * @author jonassvalin
 *
 */
public interface Word {
	
	/**
	 * Returns a string representation of the word
	 */
	public String toString();

	/**
	 * Returns the length of the word
	 */
	public int getLength();
	
	/**
	 * Returns a string consisting of the found characters and underlines for the hidden ones
	 */
	public String getHiddenWordString();
	
	/**
	 * Sets the status of the characters that match the guess to found
	 */
	public void setFound(String guess);
	
	/**
	 * Returns true if all characters of the word have been found
	 */
	public boolean allCharactersFound();

}
