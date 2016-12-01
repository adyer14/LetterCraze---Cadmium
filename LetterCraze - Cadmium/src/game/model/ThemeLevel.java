package game.model;

public class ThemeLevel extends Level {

	private Dictionary themeWords;
	private String themeName;
	
	public ThemeLevel(int[] starVal, Board board, int levelNumber, String themeName, Dictionary themeWords) {
		super(starVal, board, levelNumber);
		this.setThemeName(themeName);
		this.themeWords = themeWords;
	}

	public Level resetLevel () {
		return new Level (starValues, board, 1);
	}
	
	public boolean undoMove (Board board) {
		return false;
	}

	public boolean addWord (Word word) {
		return false;
	}
	
	public boolean removeWord (Word word) {
		return false;
	}
	
	public int addScore (Word word) {
		return 0;
	}
	
	public int checkStarProgress (int score, int levelNumber) {
		return 0;
	}
	
	public boolean repopulate (Board board) {
		return false;
	}

	public Dictionary getThemeWords() {
		return themeWords;
	}

	public void setThemeWords(Dictionary themeWords) {
		this.themeWords = themeWords;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	
	
}
