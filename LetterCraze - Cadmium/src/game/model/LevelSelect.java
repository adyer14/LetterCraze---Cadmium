package game.model;

public class LevelSelect {

	Level playableLevels [] = new Level [15];
	PuzzleLevel puzzleLevel[] = new PuzzleLevel[6];
	LightningLevel lightningLevel[] = new LightningLevel[6];
	ThemeLevel themeLevel[] = new ThemeLevel[6];
	
	// THESE ARE TEST VARIABLES, DELETE WHEN WE GET FILE UPLOAD WORKING
	int[] starVal = {0,0,0};
	Board board = new Board();
	int numMoves = 5;
	int time = 34;
	String[] themeWords = {"yes", "yes", "yes"};
	Dictionary themeDic = new Dictionary(themeWords);
	String themeName = "Example";
	
	public LevelSelect (Level levels []) {
		for (int i = 0; i < 15; i++) {
			playableLevels [i] = levels [i];
		}
		for (int i = 1; i <=5; i++) {
			puzzleLevel[i] = new PuzzleLevel(starVal, board, i, numMoves);
			lightningLevel[i] = new LightningLevel(starVal, board, i, time);
			themeLevel[i] = new ThemeLevel(starVal, board, i, themeName, themeDic);
		}
		
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
