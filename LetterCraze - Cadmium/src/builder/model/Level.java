package builder.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		//initializing all attributes to zero or default
		board = new Board();
		levelType = "Puzzel";
		levelNum = 1;
		numMoves = 0;
		themeWords = new ArrayList<String>();
		themeName = "";
		time = 0;
	}
	 
	
	public boolean resetLevel(){
		try {

			starValues = new int[3];
			themeWords = new ArrayList<String>();
			themeName = new String();
			
			// TODO reset time, numMoves, levelNum and levelType
			
			time = 0;
			numMoves= 0;
			levelNum = 1;
			levelType = "Puzzel";
			
			System.out.println("The level Entity object has been reset.");
			
			return true; // success
			
		} catch (Exception e){
			return false; // failure
		}
		
	}
	
	public boolean saveLevel(){
		String pathName = "";
		pathName = pathName + this.levelType;
		
		if(this.levelNum == 1){
			pathName = pathName + "One";
		}
		else if(this.levelNum == 2){
			pathName = pathName + "Two";
		}
		else if(this.levelNum == 3){
			pathName = pathName + "Three";
		}
		else if(this.levelNum == 4){
			pathName = pathName + "Four";
		}
		else if(this.levelNum == 5){
			pathName = pathName + "Five";
		}
		else{
			System.out.println("Invalid level Number");
			return false;
		}
		
		try{
			Path filePath = Paths.get(pathName+".txt");
			ArrayList<String> contents = this.levelToText();
			Charset charset = Charset.forName("US-ASCII");
			Files.write(filePath, contents, charset);
			return true;
		}catch(IOException e){
			//TODO
			return false;
		}
	}
	
	private ArrayList<String> levelToText() {
		ArrayList<String> levelText = new ArrayList<String>();
		
		levelText.add(this.levelType);
		levelText.add(""+this.levelNum);
		levelText.add(this.board.toString());
		
		String stars = "";
		stars = stars + this.starValues[0];
		stars = stars + this.starValues[1];
		stars = stars + this.starValues[2];
		levelText.add(stars);
		
		levelText.add(""+this.numMoves);
		levelText.add(""+this.time);
		levelText.add(themeName);
		levelText.addAll(themeWords);
		
		for(int i = 0; i < levelText.size(); i++){
			System.out.println(levelText.get(i));
		}
		
		return levelText;
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
		System.out.println("The time has been set to " + time);
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String name) {
		themeName = name;
		System.out.println("The theme name is now " + themeName);
	}

	public void setNumMoves(int numMoves2) {
		numMoves = numMoves2;
		System.out.println("The number of moves is now " + numMoves);
	}

	public int getNumMoves() {
		return numMoves;
	}

	public void setScores(int which, int score) {
		starValues[which - 1] = score;
		System.out.println("The score for star value number " + (which-1) + " is now "+ score);
	}

	public int getScores(int n) {
		try{
			return starValues[n - 1];
		} catch(Exception e){
			return 0; // indicate failure
		}
	}

	public void setLevelType(String type) {
		levelType = type;
		System.out.println("The entity level type is now " + levelType);
	}
	
	public void setBoard(Board b){
		board = b;
	}
}
