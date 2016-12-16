package game.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Specific dictionary for theme levels
 */
public class ThemeDictionary {
	
	List<String> words = new ArrayList<String>();
	
	public ThemeDictionary (List<String> dictionary) {
		this.words = dictionary;
	}
	
	public boolean containsWord (String word) {
		return this.words.contains(word);
	}
}
