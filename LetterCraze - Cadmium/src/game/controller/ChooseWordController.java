package game.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

import game.model.LetterTile;
import game.model.Level;
import game.model.Square;
import game.model.Word;
import game.view.BoardPanel;
import game.view.TilePanel;

public class ChooseWordController implements MouseListener {

	Level level;
	BoardPanel bp;
	Word wordBeingCreated;
	ArrayList<Square> squaresBeingSelected = new ArrayList<Square>();
	private boolean isWordBeingCreated = false;
	
	public ChooseWordController(/*Level l, */BoardPanel bp){
		//this.level = l;
		this.bp = bp;
		wordBeingCreated = new Word(squaresBeingSelected);
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// set flag, can start capturing values of tiles
		isWordBeingCreated = true;
		
		// update graphics
		JButton selectedButton = (JButton) arg0.getSource();
		TilePanel tp = (TilePanel)selectedButton.getParent();
		tp.setSelected();
		
		squaresBeingSelected.add(tp.getSquare());
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		// update graphics
		JButton selectedButton = (JButton) arg0.getSource();
		TilePanel tp = (TilePanel)selectedButton.getParent();
		
		if (isWordBeingCreated) {
			tp.setSelected();

			if (!squaresBeingSelected.contains(tp.getSquare()))
				squaresBeingSelected.add(tp.getSquare());

		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//finish word hand off to check word
		isWordBeingCreated = false;
		wordBeingCreated.setSelectedSquares(squaresBeingSelected);
		wordBeingCreated.makeString();
		System.out.println(wordBeingCreated.getActualString());

		// reset graphics
		bp.resetTiles();	
		
		squaresBeingSelected.clear();
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// keep the button selected after exiting container
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
