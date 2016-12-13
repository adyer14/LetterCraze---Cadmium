package game.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import game.model.Model;
import game.model.PuzzleLevel;

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
	public PuzzlePanel(Model model, JPanel panel, PuzzleLevel level, LevelSelectPanel lsp) {
		super(model, panel, level, lsp);
		int levNum = level.getLevelNumber();
		titleLabel.setText("PUZZLE" + " " + levNum);
		titlePanel.add(titleLabel);
		
		movesLeft = level.getMovesLeft();
		
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
	
	@Override
	public void refresh() {
		movesLeft = ((PuzzleLevel) level).getMovesLeft();
		movesLabel.setText(Integer.toString(movesLeft));
		
		highScore = level.getHighScore();
		highScoreLabel.setText(Integer.toString(highScore));
		
		int score = level.getScore();
		scoreLabel.setText(Integer.toString(score));
		
		int mostStars = level.getMostStars();
		starLabel.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/" + mostStars + "GameStars.png")));
		
		String wordListString = "";
		for (int numWords = 0; numWords < level.getWordList().size(); numWords++) {
			wordListString = wordListString + level.getWordList().get(numWords).getActualString() + "\n";
			wordsTextPane.setText(wordListString);
		}
	}


}
