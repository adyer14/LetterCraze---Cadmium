package builder.view;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import builder.controller.ReturnToMainMenuController;
import builder.model.Model;
import game.view.LevelPanel;

public abstract class SelectLevelPanel extends JPanel {
	
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -8888323667954365950L;

	Model m;
	JPanel contentPane;
	JButton puzzleButton[] = new JButton[6];
	JButton lightningButton[] = new JButton[6];
	JButton themeButton[] = new JButton[6];
	
	JLabel puzzleStarLabel[] = new JLabel[6];
	JLabel lightningStarLabel[] = new JLabel[6];
	JLabel themeStarLabel[] = new JLabel[6];
	
	HashMap<String, JButton> levelButtons = new HashMap<String, JButton>();
	HashMap<String, JLabel> levelStarLabels = new HashMap<String, JLabel>();
	
	int buttWidth = 80;
	int buttHeight = 80;
	int puzzHeight = 152;
	int lightHeight = puzzHeight+138;
	int themeHeight = lightHeight+138;
	int typeDist = 42;
	int buttonDist = 275;
	int starWidth = 26;

	private JButton backButton;
	/**
	 * Create the panel.
	 */
	public SelectLevelPanel(Model model, JPanel panel) {
		this.m = model;
		contentPane = panel;
		setBounds(0, 0, 800, 550);
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		initTitles();
		initButtons();
	}

	public void initButtons() {	
		for (int puzzNum = 1; puzzNum <= 5; puzzNum++) {
			puzzleButton[puzzNum] = new JButton(Integer.toString(puzzNum));
			puzzleButton[puzzNum].setIcon(new ImageIcon(SelectLevelPanel.class.getResource("/images/" + puzzNum + "level.png")));
			puzzleButton[puzzNum].setBounds(buttonDist + ((puzzNum-1)*100), puzzHeight, buttWidth, buttHeight);
			puzzleButton[puzzNum].setEnabled(false);
			levelButtons.put("puzzleButton" + puzzNum, puzzleButton[puzzNum]);
			add(puzzleButton[puzzNum]);
		}
		
		for (int litNum = 1; litNum <= 5; litNum++) {
			lightningButton[litNum] = new JButton("");
			lightningButton[litNum].setIcon(new ImageIcon(SelectLevelPanel.class.getResource("/images/" + litNum + "level.png")));
			lightningButton[litNum].setBounds(buttonDist + ((litNum-1)*100), lightHeight, buttWidth, buttHeight);
			lightningButton[litNum].setEnabled(false);
			levelButtons.put("lightningButton" + litNum, lightningButton[litNum]);
			add(lightningButton[litNum]);
		}
		for (int thmNum = 1; thmNum <= 5; thmNum++) {
			themeButton[thmNum] = new JButton("");
			themeButton[thmNum].setIcon(new ImageIcon(SelectLevelPanel.class.getResource("/images/" + thmNum + "level.png")));
			themeButton[thmNum].setBounds(buttonDist + ((thmNum-1)*100), themeHeight, buttWidth, buttHeight);
			themeButton[thmNum].setEnabled(false);
			levelButtons.put("themeButton" + thmNum, themeButton[thmNum]);
			add(themeButton[thmNum]);
		}
	}
	
	public void initTitles() {
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 110);
		titlePanel.setBackground(new Color(119, 136, 153));
		titlePanel.setLayout(null);
		add(titlePanel);
		
		JLabel levelSelectLabel = new JLabel("Level Select");
		levelSelectLabel.setForeground(Color.BLACK);
		levelSelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelSelectLabel.setBounds(0, 0, 800, 110);
		levelSelectLabel.setFont(new Font("OCR A Extended", Font.BOLD, 60));
		titlePanel.add(levelSelectLabel);
		
		JLabel puzzleLabel = new JLabel("Puzzle");
		puzzleLabel.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		puzzleLabel.setBounds(typeDist, puzzHeight, 156, buttHeight);
		add(puzzleLabel);
		
		JLabel lightningLabel = new JLabel("Lightning");
		lightningLabel.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		lightningLabel.setBounds(typeDist, lightHeight, 219, buttHeight);
		add(lightningLabel);
		
		JLabel themeLabel = new JLabel("Theme");
		themeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		themeLabel.setBounds(typeDist, themeHeight, 125, buttHeight);
		add(themeLabel);
		
		backButton = new JButton("");
		backButton.setSelectedIcon(new ImageIcon(LevelPanel.class.getResource("/images/backSelected.png")));
		backButton.setIcon(new ImageIcon(LevelPanel.class.getResource("/images/backButton.png")));
		backButton.setRolloverIcon(new ImageIcon(LevelPanel.class.getResource("/images/backSelected.png")));
		backButton.setBounds(20, 22, 66, 66);
		backButton.setFocusPainted(false);
		backButton.setBorder(null);
		titlePanel.add(backButton);
		
		ReturnToMainMenuController RTMMcontrol = new ReturnToMainMenuController(this);
		backButton.addActionListener(RTMMcontrol);
		
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public JButton getPuzzleButton(int levNum) {
		return puzzleButton[levNum];
	}
	
	public JButton getLightningButton(int levNum) {
		return lightningButton[levNum];
	}
	
	public JButton getThemeButton(int levNum) {
		return themeButton[levNum];
	}
}
