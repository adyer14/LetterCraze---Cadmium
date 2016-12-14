package builder.model;

public class Board {
	
	Square[] squares = new Square[36];
	BlankTile blank;
	 
	public Board () {
		int k = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
			squares [k] = new Square(i, j, false, blank);
			k++;
			}
		}
	}

	public void toggleSquare(int buttonNumber) {
		squares[buttonNumber].toggleInPlay();
		System.out.println("The square number " + buttonNumber + " is " + squares[buttonNumber].getSquareInPlay() +" for inPlay.");
	}

	public void resetSquares() {
		for(int i = 0; i < 36; i++){
			if(squares[i].getSquareInPlay()){
				squares[i].toggleInPlay();
			}
		}
		
	}
	
	public String toString(){
		String out ="";
		for(int i = 0; i < 36;i++){
			if(squares[i].squareInPlay){
				out = out + 1;
			}else{
				out = out + 0;
			}
		}
		return out;
	}

}
