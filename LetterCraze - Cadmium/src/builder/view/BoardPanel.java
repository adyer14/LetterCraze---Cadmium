package builder.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import builder.model.*;
import builder.controller.*;

public class BoardPanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -3425682784245190630L;

	private JToggleButton squareButton[]= new JToggleButton[36];
	private Board board;
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(Board board) {
		this.board = board;
		setBounds(0, 0, 254, 254);
		setBackground(new Color(119, 136, 153));
		setLayout(null);
		setBorder(new LineBorder(new Color(176, 196, 222), 6));

		boolean dark = true;
		int row, col;
		
		for (int i = 0; i < 36; i++) {
			row = (int) Math.floor(i/6);
			col = i%6;

			squareButton[i] = new JToggleButton("");
			squareButton[i].setIcon(new ImageIcon(BoardPanel.class.getResource("/images/squareUnselected.png")));
			squareButton[i].setBounds((col*40) + 7, (row*40) + 7, 40, 40);
			
			ToggleSquareController tsc = new ToggleSquareController(board, i);
			squareButton[i].addActionListener(tsc);
			
			if (col == 0)
				dark = !dark;
			if (dark) {
				squareButton[i].setSelectedIcon(new ImageIcon(BoardPanel.class.getResource("/images/squareSelectedDark.png")));
				dark = !dark;
			}
			else {		
				squareButton[i].setSelectedIcon(new ImageIcon(BoardPanel.class.getResource("/images/squareSelectedLight.png")));
				
				dark = !dark;
			}
			add(squareButton[i]);

		}
	}

	public void reset() {
		for (int i = 0; i < 36; i++) {
			squareButton[i].setSelected(false);
		}
		board.resetSquares();
		System.out.println("The Board has been reset.");
	}

	public JToggleButton getSquare(int i) {
		return squareButton[i];
	}

}
