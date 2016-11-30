package builder.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

public class BoardPanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -3425682784245190630L;

	private JToggleButton squareButton[][] = new JToggleButton[6][6];
	
	/**
	 * Create the panel.
	 */
	public BoardPanel() {
		setBounds(0, 0, 254, 254);
		setBackground(new Color(119, 136, 153));
		setLayout(null);
		setBorder(new LineBorder(new Color(176, 196, 222), 6));

		boolean dark = true;
		for (int i = 0; i <= 5; i++) {
			dark = !dark;
			for (int j = 0; j <= 5; j++) {
				dark = !dark;
				squareButton[i][j] = new JToggleButton("");
				squareButton[i][j].setIcon(new ImageIcon(BoardPanel.class.getResource("/images/squareUnselected.png")));
				squareButton[i][j].setBounds((j*40) + 7, (i*40) + 7, 40, 40);
				if (dark)
					squareButton[i][j].setSelectedIcon(new ImageIcon(BoardPanel.class.getResource("/images/squareSelectedDark.png")));
				else
					squareButton[i][j].setSelectedIcon(new ImageIcon(BoardPanel.class.getResource("/images/squareSelectedLight.png")));
				add(squareButton[i][j]);
			}
		}
	}

}
