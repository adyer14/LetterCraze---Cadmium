package game.model;

public class Dictionary {
	
	private int dictSize = 3;
	String words [] = new String [dictSize];
	
	public Dictionary (String dictionary []) {
		for (int i = 0; i < dictSize; i++) {
			words [i] = dictionary [i];
		}
	}
	
	public boolean containsWord (String word) {
		return false;
	}

	public int getDictSize() {
		return dictSize;
	}

	public void setDictSize(int dSize) {
		this.dictSize = dSize;
	}

}
