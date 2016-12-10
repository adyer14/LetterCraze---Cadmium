package builder.controller;

import builder.view.*;
import builder.model.*;

public class ToggleSquareController {
	Board board;
	BoardPanel boardView;
	
	public ToggleSquareController(Board board, BoardPanel boardView){
		this.board = board;
		this.boardView = boardView;
	}
}
