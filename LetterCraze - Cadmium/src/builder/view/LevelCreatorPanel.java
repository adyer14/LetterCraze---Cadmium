package builder.view;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import builder.controller.*;
import builder.model.*;
import javax.swing.JFormattedTextField;


public class LevelCreatorPanel extends JPanel {
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 5512267083227412445L;
	
	private BoardPanel boardPanel;
	private JFormattedTextField star1TextField;
	private JFormattedTextField star2TextField;
	private JFormattedTextField star3TextField;
	private JFormattedTextField movesTextField;
	private JFormattedTextField timeTextField;
	private JComboBox<String> levelNumCB;
	private JComboBox<String> levelTypeCB;
	private JTextField themeNameTextField;
	private JTextPane themeWordsTextPane;
	private JButton backButton;
	private JButton resetButton;
	private JButton saveButton;
	private JPanel contentPane;
	
	private Level level;
	/**
	 * Create the panel.
	 */
	public LevelCreatorPanel(JPanel panel, Level level) {
		this.level = level;
		
		contentPane = panel;
		setBounds(0, 0, 800, 550);
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		initInputPanels();
		initTitlePanel();
		initBoard();
		
		initControllers();
		
	}

	public void initTitlePanel() {
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(119, 136, 153));
		titlePanel.setBounds(0, 0, 800, 110);
		titlePanel.setLayout(null);
		add(titlePanel);
		
		backButton = new JButton("");
		backButton.setForeground(new Color(119, 136, 153));
		backButton.setBackground(new Color(119, 136, 153));
		backButton.setIcon(new ImageIcon(LevelCreatorPanel.class.getResource("/images/backButton.png")));
		backButton.setBounds(19, 21, 68, 68);
		titlePanel.add(backButton);
		
		levelTypeCB = new JComboBox<String>();
		levelTypeCB.setBounds(198, 21, 319, 68);
		levelTypeCB.setBackground(new Color(176, 196, 222));
		levelTypeCB.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		levelTypeCB.setModel(new DefaultComboBoxModel<String>(new String[] {"LEVEL TYPE", "PUZZLE", "LIGHTNING", "THEME"}));
		titlePanel.add(levelTypeCB);
		
		levelNumCB = new JComboBox<String>();
		levelNumCB.setBounds(534, 21, 68, 68);
		levelNumCB.setBackground(new Color(176, 196, 222));
		levelNumCB.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		levelNumCB.setModel(new DefaultComboBoxModel<String>(new String[] {"#", "1", "2", "3", "4", "5"}));
		titlePanel.add(levelNumCB);
		
		resetButton = new JButton("RESET");
		resetButton.setBounds(675, 12, 99, 40);
		resetButton.setFont(new Font("OCR A Extended", Font.BOLD, 23));
		resetButton.setBackground(new Color(255, 228, 225));
		resetButton.setBorder(new LineBorder(new Color(255, 192, 203), 3));
		titlePanel.add(resetButton);
		
		saveButton = new JButton("SAVE");
		saveButton.setBounds(675, 58, 99, 40);
		saveButton.setFont(new Font("OCR A Extended", Font.BOLD, 23));
		saveButton.setBackground(new Color(255, 228, 225));
		saveButton.setBorder(new LineBorder(new Color(255, 192, 203), 3));
		titlePanel.add(saveButton);
		
	}

	public void initInputPanels() {
		JPanel movesPanel = new JPanel();
		movesPanel.setBackground(new Color(176, 196, 222));
		movesPanel.setBounds(40, 150, 130, 80);
		movesPanel.setLayout(null);
		add(movesPanel);
		
		JPanel timePanel = new JPanel();
		timePanel.setBackground(new Color(176, 196, 222));
		timePanel.setBounds(40, 260, 130, 80);
		timePanel.setLayout(null);
		add(timePanel);
		
		JPanel starsPanel = new JPanel();
		starsPanel.setBackground(new Color(176, 196, 222));
		starsPanel.setBounds(199, 150, 372, 80);
		starsPanel.setLayout(null);
		add(starsPanel);
		
		JPanel themePanel = new JPanel();
		themePanel.setBackground(new Color(176, 196, 222));
		themePanel.setBounds(600, 150, 160, 275);
		themePanel.setLayout(null);
		add(themePanel);
		
		int font = 22;
		
		JLabel star1Label = new JLabel("1 STAR");
		star1Label.setHorizontalAlignment(SwingConstants.CENTER);
		star1Label.setFont(new Font("OCR A Extended", Font.PLAIN, font));
		star1Label.setBounds(0, 0, starsPanel.getWidth()/3, 40);
		starsPanel.add(star1Label);
		
		JLabel star2Label = new JLabel("2 STARS");
		star2Label.setHorizontalAlignment(SwingConstants.CENTER);
		star2Label.setFont(new Font("OCR A Extended", Font.PLAIN, font));
		star2Label.setBounds(starsPanel.getWidth()/3, 0, starsPanel.getWidth()/3, 40);
		starsPanel.add(star2Label);
		
		JLabel star3Label = new JLabel("3 STARS");
		star3Label.setHorizontalAlignment(SwingConstants.CENTER);
		star3Label.setFont(new Font("OCR A Extended", Font.PLAIN, font));
		star3Label.setBounds(starsPanel.getWidth()/3*2, 0, starsPanel.getWidth()/3, 40);
		starsPanel.add(star3Label);
		
		JLabel movesLabel = new JLabel("# MOVES");
		movesLabel.setFont(new Font("OCR A Extended", Font.PLAIN, font));
		movesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movesLabel.setBounds(0, 0, movesPanel.getWidth(), 40);
		movesPanel.add(movesLabel);
		
		JLabel timeLabel = new JLabel("TIME");
		timeLabel.setFont(new Font("OCR A Extended", Font.PLAIN, font));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(0, 0, timePanel.getWidth(), 40);
		timePanel.add(timeLabel);
		
		JLabel themeNameLabel = new JLabel("THEME NAME");
		themeNameLabel.setFont(new Font("OCR A Extended", Font.PLAIN, font));
		themeNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeNameLabel.setBounds(0, 0, themePanel.getWidth(), 40);
		themePanel.add(themeNameLabel);
		
		JLabel themeWordsLabel = new JLabel("WORDS");
		themeWordsLabel.setFont(new Font("OCR A Extended", Font.PLAIN, font));
		themeWordsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeWordsLabel.setBounds(0, 75, themePanel.getWidth(), 40);
		themePanel.add(themeWordsLabel);
		
		int tfHeight = 28;
		int tfWidth = 76;
		int tfOffset = 37;
		int typeFont = 16;
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(true);
		
		star1TextField = new JFormattedTextField(formatter);
		star1TextField.setFont(new Font("OCR A Extended", Font.PLAIN, typeFont));
		star1TextField.setBounds(((starsPanel.getWidth()/3)-tfWidth)/2, tfOffset, tfWidth, tfHeight);
		starsPanel.add(star1TextField);
		
		star2TextField = new JFormattedTextField(formatter);
		star2TextField.setFont(new Font("OCR A Extended", Font.PLAIN, typeFont));
		star2TextField.setBounds(((starsPanel.getWidth()/3)-tfWidth)/2 + (starsPanel.getWidth()/3), tfOffset, tfWidth, tfHeight);
		starsPanel.add(star2TextField);
		
		star3TextField = new JFormattedTextField(formatter);
		star3TextField.setFont(new Font("OCR A Extended", Font.PLAIN, typeFont));
		star3TextField.setBounds(((starsPanel.getWidth()/3)-tfWidth)/2 + ((starsPanel.getWidth()/3)*2), tfOffset, tfWidth, tfHeight);
		starsPanel.add(star3TextField);
		
		movesTextField = new JFormattedTextField(formatter);
		movesTextField.setFont(new Font("OCR A Extended", Font.PLAIN, typeFont));
		movesTextField.setBounds((movesPanel.getWidth()-tfWidth)/2, tfOffset, tfWidth, tfHeight);
		movesPanel.add(movesTextField);
		
		timeTextField = new JFormattedTextField(formatter);
		timeTextField.setFont(new Font("OCR A Extended", Font.PLAIN, typeFont));
		timeTextField.setBounds((timePanel.getWidth()-tfWidth)/2, tfOffset, tfWidth, tfHeight);
		timePanel.add(timeTextField);
		
		themeNameTextField = new JTextField();
		themeNameTextField.setFont(new Font("OCR A Extended", Font.PLAIN, typeFont));
		themeNameTextField.setBounds((themePanel.getWidth()-(tfWidth+20))/2, tfOffset, tfWidth+20, tfHeight);
		themePanel.add(themeNameTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds((themePanel.getWidth()-(tfWidth+18))/2, tfOffset+75, tfWidth+18, tfHeight*5);
		themePanel.add(scrollPane);
		
		themeWordsTextPane = new JTextPane();
		themeWordsTextPane.setFont(new Font("OCR A Extended", Font.PLAIN, typeFont));
		scrollPane.setViewportView(themeWordsTextPane);
		
	}
	
	public void initBoard() {
		boardPanel = new BoardPanel(new Board());
		boardPanel.setBounds(258, 255, 254, 254);
		add(boardPanel);
	}
	
	public void initControllers() {
		ExitLevelController elcontrol = new ExitLevelController(this);
		InputThemeNameController itmcontrol = new InputThemeNameController(level ,this);
		InputNumMovesController nmcontrol = new InputNumMovesController(level, this);
		ResetLevelController rlcontrol = new ResetLevelController(level, this);
		SelectLevelTypeController ltcontrol = new SelectLevelTypeController(level, this);
		
		backButton.addActionListener(elcontrol);
		backButton.addActionListener(rlcontrol);
		themeNameTextField.addActionListener(itmcontrol);
		movesTextField.addActionListener(nmcontrol);
		resetButton.addActionListener(rlcontrol);
		levelTypeCB.addActionListener(ltcontrol);
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void reset() {
		boardPanel.reset();
	}

	public void setUpPuzzle() {
		timeTextField.setEditable(false);
		themeNameTextField.setEditable(false);
		themeWordsTextPane.setEditable(false);
		
		star1TextField.setEditable(true);
		star2TextField.setEditable(true);
		star3TextField.setEditable(true);
		movesTextField.setEditable(true);
	}

	public void setUpLightning() {
		movesTextField.setEditable(false);
		themeNameTextField.setEditable(false);
		themeWordsTextPane.setEditable(false);
		
		timeTextField.setEditable(true);
		star1TextField.setEditable(true);
		star2TextField.setEditable(true);
		star3TextField.setEditable(true);
		
	}

	public void setUpTheme() {
		timeTextField.setEditable(false);
		star1TextField.setEditable(false);
		star2TextField.setEditable(false);
		star3TextField.setEditable(false);
		movesTextField.setEditable(false);
		
		themeNameTextField.setEditable(true);
		themeWordsTextPane.setEditable(true);
	}

	public void setUpDefault() {
		timeTextField.setEditable(false);
		star1TextField.setEditable(false);
		star2TextField.setEditable(false);
		star3TextField.setEditable(false);
		movesTextField.setEditable(false);
		themeNameTextField.setEditable(false);
		themeWordsTextPane.setEditable(false);
		
	}


}
