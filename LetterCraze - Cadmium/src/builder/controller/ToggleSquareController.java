package builder.controller;

import builder.view.*;
import builder.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class ToggleSquareController implements ActionListener {
	Board board;
	BoardPanel boardView;
	
	public ToggleSquareController(Board board, BoardPanel boardView){
		this.board = board;
		this.boardView = boardView;
	}
	
	public void actionPerformed(ActionEvent ae){

		JToggleButton tb = (JToggleButton) ae.getSource();
		
		
	}
	
	
}
