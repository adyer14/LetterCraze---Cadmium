package game.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class LevelPanel extends JPanel {
	// TODO make an update function for changing variables
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 5365285961036238341L;

	private JLabel highScoreLabel;
	private JLabel scoreLabel;
	private JTextArea wordsTextArea;
	
	/**
	 * Create the panel.
	 */
	public LevelPanel() {
		setLayout(null);
		setBounds(0, 0, 800, 550);
		setBackground(new Color(230, 230, 250));

		initTitle();
		initButtons();
		initHighScore();
		initScore();
		initWords();
	}
	
	public void initTitle() {
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 110);
		titlePanel.setBackground(new Color(119, 136, 153));
		titlePanel.setLayout(null);
		add(titlePanel);
		
		JLabel titleLabel = new JLabel("LEVEL 1");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 0, 800, 110);
		titleLabel.setFont(new Font("OCR A Extended", Font.BOLD, 60));
		titlePanel.add(titleLabel);
		
		JButton backButton = new JButton("");
		backButton.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/backButton.png")));
		backButton.setBounds(20, 22, 66, 66);
		titlePanel.add(backButton);
	}

	public void initButtons() {
		JButton resetButton = new JButton("");
		resetButton.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/reset.png")));
		resetButton.setBounds(615, 215, 101, 42);
		add(resetButton);
		
		JButton undoButton = new JButton("");
		undoButton.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/undo.png")));
		undoButton.setBounds(615, 272, 101, 42);
		add(undoButton);
	}
	
	public void initHighScore() {
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
		
		highScoreLabel = new JLabel(Integer.toString(0));
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
		
		//TODO make this textarea scrollable
		wordsTextArea = new JTextArea();
		wordsTextArea.setColumns(2);
		wordsTextArea.setBounds(10, 41, 164, 230);
		wordsTextArea.setBackground(new Color(176, 196, 222));
		wordsPanel.add(wordsTextArea);
		
	}
}
