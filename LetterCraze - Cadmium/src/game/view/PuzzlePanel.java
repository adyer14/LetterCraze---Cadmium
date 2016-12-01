package game.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.model.Level;
import game.model.Model;

public class PuzzlePanel extends LevelPanel{

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -2099720612660676023L;

	
	Model m;

	private JLabel movesLabel;
	private int movesLeft;
	
	/**
	 * Create the panel.
	 */
	public PuzzlePanel(Model model, JPanel panel) {//, PuzzleLevel model) {
		super(model, panel);
		
		movesLeft = 0;//Level.getHighScore();
		
		JLabel mLabel = new JLabel("MOVES");
		mLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mLabel.setBounds(0, 4, 101, 37);
		mLabel.setForeground(Color.BLACK);
		mLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(mLabel);
		
		movesLabel = new JLabel(Integer.toString(movesLeft));
		movesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movesLabel.setBounds(0, 35, 101, 37);
		movesLabel.setForeground(Color.BLACK);
		movesLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(movesLabel);
	}


}
