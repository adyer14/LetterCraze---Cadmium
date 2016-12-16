package game.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import game.controller.ChooseWordController;
import game.model.LetterTile;
import game.model.Square;
import game.model.Tile;
import java.awt.Font;

public class TilePanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -872998560741757223L;

	private Square square;
	private Tile tile;
	private JButton tileButton;
	private String letter;
	private Color unselectedColor;
	private Color letterSelected = new Color(51, 0, 0);
	private Color selectedColor = new Color(255, 153, 153);
	private ChooseWordController CWControl;
	
	//TODO Change font size
	/**
	 * Create the panel.
	 */
	public TilePanel(Square s, Color color, ChooseWordController controller) {
		this.square = s;
		this.unselectedColor = color;
		this.CWControl = controller;
		this.tile = square.getTile();
		if (tile instanceof LetterTile) {
			this.letter = ((LetterTile)tile).getLetter();
		}
		
		setBounds(0, 0, 40, 40);
		setBackground(unselectedColor);
		setLayout(null);
		
		tileButton = new JButton();
		tileButton.setText(letter);
		int font;
		if (this.letter == "Qu")
			font = 25;
		else
			font = 30;
		tileButton.setFont(new Font("OCR A Extended", Font.PLAIN, font));
		tileButton.setBounds(5, 5, 30, 30);
		tileButton.setBackground(color);
		tileButton.setBorder(null);
		tileButton.setFocusPainted(false);
		tileButton.setContentAreaFilled(false);
		tileButton.addMouseListener(CWControl);
		
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

	public void refresh(Square sq) {
		this.square = sq;
		this.tile = square.getTile();
		if (tile instanceof LetterTile) {
			this.letter = ((LetterTile)tile).getLetter();
		}
		else
			this.letter = "";
		tileButton.setText(letter);
		int font;
		if (this.letter == "Qu") {
			font = 25;
		}
		else
			font = 30;
		tileButton.setFont(new Font("OCR A Extended", Font.PLAIN, font));
	}
/**
 * get/set
 * 
 */
	public Square getSquare() {
		return square;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	public JButton getTileButton() {
		return tileButton;
	}
	
	public String getLetter() {
		return letter;
	}

	public ChooseWordController getCWControl() {
		return CWControl;
	}
}
