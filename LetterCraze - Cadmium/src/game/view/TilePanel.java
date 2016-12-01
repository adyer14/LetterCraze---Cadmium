package game.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TilePanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -872998560741757223L;

	/**
	 * Create the panel.
	 */
	public TilePanel(Color color) {
		setBounds(0, 0, 40, 40);
		setBackground(color);
		setLayout(null);
		
		JButton tileButton = new JButton();
		tileButton.setBounds(5, 5, 30, 30);
		tileButton.setBackground(color);
		add(tileButton);
		
	}
}
