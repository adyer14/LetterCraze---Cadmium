package game.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import game.model.Model;
import game.model.ThemeLevel;

public class ThemePanel extends LevelPanel{
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 6784567307261293313L;
	
	Model m;
	private JLabel wordsLeftLabel;
	private int wordsLeft;
	
	/**
	 * Create the panel.
	 */
	public ThemePanel(Model model, JPanel panel, ThemeLevel level, LevelSelectPanel lsp) {
		super(model, panel, level, lsp);
		int levNum = level.getLevelNumber();
		String themeName = level.getThemeName();
		titleLabel.setText("THEME" + " " + levNum);
		titlePanel.add(titleLabel);
		
		wordsLeft = level.getWordsLeft();
				
		JLabel themeLabel = new JLabel(themeName);
		themeLabel.setForeground(Color.BLACK);
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		themeLabel.setBounds(297, 150, 254, 35);
		add(themeLabel);
		
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
	
	@Override
	public void refresh() {
		wordsLeft = ((ThemeLevel) level).getWordsLeft();
		wordsLeftLabel.setText(Integer.toString(wordsLeft));
		
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
