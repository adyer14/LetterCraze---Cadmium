package game.model;

import java.util.ArrayList;

public class ThemeLevel extends Level {

	ThemeDictionary themeWords;
	private String themeName;
	private int wordsLeft;
	int i = 0;
	
	public ThemeLevel(int[] starVal, Board board, ArrayList<Tile> initialTiles, int levelNumber, String themeName, ThemeDictionary themeWords) {
		super(starVal, board, initialTiles, levelNumber);
		this.setThemeName(themeName);
		this.themeWords = themeWords;
		//TODO HACK super hacks
		themeWords.words.add("NOON");
		themeWords.words.add("TEN");
		themeWords.words.add("TED");
		themeWords.words.add("EA");
		themeWords.words.add("EO");
		setLevelType();
	}
	
	@Override
	public boolean resetLevel() {
		return this.levelResetLevel();
	}

	@Override
	public int addScore(Word word) {
		return this.score = wordList.size();
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
	public ThemeDictionary getThemeWords() {
		return themeWords;
	}

	public void setThemeWords(ThemeDictionary themeWords) {
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
