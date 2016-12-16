package builder.model;
/**
 *This is the board where the squares can be made active or inactive 
 *
 *
 */
public class Board {
	
	Square[] squares = new Square[36];
	BlankTile blank;
	/**
	 * Constructor for blank board
	 */
	public Board () {
		int k = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
			squares [k] = new Square(i, j, false, blank);
			k++;
			}
		}
	}
	/**
	 * Constructor for a populated board
	 * @param sqs 
	 */
	public Board(String sqs) {
		int k = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(sqs.substring(0,1).equals("0")){
					squares[k] = new Square(i,j,false,blank);
					k++;
					sqs = sqs.substring(1);
				}else{
					squares[k] = new Square(i,j,true,blank);
					k++;
					sqs = sqs.substring(1);
				}
			}
		}
	}
/**
 * Change a square from active to inactive or vice versa
 * @param buttonNumber
 */
	public void toggleSquare(int buttonNumber) {
		this.squares[buttonNumber].toggleInPlay();
	}
/**
 * resets all squares to inactive
 */
	public void resetSquares() {
		for(int i = 0; i < 36; i++){
			if(squares[i].getSquareInPlay()){
				squares[i].toggleInPlay();
			}
		}
		
	}

	public String toString(){
		String out ="";
		int k = 0;
		for(int i = 0; i < 6;i++){
			for(int j = 0; j < 6; j++){
				if(this.squares[k].getSquareInPlay()){
					out = out + 1;
					k++;
				}else{
					out = out + 0;
					k++;
				}
			}
			
		}
		return out;
	}
	
	public Square getSquare(int i){
		return squares[i];
	}

}
