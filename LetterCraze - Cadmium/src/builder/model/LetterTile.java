package builder.model;
/**
 * A Tile with a letter and score value
 * 
 *
 */
public class LetterTile extends Tile{

		String letter;
		int scoreValue;
		/**
		 * Constructor
		 * @param s The letter on the Tile
		 * @param sv The value of the Tile
		 */
		public LetterTile(String s, int sv){
			this.letter = s;
			this.scoreValue = sv;
		}
}
