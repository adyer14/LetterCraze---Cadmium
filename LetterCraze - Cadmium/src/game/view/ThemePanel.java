package game.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.model.Level;
import game.model.Model;

public class ThemePanel extends LevelPanel{
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 6784567307261293313L;

	// TODO add in theme level name 
	
	Model m;
	private JLabel wordsLeftLabel;
	private int wordsLeft;
	/**
	 * Create the panel.
	 */
	public ThemePanel(Model model, JPanel panel) {//, PuzzleLevel model) {
		super(model, panel);
		
		wordsLeft = 0;//Level.getHighScore();
		
		JLabel wLabel = new JLabel("WORDS");
		wLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wLabel.setBounds(0, 4, 101, 37);
		wLabel.setForeground(Color.BLACK);
		wLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(wLabel);
		
		wordsLeftLabel = new JLabel(Integer.toString(wordsLeft));
		wordsLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordsLeftLabel.setBounds(0, 35, 101, 37);
		wordsLeftLabel.setForeground(Color.BLACK);
		wordsLeftLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(wordsLeftLabel);
	}

}
