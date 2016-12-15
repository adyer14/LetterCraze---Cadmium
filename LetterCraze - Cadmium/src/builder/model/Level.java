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
		levelType = "";
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
			themeName = "";
			
			time = 0;
			numMoves = 0;
			levelNum = 1;
			levelType = "";
			
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
			System.out.println("The level has been saved");
			return true;
		}catch(IOException e){
			//TODO
			return false;
		}
	}
	public Level loadLevel(String pathName){
		
		ArrayList<String> contents = new ArrayList<String>();
		
		try{
			Path filePath = Paths.get(pathName+".txt");
			contents = (ArrayList<String>) Files.readAllLines(filePath);
			System.out.println("The level has been read");
		}catch(IOException e){
			//TODO
			System.out.println("could not find file");
		}
		
		Level lvl = new Level();
		
		lvl.setLevelType(contents.remove(0));
		lvl.setLevelNum( Integer.parseInt(contents.remove(0)));
		lvl.setBoard(new Board(contents.remove(0)));
		lvl.setStarValues(contents.remove(0));
		
		if(lvl.levelType.equals("PUZZLE")){
			lvl.setNumMoves(Integer.parseInt(contents.remove(0)));
		}else{
			contents.remove(0);
		}
		if(lvl.levelType.equals("LIGHTNING")){
			lvl.setTime(Integer.parseInt(contents.remove(0)));
		}else{
			contents.remove(0);
		}
		if(lvl.levelType.equals("THEME")){
			lvl.setThemeName(contents.remove(0));
			lvl.setThemeWords(contents);
		}
		return lvl;
		
	}

	private ArrayList<String> levelToText() {
		ArrayList<String> levelText = new ArrayList<String>();
		
		levelText.add(this.levelType);
		levelText.add(""+this.levelNum);
		levelText.add(this.board.toString());
		
		String stars = "";
		stars = stars + this.starValues[0] + ",";
		stars = stars + this.starValues[1] + ",";
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

	/**
	 * Sets the score for the given star value.
	 * @param which
	 * @param score
	 */
	public void setScores(int which, int score) throws Exception {
		
		switch(which){
		case 1:
			if(starValues[2] == 0 && starValues[1] == 0) {
				starValues[which - 1] = score;
				break;
			} else if(score > starValues[1]) {
				throw new Exception("Value not valid.");
			} else {
				starValues[which - 1] = score;
				break;
			}
		case 2:
			if(score <= starValues[0]) {
				throw new Exception("Value not valid.");
			} else {
				starValues[which - 1] = score;
				break;
			}
		case 3:
			if(score <= starValues[1]) {
				throw new Exception("Value not valid.");
			} else {
				starValues[which - 1] = score;
				break;
			}
		}
		
		System.out.println("The score for star value number " + (which) + " is now "+ score);
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

	public Board getBoard(){
		return board;
	}

	public void setLevelNum(int i) {
		levelNum = i;
		System.out.println("The number of the level was set to "+ levelNum);
	}


	public void addThemeWord(String word) {
		themeWords.add(word);
		System.out.println(word + " has been added to the themeWords list.");
	}

	public String getWord() {
		String last = "";
		
		for(String s: themeWords){
			last = s;
		}
		
		return last;
	}
	private void setStarValues(String values) {
		String[] tokens = values.split("[,]");
		for(int i = 0; i < 3; i++){
			this.starValues[i] = Integer.parseInt(tokens[i]);
		}
	}
}
