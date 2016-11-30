package game.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class LevelPanel extends JPanel {
	// TODO create and include BoardPanel and constraintPanel()
	// TODO create abstract methods for setting level name, constraint panel name, constraint source, 
	// TODO (LATER) make those update functions into one refresh probably
	// TODO actually just update everything with Level when Level exists functionally
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 5365285961036238341L;

	private JLabel highScoreLabel;
	private int highScore;
	private JLabel scoreLabel;
	private JTextPane wordsTextPane;
	private JLabel starLabel;
	
	
	/**
	 * Create the panel.
	 */
	public LevelPanel() {
		setBounds(0, 0, 800, 550);
		setBackground(new Color(230, 230, 250));

		initTitle();
		initButtons();
		initHighScore();
		initScore();
		initWords();
		initStars();
	}
	/**
	 * TODO update iniTitle with actual Level model references
	 */
	public void initTitle() {
		String levType = "lightning";//Level.getLevType();
		int levNum = 6; //Level.getLevNum();
		setLayout(null);
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 110);
		titlePanel.setBackground(new Color(119, 136, 153));
		titlePanel.setLayout(null);
		add(titlePanel);
		
		JLabel titleLabel = new JLabel(levType.toUpperCase() + " " + levNum);
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 0, 800, 110);
		titleLabel.setFont(new Font("OCR A Extended", Font.BOLD, 60));
		titlePanel.add(titleLabel);
		
		//TODO: change backbutton
		JButton backButton = new JButton("");
		backButton.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/backButton.png")));
		backButton.setBounds(20, 22, 66, 66);
		titlePanel.add(backButton);
	}

	public void initButtons() {
		//TODO change reset and undo buttons
		JButton resetButton = new JButton("");
		resetButton.setBounds(615, 215, 101, 42);
		resetButton.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/reset.png")));
		add(resetButton);
		
		JButton undoButton = new JButton("");
		undoButton.setBounds(615, 272, 101, 42);
		undoButton.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/undo.png")));
		add(undoButton);
	}
	
	public void initHighScore() {
		highScore = 0;//Level.getHighScore();
		
		JPanel highScorePanel = new JPanel();
		highScorePanel.setBounds(48, 143, 184, 77);
		highScorePanel.setBackground(new Color(176, 196, 222));
		highScorePanel.setLayout(null);
		add(highScorePanel);
		
		JLabel HSLabel = new JLabel("HIGH SCORE");
		HSLabel.setBounds(0, 4, 184, 37);
		HSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		HSLabel.setForeground(Color.BLACK);
		HSLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		highScorePanel.add(HSLabel);
		
		highScoreLabel = new JLabel(Integer.toString(highScore));
		highScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		highScoreLabel.setForeground(Color.BLACK);
		highScoreLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		highScoreLabel.setBounds(0, 35, 184, 37);
		highScorePanel.add(highScoreLabel);
	}

	public void initScore() {
		
		JPanel scorePanel = new JPanel();
		scorePanel.setBounds(615, 438, 101, 77);
		scorePanel.setBackground(new Color(176, 196, 222));
		scorePanel.setLayout(null);
		add(scorePanel);
		
		JLabel SLabel = new JLabel("SCORE");
		SLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SLabel.setBounds(0, 4, 101, 37);
		SLabel.setForeground(Color.BLACK);
		SLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		scorePanel.add(SLabel);
		
		scoreLabel = new JLabel(Integer.toString(0));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setBounds(0, 35, 101, 37);
		scoreLabel.setForeground(Color.BLACK);
		scoreLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		scorePanel.add(scoreLabel);
	}
	
	public void initWords() {
		JPanel wordsPanel = new JPanel();
		wordsPanel.setBounds(48, 235, 184, 282);
		wordsPanel.setBackground(new Color(176, 196, 222));
		add(wordsPanel);
		wordsPanel.setLayout(null);
		
		JLabel WLabel = new JLabel("WORDS");
		WLabel.setBounds(0, 4, 184, 37);
		WLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WLabel.setForeground(Color.BLACK);
		WLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		wordsPanel.add(WLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(21, 52, 142, 208);
		wordsPanel.add(scrollPane);
		
		wordsTextPane = new JTextPane();
		wordsTextPane.setEditable(false);
		wordsTextPane.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		wordsTextPane.setBackground(new Color(176, 196, 222));
		StyledDocument doc = wordsTextPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		wordsTextPane.setText("");
		scrollPane.setViewportView(wordsTextPane);
		
	}

	public void initStars() {
		starLabel = new JLabel();
		starLabel.setBounds(574, 138, 183, 62);
		starLabel.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/0GameStars.png")));
		add(starLabel);
	}
	
	public void updateHighScore() {
		highScore = 5; //Level.getHighScore();
		highScoreLabel.setText(Integer.toString(highScore));
	}
	public void updateScore() {
		int score = 5; //Level.getScore();
		scoreLabel.setText(Integer.toString(score));
	}
	public void updateWords() {
		String wordListString = "";
		String wordList[] = {"this", "is", "a", "series", "of", "example", "words"};//Level.getWordList();
		for (int numWords = 0; numWords < wordList.length; numWords++) {
			wordListString = wordListString + wordList[numWords] + "\n";
		}
		wordsTextPane.setText(wordListString);
	}
	public void updateStars() {
		int maxStarsAchieved = 2;//Level.getMaxStarsAchieved();
		starLabel.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/" + maxStarsAchieved + "GameStars.png")));
	}
}
