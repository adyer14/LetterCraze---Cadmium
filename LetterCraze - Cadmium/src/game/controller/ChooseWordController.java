package game.controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import game.model.LetterTile;
import game.model.Level;
import game.model.Move;
import game.model.Square;
import game.model.Word;
import game.undo.UndoManager;
import game.view.LevelPanel;
import game.view.TilePanel;
import game.view.ScoreMessagePanel;
/**
 * The Controller in charge of creating a word out of the tiles contained in the squares that have been hovered over
 * by the mouse.
 * 
 *
 */
public class ChooseWordController implements MouseListener {

	Level level;
	LevelPanel lp;
	Word wordBeingCreated;
	ArrayList<Square> squaresBeingSelected = new ArrayList<Square>();
	private boolean isWordBeingCreated = false;
/**
 * Constructor
 * @param l the active level
 * @param lp the panel of the active level
 */
	public ChooseWordController(Level l, LevelPanel lp){
		this.level = l;
		this.lp = lp;
	}
/**
 * When mouse is pressed a word is being created
 * It calls to the container to get the letter and adds it to a string
 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() instanceof ScoreMessagePanel) {}
		else {

			// set flag, can start capturing values of tiles
			isWordBeingCreated = true;
			wordBeingCreated = new Word(squaresBeingSelected);

			// update graphics
			JButton selectedButton = (JButton) arg0.getSource();
			TilePanel tp = (TilePanel)selectedButton.getParent();

			tp.setSelected();

			// add the square that was pressed
			if (tp.getSquare().getTile() instanceof LetterTile)
				squaresBeingSelected.add(tp.getSquare());
			System.out.println(tp.getLetter());
		}
	}
/**
 * If a word is being created then the letter from a tile is collected when the
 * mouse enters a square
 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() instanceof ScoreMessagePanel) {
			mouseReleased(arg0);
		}
		else {
			// update graphics
			JButton selectedButton = (JButton) arg0.getSource();
			TilePanel tp = (TilePanel)selectedButton.getParent();


			if (isWordBeingCreated) {
				tp.setSelected();

				if (!squaresBeingSelected.contains(tp.getSquare()) && 
						tp.getSquare().getTile() instanceof LetterTile)
					squaresBeingSelected.add(tp.getSquare());

			}
		}

	}
/**
 * mouse is released and collects the final letter to add to the word being made
 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		wordBeingCreated.setSelectedSquares(squaresBeingSelected);
		
		isWordBeingCreated = false;
		lp.refresh();
		lp.repaint();
		
		if (arg0.getSource() instanceof ScoreMessagePanel)
			((Component) arg0.getSource()).repaint();
		else {
			//finish word hand off to check word
			lp.getBoardPanel().resetTileColors();
			wordBeingCreated.makeString();
			Move move = new Move(wordBeingCreated, level);
			// request move
			if (move.doMove()) {
				UndoManager.instance().recordMove(move);
				lp.refresh();
			}
		}
		squaresBeingSelected.clear();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
