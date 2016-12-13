package game.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import game.view.BoardPanel;
import game.controller.ExitLevelController;
import game.model.Board;
import game.model.Level;
import game.model.Model;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public abstract class LevelPanel extends JPanel {
	
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 5365285961036238341L;

	protected JLabel highScoreLabel;
	protected int highScore;
	protected JLabel scoreLabel;
	protected JTextPane wordsTextPane;
	protected JLabel starLabel;
	private JPanel contentPane;
	private JButton resetButton;
	private JButton undoButton;
	private JButton backButton;
	private Model model;
	private BoardPanel boardPanel;
	protected Level level;
	protected JPanel constraintPanel;
	protected JPanel titlePanel;
	protected JLabel titleLabel;
	private LevelSelectPanel lsp;
	
	/**
	 * Create the panel.
	 */
	public LevelPanel(Model model, JPanel panel, Level lvl, LevelSelectPanel lsp) {
		this.contentPane = panel;
		this.model = model;
		this.level = lvl;
		this.lsp = lsp;
		setBounds(0, 0, 800, 550);
		setBackground(new Color(230, 230, 250));
		setLayout(null);

		initTitle();
		initButtons();
		initHighScore();
		initScore();
		initWords();
		initStars();
		initControllers();
		initConstraint();
		
		Board board = level.getBoard();
		boardPanel = new BoardPanel(model, board);
		boardPanel.setBounds(297, 203, 254, 254);
		add(boardPanel);
	}
	
	public void initTitle() {
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 110);
		titlePanel.setBackground(new Color(119, 136, 153));
		titlePanel.setLayout(null);
		add(titlePanel);
		
		titleLabel = new JLabel("");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 0, 800, 110);
		titleLabel.setFont(new Font("OCR A Extended", Font.BOLD, 60));
		titlePanel.add(titleLabel);
		
		backButton = new JButton("");
		backButton.setSelectedIcon(new ImageIcon(LevelPanel.class.getResource("/images/backSelected.png")));
		backButton.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/backButton.png")));
		backButton.setRolloverIcon(new ImageIcon(LevelPanel.class.getResource("/images/backSelected.png")));
		backButton.setBounds(20, 22, 66, 66);
		backButton.setFocusPainted(false);
		backButton.setBorder(null);
		titlePanel.add(backButton);
	}

	public void initButtons() {
		resetButton = new JButton("RESET");
		resetButton.setBounds(615, 215, 101, 42);
		resetButton.setFont(new Font("OCR A Extended", Font.BOLD, 23));
		resetButton.setForeground(new Color(0, 0, 0));
		resetButton.setBackground(new Color(176, 196, 222));
		resetButton.setBorder(new LineBorder(new Color(119, 136, 153), 3));
		resetButton.setFocusPainted(false);
		add(resetButton);
		
		undoButton = new JButton("UNDO");
		undoButton.setBounds(615, 272, 101, 42);
		undoButton.setFont(new Font("OCR A Extended", Font.BOLD, 23));
		undoButton.setForeground(new Color(0, 0, 0));
		undoButton.setBackground(new Color(176, 196, 222));
		undoButton.setBorder(new LineBorder(new Color(119, 136, 153), 3));
		undoButton.setFocusPainted(false);
		add(undoButton);
	}
	
	public void initConstraint() {
		constraintPanel = new JPanel();
		constraintPanel.setBounds(615, 348, 101, 77);
		constraintPanel.setBackground(new Color(176, 196, 222));
		constraintPanel.setLayout(null);
		add(constraintPanel);
	}
	
	public void initHighScore() {
		highScore = level.getHighScore();
		
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
	
	public void initControllers() {
		ExitLevelController elcontrol = new ExitLevelController(model, level, this, lsp);
		backButton.addActionListener(elcontrol);
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JPanel getConstraintPanel() {
		return constraintPanel;
	}
	
	public JPanel getTitlePanel() {
		return titlePanel;
	}
	
	public JLabel getTitleLabel() {
		return titleLabel;
	}
	
	public abstract void refresh();

}
