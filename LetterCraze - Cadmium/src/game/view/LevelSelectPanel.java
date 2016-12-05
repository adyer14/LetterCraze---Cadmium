package game.view;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import game.controller.LevelSelectController;
import game.model.Level;
import game.model.Model;

public class LevelSelectPanel extends JPanel {

	/**
	 *  Keep Eclipse happy
	 */
	private static final long serialVersionUID = -8120104755673468942L;
	
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
	
	int buttWidth = 54;
	int buttHeight = 80;
	int puzzHeight = 152;
	int lightHeight = puzzHeight+138;
	int themeHeight = lightHeight+138;
	int typeDist = 42;
	int buttonDist = 275;
	int starWidth = 26;
	
	/**
	 * Create the panel.
	 */
	public LevelSelectPanel(Model model, JPanel panel) {
		this.m = model;
		contentPane = panel;
		
		setBounds(0, 0, 800, 550);
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		initTitles();
		initButtons();
		initStars();
		initControllers();
	}
	
	private void initControllers() {
		for (int puzzNum = 1; puzzNum <= 5; puzzNum++) { 
			LevelSelectController lscontrol = new LevelSelectController(m, this, "puzzle", puzzNum);
			puzzleButton[puzzNum].addActionListener(lscontrol);
		}
		for (int litNum = 1; litNum <= 5; litNum++) {
			LevelSelectController lscontrol = new LevelSelectController(m, this, "lightning", litNum);
			lightningButton[litNum].addActionListener(lscontrol);
		}
		for (int thmNum = 1; thmNum <= 5; thmNum++) {
			LevelSelectController lscontrol = new LevelSelectController(m, this, "theme", thmNum);
			themeButton[thmNum].addActionListener(lscontrol);
		}
	}

	public void initButtons() {	
		for (int puzzNum = 1; puzzNum <= 5; puzzNum++) {
			puzzleButton[puzzNum] = new JButton("");
			puzzleButton[puzzNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/" + puzzNum + "level.png")));
			puzzleButton[puzzNum].setBounds(buttonDist + ((puzzNum-1)*100), puzzHeight, buttWidth, buttHeight);
			if (puzzNum > 1)
				puzzleButton[puzzNum].setEnabled(false);
			levelButtons.put("puzzleButton" + puzzNum, puzzleButton[puzzNum]);
			add(puzzleButton[puzzNum]);
		}
		
		for (int litNum = 1; litNum <= 5; litNum++) {
			lightningButton[litNum] = new JButton("");
			lightningButton[litNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/" + litNum + "level.png")));
			lightningButton[litNum].setBounds(buttonDist + ((litNum-1)*100), lightHeight, buttWidth, buttHeight);
			if (litNum > 1)
				lightningButton[litNum].setEnabled(false);
			levelButtons.put("lightningButton" + litNum, lightningButton[litNum]);
			add(lightningButton[litNum]);
		}
		for (int thmNum = 1; thmNum <= 5; thmNum++) {
			themeButton[thmNum] = new JButton("");
			themeButton[thmNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/" + thmNum + "level.png")));
			themeButton[thmNum].setBounds(buttonDist + ((thmNum-1)*100), themeHeight, buttWidth, buttHeight);
			if (thmNum > 1)
				themeButton[thmNum].setEnabled(false);
			levelButtons.put("themeButton" + thmNum, themeButton[thmNum]);
			add(themeButton[thmNum]);
		}
	}
	
	public void initStars() {
		for (int puzzNum = 1; puzzNum <= 5; puzzNum++) {
			puzzleStarLabel[puzzNum] = new JLabel("");
			if (puzzNum == 1)
				puzzleStarLabel[puzzNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/0Stars.png")));
			else
				puzzleStarLabel[puzzNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/lockedStars.png")));
			puzzleStarLabel[puzzNum].setBounds(buttonDist + ((puzzNum-1)*100) + buttWidth, puzzHeight, starWidth, buttHeight);
			levelStarLabels.put("puzzleStarLabel" + puzzNum, puzzleStarLabel[puzzNum]);
			add(puzzleStarLabel[puzzNum]);
		}
		
		for (int litNum = 1; litNum <= 5; litNum++) {
			lightningStarLabel[litNum] = new JLabel("");
			if (litNum == 1)
				lightningStarLabel[litNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/0Stars.png")));
			else
				lightningStarLabel[litNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/lockedStars.png")));
			lightningStarLabel[litNum].setBounds(buttonDist + ((litNum-1)*100) + buttWidth, lightHeight, starWidth, buttHeight);
			levelStarLabels.put("lightningStarLabel" + litNum, lightningStarLabel[litNum]);
			add(lightningStarLabel[litNum]);
		}
		
		for (int thmNum = 1; thmNum <= 5; thmNum++) {
			themeStarLabel[thmNum] = new JLabel("");
			if (thmNum == 1)
				themeStarLabel[thmNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/0Stars.png")));
			else
				themeStarLabel[thmNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/lockedStars.png")));
			themeStarLabel[thmNum].setBounds(buttonDist + ((thmNum-1)*100) + buttWidth, themeHeight, starWidth, buttHeight);
			levelStarLabels.put("themeStarLabel" + thmNum, themeStarLabel[thmNum]);
			add(themeStarLabel[thmNum]);
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
		
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public void updateStars(Level level) {
		int mostStars = level.getMostStars();
		System.out.println(mostStars);
		String starLabelName = level.getLevelType() + "StarLabel" + level.getLevelNumber(); 
		System.out.println(starLabelName);
		JLabel starLabel = levelStarLabels.get(starLabelName);
		starLabel.setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/" + mostStars + "stars.png")));
	}
	
	public void unlockNext(Level level) {
		int nextLvlNum = level.getLevelNumber() + 1;
		String lvlType = level.getLevelType();
		
		String nextButtonName = lvlType + "Button" + nextLvlNum;
		JButton nextButton = levelButtons.get(nextButtonName);
		nextButton.setEnabled(true);
		
		String nextLabelName = lvlType + "StarLabel" + nextLvlNum; 
		JLabel nextStarLabel = levelStarLabels.get(nextLabelName);
		nextStarLabel.setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/0Stars.png")));
	}

}
