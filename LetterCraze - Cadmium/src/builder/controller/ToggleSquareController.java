package builder.controller;

import builder.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller to toggle a square, from in play to not in play or vice versa.
 *
 */
public class ToggleSquareController implements ActionListener {
	Board board;
	int buttonNumber;
	
	public ToggleSquareController(Board board, int buttonNumber){
		this.board = board;
		this.buttonNumber = buttonNumber;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		board.toggleSquare(buttonNumber);
	}
	
	public void setBoard(Board b) {
		this.board = b;
	}
	
}
