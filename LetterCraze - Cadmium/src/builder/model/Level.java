package builder.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * The Level that the builder is working on.
 * 
 *
 */
public class Level {

	Board board;
	int[] starValues = new int[3];
	String levelType;
	int levelNum;
	int numMoves;
	String themeWords;
	String themeName;
	int time;
	/**
	 * Constructor
	 * @param board The board portion of the active level
	 * @param levelType can be set later
	 * @param levelNum 
	 * @param numMoves
	 * @param themeWords
	 * @param themeName
	 * @param time
	 */
	public Level(){
		//initializing all attributes to zero or default
		board = new Board();
		levelType = "";
		levelNum = 0;
		numMoves = 0;
		themeWords = "";
		themeName = "";
		time = 0;
	}
	/**
	 * resetLevel clears values 
	 * @return boolean
	 */
	public boolean resetLevel(){
		try {
			starValues = new int[3];
			themeWords = "";
			themeName = "";
			
			time = 0;
			numMoves = 0;
			levelNum = 0;
			levelType = "";
			
			return true; // success
			
		} catch (Exception e){
			return false; // failure
		}
		
	}
	/**
	 * Saves file information into a text file so it can be loaded when the application runs again
	 * @return boolean
	 */
	public boolean saveLevel(){
		String pathName = "src/levels/";
		pathName = pathName + this.levelType;
		
		if(this.levelNum != 0){
			pathName = pathName + Integer.toString(this.levelNum);
		}
		else {
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
	/**
	 * Loads a previously saved level into the editor
	 * @param pathName
	 * @return boolean
	 */
	public Level loadLevel(String pathName){
		
		ArrayList<String> contents = new ArrayList<String>();
		
		try{
			Path filePath = Paths.get(pathName+".txt");
			contents = (ArrayList<String>) Files.readAllLines(filePath);
			for (int i = 0; i < contents.size(); i++) {
				System.out.println(contents.get(i));
			}
			System.out.println("The level has been read");
		}catch(IOException e){
			//TODO
			System.out.println("could not find file");
		}
		
		Level lvl = new Level();
		
		lvl.setLevelType(contents.remove(0));
		lvl.setLevelNum( Integer.parseInt(contents.remove(0)));
		lvl.setBoard(new Board(contents.remove(0)));
		int[] tempStarValues = new int[3];
		tempStarValues[0] = Integer.parseInt(contents.remove(0));
		tempStarValues[1] = Integer.parseInt(contents.remove(0));
		tempStarValues[2] = Integer.parseInt(contents.remove(0));
		lvl.setStarValues(tempStarValues);
		
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
			lvl.setThemeWords(contents.remove(0));
		}
		return lvl;
		
	}
	/**
	 * Takes all the relevant information from a created and saved level , converts it to a string, and 
	 * saves it in a text file
	 * @return levelText
	 */
	private ArrayList<String> levelToText() {
		ArrayList<String> levelText = new ArrayList<String>();
		
		levelText.add(this.levelType);
		levelText.add(""+this.levelNum);
		levelText.add(this.board.toString());
		levelText.add("" + this.starValues[0]);
		levelText.add("" + this.starValues[1]);
		levelText.add("" + this.starValues[2]);
		/*String stars = "";
		stars = stars + this.starValues[0] + ",";
		stars = stars + this.starValues[1] + ",";
		stars = stars + this.starValues[2];
		levelText.add(stars);*/
		
		levelText.add(""+this.numMoves);
		levelText.add(""+this.time);
		levelText.add(themeName);
		levelText.add(themeWords);
		
		for(int i = 0; i < levelText.size(); i++){
			System.out.println(levelText.get(i));
		}
		
		return levelText;
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
		this.themeName = name;
		System.out.println("The theme name is now " + themeName);
	}

	public void setNumMoves(int numMoves2) {
		this.numMoves = numMoves2;
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
	}
	
	public void setBoard(Board b){
		board = b;
	}

	public Board getBoard(){
		return board;
	}

	public void setLevelNum(int i) {
		levelNum = i;
	}
	
	private void fakeSetStarValues(String values) {
		String[] tokens = values.split("[,]");
		for(int i = 0; i < 3; i++){
			this.starValues[i] = Integer.parseInt(tokens[i]);
		}
	}
	
	public int[] getStarValues() {
		return starValues;
	}
	
	public void setStarValues(int[] starVal) {
		this.starValues = starVal;
	}

	public String getLevelType() {
		return levelType;
	}

	public int getLevelNum() {
		return levelNum;
	}
	
	public String getThemeWords() {
		return themeWords;
	}
	
	public void setThemeWords(String themeWords) {
		this.themeWords = themeWords;
	}
	
	public void deleteLevel(String pathName) {
		
		try{
			Path filePath = Paths.get(pathName+".txt");
			ArrayList<String> contents = new ArrayList<String>();
			Charset charset = Charset.forName("US-ASCII");
			Files.write(filePath, contents, charset);
		}catch(IOException e){
			//TODO
		}
		
		try{
			Path filePath = Paths.get(pathName + ".txt");
			Files.delete(filePath);
		} catch (NoSuchFileException x) {
			
		} catch (DirectoryNotEmptyException x) {
			
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
		
	}
}
