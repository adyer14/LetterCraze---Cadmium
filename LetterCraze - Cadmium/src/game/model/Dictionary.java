package game.model;

public class Dictionary {
	
	private int dSize = 3;
	String words [] = new String [getdSize()];
	
	public Dictionary (String dictionary []) {
		for (int i = 0; i < getdSize(); i++) {
			words [i] = dictionary [i];
		}
	}
	
	public boolean containsWord (String word) {
		return false;
	}

	public int getdSize() {
		return dSize;
	}

	public void setdSize(int dSize) {
		this.dSize = dSize;
	}

}
