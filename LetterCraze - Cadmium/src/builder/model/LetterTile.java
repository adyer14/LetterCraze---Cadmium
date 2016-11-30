package builder.model;

public class LetterTile extends Tile{

		String letter;
		int scoreValue;
		
		public LetterTile(String s, int sv){
			this.letter = s;
			this.scoreValue = sv;
		}
}
