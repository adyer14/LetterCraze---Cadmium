package game.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import game.controller.ChooseWordController;
import game.model.LetterTile;
import game.model.Tile;
import java.awt.Font;

public class TilePanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -872998560741757223L;

	private Tile tile;
	private JButton tileButton;
	private String letter;
	private Color unselectedColor;
	private Color letterSelected = new Color(51, 0, 0);
	private Color selectedColor = new Color(255, 153, 153);
	
	/**
	 * Create the panel.
	 */
	public TilePanel(Tile t, Color color, ChooseWordController controller) {
		this.tile = t;
		this.unselectedColor = color;
		if (tile instanceof LetterTile) {
			this.letter = ((LetterTile)tile).getLetter();
		}
		
		setBounds(0, 0, 40, 40);
		setBackground(unselectedColor);
		setLayout(null);
		
		tileButton = new JButton();
		tileButton.setText(letter);
		tileButton.setFont(new Font("OCR A Extended", Font.PLAIN, 30));
		tileButton.setBounds(5, 5, 30, 30);
		tileButton.setBackground(color);
		tileButton.setBorder(null);
		tileButton.setFocusPainted(false);
		tileButton.setContentAreaFilled(false);
		tileButton.addMouseListener(controller);
		
		add(tileButton);
	}
	
	public void setSelected() {
		tileButton.setBackground(selectedColor);
		this.setBackground(selectedColor);
		tileButton.setForeground(letterSelected);
	}
	
	public void resetColors() {
		tileButton.setBackground(unselectedColor);
		this.setBackground(unselectedColor);
		tileButton.setForeground(null);
	}
}
