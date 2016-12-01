package game.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import game.model.Level;
import game.model.Model;

public class BoardPanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 854408960237025508L;
	
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
		
	}

}
