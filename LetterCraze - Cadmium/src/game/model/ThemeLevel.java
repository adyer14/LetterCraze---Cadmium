package game.model;

public class ThemeLevel extends Level {

	private Dictionary themeWords;
	private String themeName;
	private int wordsLeft;
	int i = 0;
	
	public ThemeLevel(int[] starVal, Board board, int levelNumber, String themeName, Dictionary themeWords) {
		super(starVal, board, levelNumber);
		this.setThemeName(themeName);
		this.themeWords = themeWords;
		setLevelType();
	}
	
	@Override
	public boolean resetLevel() {
		this.wordList.clear();
		this.score = 0;
		this.currentStars = 0;
		// TODO reset board - get board from level file and set it to the board
		if (wordList.isEmpty() && score == 0 && currentStars == 0)
			return true;
		else
			return false;
	}

	@Override
	public int addScore(Word word) {
		// TODO score method for theme
		return 0;
	}

	@Override
	public boolean repopulate(Board board) {
		// TODO repopulate method for theme
		return false;
	}
	
	@Override
	protected void setLevelType() {
		this.levelType = "theme";
	}
	

	
	/**
	 * Get/set methods
	 */
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
	
	public int getWordsLeft() {
		return wordsLeft;
	}
	
	public void setWordsLeft(int wordsLeft) {
		this.wordsLeft = wordsLeft;
	}
	
	


	
	
}
