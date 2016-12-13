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
		
	}
	
	public boolean resetLevel(){
		return false;
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
}
