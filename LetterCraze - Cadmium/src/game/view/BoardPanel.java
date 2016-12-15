package game.view;

import java.awt.Color;
import javax.swing.JPanel;
import game.controller.ChooseWordController;
import game.model.Board;
import game.model.Model;
import game.model.Square;

public class BoardPanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 854408960237025508L;
	
	private TilePanel tilePanel[] = new TilePanel[36];
	Model m;
	String levType;
	int levNum;
	Board board;
	ChooseWordController CWControl;
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(Model model, String levType, int levNum, ChooseWordController CWcontrol) {
		this.m = model;
		this.levNum = levNum;
		this.levType = levType;
		this.board = m.getSpecificLevel(levType, levNum).getBoard();
		this.CWControl = CWcontrol;
		
		setBounds(0, 0, 254, 254);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
	
		initTiles();
	}
	
	public void initTiles() {
		this.board = m.getSpecificLevel(levType, levNum).getBoard();
		Color darkColor = new Color(216, 191, 216);
		Color lightColor = new Color(255, 228, 225);
		boolean dark = true;
		int row, col;
		
		// create and add the TilePanels with alternating colors
		for (int i = 0; i < 36; i++) {
			
			row = (int) Math.floor(i/6);
			col = i%6;
			
			Square square = board.getBoardSquares().get(i);
			
			if (col == 0)
					dark = !dark;
			if (dark) {
				tilePanel[i] = new TilePanel(square, darkColor, CWControl);
				dark = !dark;
			}
			else {		
				tilePanel[i] = new TilePanel(square, lightColor, CWControl);
				dark = !dark;
			}
			
			tilePanel[i].setBounds((col*40) + 7, (row*40) + 7, 40, 40);
			add(tilePanel[i]);
		}
	}
	
	public void refresh() {
		this.board = m.getSpecificLevel(levType, levNum).getBoard();
		for (int i = 0; i < 36; i++) {
			tilePanel[i].refresh(board.getBoardSquares().get(i));
		}
	}

	public void turnOffBoard() {
		//CWControl.getPressedTP().setIgnoreRepaint(true);
		for (int i = 0; i < 36; i++) {
			tilePanel[i].getTileButton().setEnabled(false);
			tilePanel[i].getTileButton().removeMouseListener(tilePanel[i].getCWControl());
		}
	}
	
	public void reseTileColors() {
		for (int i = 0; i < 36; i++) {
			tilePanel[i].resetColors();
		}
	}
	
	public void resetBoard() {
		for (int i = 0; i < 36; i++) {
			tilePanel[i].getTileButton().setEnabled(true);
			tilePanel[i].getTileButton().addMouseListener(tilePanel[i].getCWControl());
			tilePanel[i].resetColors();
		}
		
	}
	
	public ChooseWordController getCWControl(){
		return CWControl;
	}
	
	public void setBoard(Board b) {
		
	}
}
