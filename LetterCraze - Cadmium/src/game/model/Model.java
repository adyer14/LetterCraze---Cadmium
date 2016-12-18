package game.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Model is the base for the game
 */
public class Model {
	
	private Level level [] = new Level [16];
	PuzzleLevel puzzleLevel[] = new PuzzleLevel[6];
	LightningLevel lightningLevel[] = new LightningLevel[6];
	ThemeLevel themeLevel[] = new ThemeLevel[6];
	ArrayList<Square> randomBoardSquares = new ArrayList<Square>(36);
	ArrayList<Square> foodSquares = new ArrayList<Square>();
	ArrayList<Square> rSquares = new ArrayList<Square>();
	ArrayList<Square> fourSquares = new ArrayList<Square>();
	ArrayList<Square> duneSquares = new ArrayList<Square>();
	ArrayList<Square> latinSquares = new ArrayList<Square>();
		private int[] starVal;
		private int numMoves;
		private int time;
		private Board board;
		private String squaresInPlay;
		private String themeName;
		private String themeWords;
		
	/**
	 * Constructor
	 */
	public Model() {
		board = new Board(null);
		randomBoardSquares = new ArrayList<Square>(36);
		ArrayList<Tile> initialTiles = new ArrayList<Tile>();
		
		int row, col;
		for (int i = 0; i < 36; i++) {
			row = (int) Math.floor(i/6);
			col = i%6;
			
			Tile tile = randomTile();
			Square square = new Square(row, col, true, tile);
			randomBoardSquares.add(i, square);
			
		}
		
		board = new Board(randomBoardSquares);

		for (int i = 1; i <= 5; i++) {
			this.loadIn("puzzle", i);
			puzzleLevel[i] = new PuzzleLevel(starVal, squaresInPlay, board, i, numMoves);
			
			this.loadIn("lightning", i);
			lightningLevel[i] = new LightningLevel(starVal, squaresInPlay, board, i, time);
			
			this.loadIn("theme", i);
			ThemeDictionary themeDict = new ThemeDictionary(Arrays.asList(themeWords.split("\\n")));
			themeLevel[i] = new ThemeLevel(starVal, squaresInPlay, null, board, i, themeName, themeDict);
		}
	}
	
	public Level getSpecificLevel(String levType, int levNum) {
		if (levType == "puzzle")
			return getPuzzleLevel(levNum);
		if (levType == "lightning")
			return getLightningLevel(levNum);
		else 
			return getThemeLevel(levNum);
	}
	
	public Tile randomTile () {
		Random rand = new Random();
		int n = rand.nextInt(100000) + 1;
		
		if (n >= 1 && n <= 8167) {
			return new LetterTile ("A", 2);
		}
		
		if (n >= 8168 && n <= 9659) {
			return new LetterTile ("B", 4);
		}
		
		if (n >= 9660 && n <= 12441) { 
			return new LetterTile ("C", 3);
		}
		
		if (n >= 12441 && n <= 16694) {
			return new LetterTile ("D", 3);
		}
		
		if (n >= 16695 && n <= 29396) {
			return new LetterTile ("E", 1);
		}
		
		if (n >= 29397 && n <= 31624) {
			return new LetterTile ("F", 4);
		}
		
		if (n >= 31625 && n <= 33639) {
			return new LetterTile ("G", 4);
		}
		
		if (n >= 33640 && n <= 39733) {
			return new LetterTile ("H", 2);
		}
		
		if (n >= 39733 && n <= 46699) {
			return new LetterTile ("I", 2);
		}
		
		if (n >= 46700 && n <= 46852) {
			return new LetterTile ("J", 7);
		}
		
		if (n >= 46853 && n <= 47624) {
			return new LetterTile ("K", 5);
		}
		
		if (n >= 47625 && n <= 51649) {
			return new LetterTile ("L", 3);
		}
		
		if (n >= 51650 && n <= 54055) {
			return new LetterTile ("M", 3);
		}
		
		if (n >= 54056 && n <= 60804) {
			return new LetterTile ("N", 2);
		}
		
		if (n >= 60805 && n <= 68311) {
			return new LetterTile ("O", 2);
		}
		
		if (n >= 68312 && n <= 70240) {
			return new LetterTile ("P", 4);
		}
		
		if (n >= 70241 && n <= 70335) {
			return new LetterTile ("Qu", 8);
		}
		
		if (n >= 70336 && n <= 76322) {
			return new LetterTile ("R", 2);
		}
		
		if (n >= 76323 && n <= 82649) {
			return new LetterTile ("S", 2);
		}
		
		if (n >= 82649 && n <= 91705) {
			return new LetterTile ("T", 1);
		}
		
		if (n >= 91706 && n <= 94463) {
			return new LetterTile ("U", 3);
		}
		
		if (n >= 94464 && n <= 95441) {
			return new LetterTile ("V", 5);
		}
		
		if (n >= 95442 && n <= 97801) {
			return new LetterTile ("W", 3);
		}
		
		if (n >= 97802 && n <= 97951) {
			return new LetterTile ("X", 7);
		}
		
		if (n >= 97952 && n <= 99925) {
			return new LetterTile ("Y", 4);
		}
		
		if (n >= 99926 && n <= 100000) {
			return new LetterTile ("Z", 8);
		}
		
		else {
			return new BlankTile ();
		}
	}

	public void loadIn(String levType, int levNum) {
		ArrayList<String> contents = new ArrayList<String>();
		String pathName = "src/levels/" + levType.toUpperCase() + levNum + ".txt";
		try{
			Path filePath = Paths.get(pathName);
			contents = (ArrayList<String>) Files.readAllLines(filePath);
			for (int i = 0; i < contents.size(); i++) {
				System.out.println(contents.get(i));
			}
			System.out.println("The level has been read");
		}catch(IOException e){
			//TODO
			System.out.println("could not find file");
		}
		
		contents.remove(0);
		contents.remove(0);
		squaresInPlay = contents.remove(0);
		for (int m = 0; m < 36; m++) {
			
			char sqsChar = squaresInPlay.charAt(m);
			if (sqsChar == '1') {
				this.randomBoardSquares.get(m).setSquareInPlay(true);
			}
			if (sqsChar == '0') {
				this.randomBoardSquares.get(m).setSquareInPlay(false);
			}
		}
		int[] tempStarValues = new int[3];
		tempStarValues[0] = Integer.parseInt(contents.remove(0));
		tempStarValues[1] = Integer.parseInt(contents.remove(0));
		tempStarValues[2] = Integer.parseInt(contents.remove(0));
		this.starVal = tempStarValues;
		
		if(levType.equals("puzzle")){
			this.numMoves = Integer.parseInt(contents.remove(0));
		}else{
			contents.remove(0);
		}
		if(levType.equals("lightning")){
			this.time = Integer.parseInt(contents.remove(0));
		}else{
			contents.remove(0);
		}
		if(levType.equals("theme")){
			this.themeName = contents.remove(0);
			String allWords = "";
			for (int i = 0; i < this.starVal[2]; i++) {
				allWords = allWords.concat(contents.remove(0));
				allWords = allWords.concat("\n");
			}
			System.out.println("HERE" + allWords);
			this.themeWords = allWords.toUpperCase();
		}
	}
	
	
	/**
	 * Get/set methods
	 */
	public Level[] getLevels() {
		return level;
	}
	
	public void setLevels(Level level[]) {
		this.level = level;
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
