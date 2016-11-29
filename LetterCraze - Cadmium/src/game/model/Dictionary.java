package game.model;

public class Dictionary {
	
	int dSize = 100;
	String words [] = new String [dSize];
	
	public Dictionary (String dictionary []) {
		for (int i = 0; i < dSize; i++) {
			words [i] = dictionary [i];
		}
	}
	
	public boolean containsWord (String word) {
		return false;
	}

}
