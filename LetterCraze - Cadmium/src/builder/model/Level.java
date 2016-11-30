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
		return true;
	}
	
	public boolean saveLevel(){
		return false;
	}
	
	public void setThemeWords(ArrayList<String> words){
		
	}
	
	public boolean addThemeWordTiles(String tw, Board b){
		return false;
	}
}
