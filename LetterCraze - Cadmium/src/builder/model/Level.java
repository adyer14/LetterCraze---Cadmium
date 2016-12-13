package builder.model;

import java.util.ArrayList;

public class Level {

	Board board;
	int[] starValues = new int[3];
	String levelType;
	int levelNum;
	int numMoves;
	ArrayList<String> themeWords;
	String themeName;
	int time;
	
	public Level(){
		board = new Board();
	}
	
	public boolean resetLevel(){
		try {

			starValues = new int[3];
			themeWords = new ArrayList<String>();
			themeName = new String();
			
			// TODO reset time, numMoves, levelNum and levelType?
			
			System.out.println("The level Entity object has been reset.");
			
			return true; // success
			
		} catch (Exception e){
			return false; // failure
		}
		
	}
	
	public boolean saveLevel(){
		return false;
	}
	
	public void setThemeWords(ArrayList<String> words){
		
	}
	
	public boolean addThemeWordTiles(String tw, Board b){
		return false;
	}

	public int getTime() {
		
		return time;
	}

	public void setTime(int num) {
		time = num;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String name) {
		themeName = name;
		
	}

	public void setNumMoves(int numMoves2) {
		numMoves = numMoves2;
	}

	public int getNumMoves() {
		return numMoves;
	}

	public void setScores(int which, int score) {
		starValues[which - 1] = score;
	}

	public int getScores(int n) {
		try{
			return starValues[n - 1];
		} catch(Exception e){
			return 0; // indicate failure
		}
	}
}
