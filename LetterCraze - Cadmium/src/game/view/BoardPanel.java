package game.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import game.model.Level;
import game.model.Model;

public class BoardPanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 854408960237025508L;
	
	private TilePanel tilePanel[][] = new TilePanel[6][6];
	Model m;
	/**
	 * Create the panel.
	 */
	public BoardPanel(Model model) {
		this.m = model;
		setBounds(0, 0, 254, 254);
		setBackground(new Color(119, 136, 153));
		setLayout(null);
		setBorder(new LineBorder(new Color(176, 196, 222), 6));
		
		Color darkColor = new Color(216, 191, 216);
		Color lightColor = new Color(255, 228, 225);
		
		boolean dark = true;
		for (int i = 0; i <= 5; i++) {
			dark = !dark;
			for (int j = 0; j <= 5; j++) {
				dark = !dark;
				
				if (dark)
					tilePanel[i][j] = new TilePanel(darkColor);
				else
					tilePanel[i][j] = new TilePanel(lightColor);
				tilePanel[i][j].setBounds((j*40) + 7, (i*40) + 7, 40, 40);

				add(tilePanel[i][j]);
			}
		}
		
	}

}
