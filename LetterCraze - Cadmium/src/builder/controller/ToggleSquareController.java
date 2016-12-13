package builder.controller;

import builder.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToggleSquareController implements ActionListener {
	Board board;
	int buttonNumber;
	
	public ToggleSquareController(Board board, int buttonNumber){
		this.board = board;
		this.buttonNumber = buttonNumber;
	}
	
	public void actionPerformed(ActionEvent ae){

		board.toggleSquare(buttonNumber);
		
	}
	
	
}
