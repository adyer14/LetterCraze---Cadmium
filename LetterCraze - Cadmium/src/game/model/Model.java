package game.model;

public class Model {
	
	private Level level [] = new Level [16];
	PuzzleLevel puzzleLevel[] = new PuzzleLevel[6];
	LightningLevel lightningLevel[] = new LightningLevel[6];
	ThemeLevel themeLevel[] = new ThemeLevel[6];
	LevelSelect ls = new LevelSelect (getLevels());
	
	// THESE ARE TEST VARIABLES, DELETE WHEN WE GET FILE UPLOAD WORKING
		int[] starVal = {0,0,0};
		Board board = new Board();
		int numMoves = 5;
		int time = 34;
		String[] themeWords = {"yes", "yes", "yes"};
		Dictionary themeDic = new Dictionary(themeWords);
		String themeName = "Example";
	
	public Model() {
		for (int i = 1; i <=5; i++) {
			puzzleLevel[i] = new PuzzleLevel(starVal, board, i, numMoves);
			puzzleLevel[i].setMostStars(2);
			lightningLevel[i] = new LightningLevel(starVal, board, i, time);
			themeLevel[i] = new ThemeLevel(starVal, board, i, themeName, themeDic);
		}
		for (int i = 1; i <= 5; i++) {
			level[i] = puzzleLevel[i];
			level[i+5] = lightningLevel[i];
			level[i+10] = themeLevel[i];
		}
	}
	
	public Level[] getLevels() {
		return level;
	}
	public void setLevels(Level level[]) {
		this.level = level;
	}
	
	public LevelSelect getLevelSelect() {
		return ls;
	}
	
	public void setLevelSelect(LevelSelect ls) {
		this.ls = ls;
	}
	
	public PuzzleLevel getPuzzleLevel(int levNum) {
		return puzzleLevel[levNum];
	}
	
	public void setPuzzleLevel(int levNum, PuzzleLevel pLvl) {
		this.puzzleLevel[levNum] = pLvl;
	}
	
	public LightningLevel getLightningLevel(int levNum) {
		return lightningLevel[levNum];
	}
	
	public void setLightningLevel(int levNum, LightningLevel lLvl) {
		this.lightningLevel[levNum] = lLvl;
	}
	
	public ThemeLevel getThemeLevel(int levNum) {
		return themeLevel[levNum];
	}
	
	public void setThemeLevel(int levNum, ThemeLevel tLvl) {
		this.themeLevel[levNum] = tLvl;
	}
	
}
