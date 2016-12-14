package game.model;

import java.util.ArrayList;
import java.util.Arrays;

public class LevelSelect {

	Level playableLevel[] = new Level [16];
	PuzzleLevel puzzleLevel[] = new PuzzleLevel[6];
	LightningLevel lightningLevel[] = new LightningLevel[6];
	ThemeLevel themeLevel[] = new ThemeLevel[6];
	
	// THESE ARE TEST VARIABLES, DELETE WHEN WE GET FILE UPLOAD WORKING
	int[] starVal = {0,0,0};
	Board board = new Board();
	int numMoves = 5;
	int time = 34;
	String list [] = {"yes", "no", "maybe"};
	ArrayList<String> themeWords = (ArrayList<String>) Arrays.asList(list);
	ThemeDictionary themeDic = new ThemeDictionary(themeWords);
	String themeName = "Example";
	
	public LevelSelect (Level levels []) {
		
		for (int i = 1; i <=5; i++) {
			puzzleLevel[i] = new PuzzleLevel(starVal, board, i, numMoves);
			lightningLevel[i] = new LightningLevel(starVal, board, i, time);
			themeLevel[i] = new ThemeLevel(starVal, board, i, themeName, themeDic);
		}
		for (int i = 1; i <= 5; i++) {
			playableLevel[i] = puzzleLevel[i];
			playableLevel[i+5] = lightningLevel[i];
			playableLevel[i+10] = themeLevel[i];
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
