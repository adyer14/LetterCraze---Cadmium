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
	LevelSelect ls = new LevelSelect (getLevels());
	ArrayList<Square> randomBoardSquares = new ArrayList<Square>(36);
	ArrayList<Square> foodSquares = new ArrayList<Square>();
	ArrayList<Square> rSquares = new ArrayList<Square>();
	ArrayList<Square> fourSquares = new ArrayList<Square>();
	ArrayList<Square> duneSquares = new ArrayList<Square>();
	ArrayList<Square> latinSquares = new ArrayList<Square>();
	
	
	// THESE ARE TEST VARIABLES, DELETE WHEN WE GET FILE UPLOAD WORKING
		private int[] starVal;
		//Board board = new Board(null);
		private int numMoves;
		private int time;
		//String list [] = {"yes", "no", "maybe"};
		//List<String> themeWords = new ArrayList<String>(Arrays.asList(list));
		//ThemeDictionary themeDic = new ThemeDictionary(themeWords);
		//String themeName = "Example";
		
		String foodList [] = {"PIE", "BURGER", "PIZZA"};
		List<String> foodWords = new ArrayList<String>(Arrays.asList(foodList));
		ThemeDictionary foodDic = new ThemeDictionary(foodWords);
		String foodName = "Food";
		
		String rList [] = {"RAW", "RAT", "RED", "RIP"};
		List<String> rWords = new ArrayList<String>(Arrays.asList(rList));
		ThemeDictionary rDic = new ThemeDictionary(rWords);
		String rName = "R";
		
		String fourList [] = {"FOUR", "FOUR", "FOUR", "Four"};
		List<String> fourWords = new ArrayList<String>(Arrays.asList(fourList));
		ThemeDictionary fourDic = new ThemeDictionary(fourWords);
		String fourName = "Four";
		
		String duneList [] = {"MELANGE", "ARRAKIS", "MUADDIB"};
		List<String> duneWords = new ArrayList<String>(Arrays.asList(duneList));
		ThemeDictionary duneDic = new ThemeDictionary(fourWords);
		String duneName = "Dune";
	/**
	 * Constructor
	 */
		String latinList [] = {"CATULLUS", "CAESAR", "HORACE"};
		List<String> latinWords = new ArrayList<String>(Arrays.asList(latinList));
		ThemeDictionary latinDic = new ThemeDictionary(latinWords);
		String latinName = "Latin Bros";
		private Board board;
		private String squaresInPlay;
		
		
	public Model() {
		board = new Board(null);
		randomBoardSquares = new ArrayList<Square>(36);
		ArrayList<Tile> initialTiles = new ArrayList<Tile>();
		
		// Generate Theme Letters
		foodSquares.add(new Square(0, 0, true, randomTile()));//0
		foodSquares.add(new Square(0, 1, true, new LetterTile("P", 4)));//1
		foodSquares.add(new Square(0, 2, true, new LetterTile("I", 2)));//2
		foodSquares.add(new Square(0, 3, true, randomTile()));//3
		foodSquares.add(new Square(0, 4, true, randomTile()));//4
		foodSquares.add(new Square(0, 5, true, randomTile()));//5
		foodSquares.add(new Square(1, 0, true, randomTile()));//6
		foodSquares.add(new Square(1, 1, true, randomTile()));//7
		foodSquares.add(new Square(1, 2, true, new LetterTile("E", 1)));//8
		foodSquares.add(new Square(1, 3, true, randomTile()));//9
		foodSquares.add(new Square(1, 4, true, randomTile()));//10
		foodSquares.add(new Square(1, 5, true, randomTile()));//11
		foodSquares.add(new Square(2, 0, true, randomTile()));//12
		foodSquares.add(new Square(2, 1, true, randomTile()));//13
		foodSquares.add(new Square(2, 2, true, randomTile()));//14
		foodSquares.add(new Square(2, 3, true, randomTile()));//15
		foodSquares.add(new Square(2, 4, true, randomTile()));//16
		foodSquares.add(new Square(2, 5, true, randomTile()));//17
		foodSquares.add(new Square(3, 0, true, randomTile()));//18
		foodSquares.add(new Square(3, 1, true, randomTile()));//19
		foodSquares.add(new Square(3, 2, true, new LetterTile("B", 4)));//20
		foodSquares.add(new Square(3, 3, true, new LetterTile("U", 3)));//21
		foodSquares.add(new Square(3, 4, true, new LetterTile("R", 2)));//22
		foodSquares.add(new Square(3, 5, true, new LetterTile("G", 4)));//23
		foodSquares.add(new Square(4, 0, true, randomTile()));//24
		foodSquares.add(new Square(4, 1, true, randomTile()));//25
		foodSquares.add(new Square(4, 2, true, randomTile()));//26
		foodSquares.add(new Square(4, 3, true, randomTile()));//27
		foodSquares.add(new Square(4, 4, true, new LetterTile("R", 2)));//28
		foodSquares.add(new Square(4, 5, true, new LetterTile("E", 1)));//29
		foodSquares.add(new Square(5, 0, true, new LetterTile("P", 4)));//30
		foodSquares.add(new Square(5, 1, true, new LetterTile("I", 2)));//31
		foodSquares.add(new Square(5, 2, true, new LetterTile("Z", 8)));//32
		foodSquares.add(new Square(5, 3, true, new LetterTile("Z", 8)));//33
		foodSquares.add(new Square(5, 4, true, new LetterTile("A", 2)));//34
		foodSquares.add(new Square(5, 5, true, randomTile()));//35
		
		rSquares.add(new Square(0, 0, true, new LetterTile("R", 2)));//0
		rSquares.add(new Square(0, 1, true, new LetterTile("E", 1)));//1
		rSquares.add(new Square(0, 2, true, new LetterTile("D", 3)));//2
		rSquares.add(new Square(0, 3, false,new BlankTile()));//3
		rSquares.add(new Square(0, 4, false,new BlankTile()));//4
		rSquares.add(new Square(0, 5, false,new BlankTile()));//5
		rSquares.add(new Square(1, 0, true, randomTile()));//6
		rSquares.add(new Square(1, 1, false,new BlankTile()));//7
		rSquares.add(new Square(1, 2, true, randomTile()));//8
		rSquares.add(new Square(1, 3, false,new BlankTile()));//9
		rSquares.add(new Square(1, 4, false,new BlankTile()));//10
		rSquares.add(new Square(1, 5, false,new BlankTile()));//11
		rSquares.add(new Square(2, 0, true, new LetterTile("R", 2)));//12
		rSquares.add(new Square(2, 1, true, new LetterTile("A", 2)));//13
		rSquares.add(new Square(2, 2, true, new LetterTile("W", 3)));//14
		rSquares.add(new Square(2, 3, false,new BlankTile()));//15
		rSquares.add(new Square(2, 4, false,new BlankTile()));//16
		rSquares.add(new Square(2, 5, false,new BlankTile()));//17
		rSquares.add(new Square(3, 0, true, randomTile()));//18
		rSquares.add(new Square(3, 1, true, new LetterTile("R", 2)));//19
		rSquares.add(new Square(3, 2, false,new BlankTile()));//20
		rSquares.add(new Square(3, 3, true, new LetterTile("R", 2)));//21
		rSquares.add(new Square(3, 4, false,new BlankTile()));//22
		rSquares.add(new Square(3, 5, false,new BlankTile()));//23
		rSquares.add(new Square(4, 0, true, new LetterTile("A", 2)));//24
		rSquares.add(new Square(4, 1, true, randomTile()));//25
		rSquares.add(new Square(4, 2, false,new BlankTile()));//26
		rSquares.add(new Square(4, 3, false,new BlankTile()));//27
		rSquares.add(new Square(4, 4, true, new LetterTile("I", 2)));//28
		rSquares.add(new Square(4, 5, false,new BlankTile()));//29
		rSquares.add(new Square(5, 0, true, new LetterTile("T", 1)));//30
		rSquares.add(new Square(5, 1, true, randomTile()));//31
		rSquares.add(new Square(5, 2, false,new BlankTile()));//32
		rSquares.add(new Square(5, 3, false,new BlankTile()));//33
		rSquares.add(new Square(5, 4, false,new BlankTile()));//34
		rSquares.add(new Square(5, 5, true, new LetterTile("P", 4)));//35
		
		fourSquares.add(new Square(0, 0, true, new LetterTile("F", 4)));//0
		fourSquares.add(new Square(0, 1, true, new LetterTile("O", 2)));//1
		fourSquares.add(new Square(0, 2, true, randomTile()));//2
		fourSquares.add(new Square(0, 3, true, randomTile()));//3
		fourSquares.add(new Square(0, 4, true, new LetterTile("F", 4)));//4
		fourSquares.add(new Square(0, 5, true, new LetterTile("O", 2)));//5
		fourSquares.add(new Square(1, 0, true, new LetterTile("U", 3)));//6
		fourSquares.add(new Square(1, 1, true, new LetterTile("R", 2)));//7
		fourSquares.add(new Square(1, 2, true, randomTile()));//8
		fourSquares.add(new Square(1, 3, true, randomTile()));//9
		fourSquares.add(new Square(1, 4, true, new LetterTile("U", 3)));//10
		fourSquares.add(new Square(1, 5, true, new LetterTile("R", 2)));//11
		fourSquares.add(new Square(2, 0, true, randomTile()));//12
		fourSquares.add(new Square(2, 1, true, randomTile()));//13
		fourSquares.add(new Square(2, 2, false,new BlankTile()));//14
		fourSquares.add(new Square(2, 3, false,new BlankTile()));//15
		fourSquares.add(new Square(2, 4, true, randomTile()));//16
		fourSquares.add(new Square(2, 5, true, randomTile()));//17
		fourSquares.add(new Square(3, 0, true, randomTile()));//18
		fourSquares.add(new Square(3, 1, true, randomTile()));//19
		fourSquares.add(new Square(3, 2, false,new BlankTile()));//20
		fourSquares.add(new Square(3, 3, false,new BlankTile()));//21
		fourSquares.add(new Square(3, 4, true, randomTile()));//22
		fourSquares.add(new Square(3, 5, true, randomTile()));//23
		fourSquares.add(new Square(4, 0, true, new LetterTile("F", 4)));//24
		fourSquares.add(new Square(4, 1, true, new LetterTile("O", 2)));//25
		fourSquares.add(new Square(4, 2, true, randomTile()));//26
		fourSquares.add(new Square(4, 3, true, randomTile()));//27
		fourSquares.add(new Square(4, 4, true, new LetterTile("F", 4)));//28
		fourSquares.add(new Square(4, 5, true, new LetterTile("O", 2)));//29
		fourSquares.add(new Square(5, 0, true, new LetterTile("U", 3)));//30
		fourSquares.add(new Square(5, 1, true, new LetterTile("R", 2)));//31
		fourSquares.add(new Square(5, 2, true, randomTile()));//32
		fourSquares.add(new Square(5, 3, true, randomTile()));//33
		fourSquares.add(new Square(5, 4, true, new LetterTile("U", 3)));//34
		fourSquares.add(new Square(5, 5, true, new LetterTile("R", 2)));//35
		
		duneSquares.add(new Square(0, 0, true, randomTile()));//0
		duneSquares.add(new Square(0, 1, true, randomTile()));//1
		duneSquares.add(new Square(0, 2, true, new LetterTile("D", 3)));//2
		duneSquares.add(new Square(0, 3, true, randomTile()));//3
		duneSquares.add(new Square(0, 4, true, randomTile()));//4
		duneSquares.add(new Square(0, 5, true, randomTile()));//5
		duneSquares.add(new Square(1, 0, true, new LetterTile("U", 3)));//6
		duneSquares.add(new Square(1, 1, true, new LetterTile("A", 2)));//7
		duneSquares.add(new Square(1, 2, true, new LetterTile("D", 3)));//8
		duneSquares.add(new Square(1, 3, true, new LetterTile("I", 2)));//9
		duneSquares.add(new Square(1, 4, true, new LetterTile("B", 4)));//10
		duneSquares.add(new Square(1, 5, true, randomTile()));//11
		duneSquares.add(new Square(2, 0, true, new LetterTile("M", 3)));//12
		duneSquares.add(new Square(2, 1, true, new LetterTile("S", 2)));//13
		duneSquares.add(new Square(2, 2, true, new LetterTile("I", 2)));//14
		duneSquares.add(new Square(2, 3, true, new LetterTile("K", 5)));//15
		duneSquares.add(new Square(2, 4, true, new LetterTile("A", 2)));//16
		duneSquares.add(new Square(2, 5, true, new LetterTile("R", 2)));//17
		duneSquares.add(new Square(3, 0, true, new LetterTile("E", 1)));//18
		duneSquares.add(new Square(3, 1, true, new LetterTile("L", 3)));//19
		duneSquares.add(new Square(3, 2, true, new LetterTile("A", 2)));//20
		duneSquares.add(new Square(3, 3, true, new LetterTile("G", 4)));//21
		duneSquares.add(new Square(3, 4, true, new LetterTile("A", 2)));//22
		duneSquares.add(new Square(3, 5, true, new LetterTile("R", 2)));//23
		duneSquares.add(new Square(4, 0, true, new LetterTile("M", 3)));//24
		duneSquares.add(new Square(4, 1, false,new BlankTile()));//25
		duneSquares.add(new Square(4, 2, true, new LetterTile("N", 2)));//26
		duneSquares.add(new Square(4, 3, false,new BlankTile()));//27
		duneSquares.add(new Square(4, 4, true, new LetterTile("E", 1)));//28
		duneSquares.add(new Square(4, 5, false,new BlankTile()));//29
		duneSquares.add(new Square(5, 0, false,new BlankTile()));//30
		duneSquares.add(new Square(5, 1, false,new BlankTile()));//31
		duneSquares.add(new Square(5, 2, false,new BlankTile()));//32
		duneSquares.add(new Square(5, 3, false,new BlankTile()));//33
		duneSquares.add(new Square(5, 4, false,new BlankTile()));//34
		duneSquares.add(new Square(5, 5, false,new BlankTile()));//35
		
		latinSquares.add(new Square(0, 0, true, new LetterTile("C", 3)));//0
		latinSquares.add(new Square(0, 1, true, randomTile()));//1
		latinSquares.add(new Square(0, 2, true, randomTile()));//2
		latinSquares.add(new Square(0, 3, false,new BlankTile()));//3
		latinSquares.add(new Square(0, 4, true, new LetterTile("O", 2)));//4
		latinSquares.add(new Square(0, 5, true, new LetterTile("R", 2)));//5
		latinSquares.add(new Square(1, 0, true, new LetterTile("C", 3)));//6
		latinSquares.add(new Square(1, 1, true, new LetterTile("A", 2)));//7
		latinSquares.add(new Square(1, 2, false,new BlankTile()));//8
		latinSquares.add(new Square(1, 3, true, randomTile()));//9
		latinSquares.add(new Square(1, 4, true, new LetterTile("H", 2)));//10
		latinSquares.add(new Square(1, 5, true, new LetterTile("A", 2)));//11
		latinSquares.add(new Square(2, 0, true, new LetterTile("A", 2)));//12
		latinSquares.add(new Square(2, 1, true, randomTile()));//13
		latinSquares.add(new Square(2, 2, true, new LetterTile("E", 1)));//14
		latinSquares.add(new Square(2, 3, false,new BlankTile()));//15
		latinSquares.add(new Square(2, 4, true, randomTile()));//16
		latinSquares.add(new Square(2, 5, true, new LetterTile("C", 3)));//17
		latinSquares.add(new Square(3, 0, true, new LetterTile("T", 1)));//18
		latinSquares.add(new Square(3, 1, true, new LetterTile("S", 2)));//19
		latinSquares.add(new Square(3, 2, false,new BlankTile()));//20
		latinSquares.add(new Square(3, 3, true, new LetterTile("S", 2)));//21
		latinSquares.add(new Square(3, 4, true, randomTile()));//22
		latinSquares.add(new Square(3, 5, true, new LetterTile("E", 1)));//23
		latinSquares.add(new Square(4, 0, true, new LetterTile("U", 3)));//24
		latinSquares.add(new Square(4, 1, true, new LetterTile("U", 3)));//25
		latinSquares.add(new Square(4, 2, true, randomTile()));//26
		latinSquares.add(new Square(4, 3, false,new BlankTile()));//27
		latinSquares.add(new Square(4, 4, true, new LetterTile("A", 2)));//28
		latinSquares.add(new Square(4, 5, true, randomTile()));//29
		latinSquares.add(new Square(5, 0, true, new LetterTile("L", 3)));//30
		latinSquares.add(new Square(5, 1, true, new LetterTile("L", 3)));//31
		latinSquares.add(new Square(5, 2, false,new BlankTile()));//32
		latinSquares.add(new Square(5, 3, true, randomTile()));//33
		latinSquares.add(new Square(5, 4, true, randomTile()));//34
		latinSquares.add(new Square(5, 5, true, new LetterTile("R", 2)));//35
		
		Board food = new Board (foodSquares);
		Board r = new Board (rSquares);
		Board four = new Board (fourSquares);
		Board dune = new Board (duneSquares);
		Board latin = new Board (latinSquares);
		Board[] themeBoards = {food, r, four, dune, latin};
		String[] themeNames = {foodName, rName, fourName, duneName, latinName};
		ThemeDictionary[] themeDicts = {foodDic, rDic, fourDic, duneDic, latinDic};
		List<List<Tile>> themeTiles = new ArrayList<List<Tile>>(5);
		int row, col;
		for (int i = 0; i < 36; i++) {
			row = (int) Math.floor(i/6);
			col = i%6;
			
			for (int j = 0; j < 5; j++){
				themeTiles.add(new ArrayList<Tile>());
				themeTiles.get(j).add(themeBoards[j].getBoardSquares().get(i).getTile());
			}
			Tile tile = randomTile();
			Square square = new Square(row, col, true, tile);
			randomBoardSquares.add(i, square);
			
		}
		
		board = new Board(randomBoardSquares);

		for (int i = 1; i <= 5; i++) {
			this.loadIn("puzzle", i);
			
			//board.loadInBoard(squaresInPlay);
			for (int j = 0; j < 36; j++) {
				System.out.print(board.getBoardSquares().get(i).getSquareInPlay());
			}
			System.out.println("");
			puzzleLevel[i] = new PuzzleLevel(starVal, squaresInPlay, board, i, numMoves);
			this.loadIn("lightning", i);
			System.out.println("time:" + time);
			lightningLevel[i] = new LightningLevel(starVal, squaresInPlay, board, i, time);
			this.loadIn("theme", i);
			themeLevel[i] = new ThemeLevel(starVal, squaresInPlay, themeTiles.get(i-1), themeBoards[i-1], i, themeNames[i-1], themeDicts[i-1]);
			
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
/**
 * get/set
 *
 */
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
			contents.remove(0);
			contents.remove(0);
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
