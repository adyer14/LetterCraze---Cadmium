package game.model;

import java.util.ArrayList;
import java.util.List;

public class ThemeDictionary {
	
	List<String> words = new ArrayList<String>();
	
	public ThemeDictionary (ArrayList<String> dictionary) {
		this.words = dictionary;
	}
	
	public boolean containsWord (String word) {
		return this.words.contains(word);
	}
}
