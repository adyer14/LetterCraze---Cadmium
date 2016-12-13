package game.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import game.model.LightningLevel;
import game.model.Model;

public class LightningPanel extends LevelPanel{
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -7930599956477748320L;
	
	Model m;
	private JLabel timeLabel;
	private int timeLeft;
	
	/**
	 * Create the panel.
	 */
	public LightningPanel(Model model, JPanel panel, LightningLevel level, LevelSelectPanel lsp) {
		super(model, panel, level, lsp);
		int levNum = level.getLevelNumber();
		titleLabel.setText("LIGHTNING" + " " + levNum);
		titlePanel.add(titleLabel);
		
		// TODO this probably need to get linked to timer somehow?
		timeLeft = level.getTime();
		
		JLabel tLabel = new JLabel("TIMER");
		tLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tLabel.setBounds(0, 4, 101, 37);
		tLabel.setForeground(Color.BLACK);
		tLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(tLabel);
		
		timeLabel = new JLabel(Integer.toString(timeLeft));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(0, 35, 101, 37);
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(timeLabel);
	}
	
	@Override
	public void refresh() {
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
