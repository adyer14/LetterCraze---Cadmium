package builder.model;

public class Board {
	
	Square[] squares = new Square[36];
	BlankTile blank;
	
	public Board () {
		int k = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
			squares [k] = new Square(i, j, true, blank);
			k++;
			}
		}
	}

}
