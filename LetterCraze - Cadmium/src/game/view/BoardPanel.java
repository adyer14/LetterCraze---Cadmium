package game.view;

import java.awt.Color;

import javax.swing.JPanel;

import game.controller.ChooseWordController;
import game.model.Board;
import game.model.Model;
import game.model.Tile;

public class BoardPanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 854408960237025508L;
	
	private TilePanel tilePanel[] = new TilePanel[36];
	Model m;
	Board board;
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(Model model, Board b) {
		this.m = model;
		this.board = b;
		
		setBounds(0, 0, 254, 254);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		initTiles();
	}
	
	public void initTiles() {
		
		// create controller for choosing words
		ChooseWordController CWcontrol = new ChooseWordController(this);

		Color darkColor = new Color(216, 191, 216);
		Color lightColor = new Color(255, 228, 225);
		boolean dark = true;
		int row, col;
		
		// create and add the TilePanels with alternating colors
		for (int i = 0; i < 36; i++) {
			
			// TODO HACK until we get board and square and tile working 
			// TODO DELETE
			// Tile tile = board.getBoardSquareByIndex(i).getTile();
			Tile tile = new Tile();
			
			
			row = (int) Math.floor(i/6);
			col = i%6;
			if (col == 0)
					dark = !dark;
			if (dark) {
				tilePanel[i] = new TilePanel(tile, darkColor, CWcontrol);
				dark = !dark;
			}
			else {		
				tilePanel[i] = new TilePanel(tile, lightColor, CWcontrol);
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
