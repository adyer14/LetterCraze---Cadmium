package game.view;

import java.awt.Color;

import javax.swing.JPanel;

import game.controller.ChooseWordController;
import game.model.Board;
import game.model.LetterTile;
import game.model.Model;
import game.model.Square;
import game.model.Tile;

public class BoardPanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 854408960237025508L;
	
	private TilePanel tilePanel[] = new TilePanel[36];
	Model m;
	Board board;
	ChooseWordController CWcontrol;
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(Model model, Board b) {
		this.m = model;
		this.board = b;
		
		setBounds(0, 0, 254, 254);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		// create controller for choosing words
		CWcontrol = new ChooseWordController(this);
		initTiles();
	}
	
	public void initTiles() {
		
		Color darkColor = new Color(216, 191, 216);
		Color lightColor = new Color(255, 228, 225);
		boolean dark = true;
		int row, col;
		
		// create and add the TilePanels with alternating colors
		for (int i = 0; i < 36; i++) {
			
			row = (int) Math.floor(i/6);
			col = i%6;
			
			Square square = board.getBoardSquares().get(i);
			// TODO HACK super duper looper nooper pooper hackz
			Tile tile1 = new LetterTile("N", 69);
			Tile tile2 = new LetterTile("O", 420);
			
			
			if (col == 0)
					dark = !dark;
			if (dark) {
				// TODO HACK hackz continued
				square.setTile(tile1);
				tilePanel[i] = new TilePanel(square, darkColor, CWcontrol);
				dark = !dark;
			}
			else {		
				// TODO HACK hackz continued
				square.setTile(tile2);
				tilePanel[i] = new TilePanel(square, lightColor, CWcontrol);
				dark = !dark;
			}
			
			tilePanel[i].setBounds((col*40) + 7, (row*40) + 7, 40, 40);
			add(tilePanel[i]);
		}
	}
	
	public void resetTiles() {
		for (int i = 0; i < 36; i++) {
			tilePanel[i].resetColors();
		}
	}

}
