package game.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import game.model.LevelSelect;

public class LevelSelectPanel extends JPanel {

	/**
	 *  Keep Eclipse happy
	 */
	private static final long serialVersionUID = -8120104755673468942L;
	
	LevelSelect ls;
	JButton puzzleButton[] = new JButton[6];
	JButton lightningButton[] = new JButton[6];
	JButton themeButton[] = new JButton[6];
	
	JLabel puzzStarLabel[] = new JLabel[6];
	JLabel lightStarLabel[] = new JLabel[6];
	JLabel themeStarLabel[] = new JLabel[6];
	
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
	public LevelSelectPanel() {
		setBounds(10, 10, 800, 550);
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		initTitles();
		initButtons();
		initStars();
	}
	
	public void initButtons() {
		for (int puzzNum = 1; puzzNum <= 5; puzzNum++) {
			puzzleButton[puzzNum] = new JButton("");
			puzzleButton[puzzNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/" + puzzNum + "level.png")));
			puzzleButton[puzzNum].setBounds(buttonDist + ((puzzNum-1)*100), puzzHeight, buttWidth, buttHeight);
			if (puzzNum > 1)
				puzzleButton[puzzNum].setEnabled(false);
			add(puzzleButton[puzzNum]);
		}
		for (int litNum = 1; litNum <= 5; litNum++) {
			lightningButton[litNum] = new JButton("");
			lightningButton[litNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/" + litNum + "level.png")));
			lightningButton[litNum].setBounds(buttonDist + ((litNum-1)*100), lightHeight, buttWidth, buttHeight);
			if (litNum > 1)
				lightningButton[litNum].setEnabled(false);
			add(lightningButton[litNum]);
		}
		for (int thmNum = 1; thmNum <= 5; thmNum++) {
			themeButton[thmNum] = new JButton("");
			themeButton[thmNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/" + thmNum + "level.png")));
			themeButton[thmNum].setBounds(buttonDist + ((thmNum-1)*100), themeHeight, buttWidth, buttHeight);
			if (thmNum > 1)
				themeButton[thmNum].setEnabled(false);
			add(themeButton[thmNum]);
		}
	}
	
	public void initStars() {
		for (int puzzNum = 1; puzzNum <= 5; puzzNum++) {
			puzzStarLabel[puzzNum] = new JLabel("");
			if (puzzNum == 1)
				puzzStarLabel[puzzNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/0Stars.png")));
			else
				puzzStarLabel[puzzNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/lockedStars.png")));
			puzzStarLabel[puzzNum].setBounds(buttonDist + ((puzzNum-1)*100) + buttWidth, puzzHeight, starWidth, buttHeight);
			add(puzzStarLabel[puzzNum]);
		}
		
		for (int litNum = 1; litNum <= 5; litNum++) {
			lightStarLabel[litNum] = new JLabel("");
			if (litNum == 1)
				lightStarLabel[litNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/0Stars.png")));
			else
				lightStarLabel[litNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/lockedStars.png")));
			lightStarLabel[litNum].setBounds(buttonDist + ((litNum-1)*100) + buttWidth, lightHeight, starWidth, buttHeight);
			add(lightStarLabel[litNum]);
		}
		
		for (int thmNum = 1; thmNum <= 5; thmNum++) {
			themeStarLabel[thmNum] = new JLabel("");
			if (thmNum == 1)
				themeStarLabel[thmNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/0Stars.png")));
			else
				themeStarLabel[thmNum].setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/lockedStars.png")));
			themeStarLabel[thmNum].setBounds(buttonDist + ((thmNum-1)*100) + buttWidth, themeHeight, starWidth, buttHeight);
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
	
	public void update(){//Level level) {
		int nextLevNum = 1; //Level.levNum + 1;
		int currentLevNum = 2; //Level.levNum;
		
		//if (level.getName().startsWith("puzzle")) {
		JButton nextButton = puzzleButton[nextLevNum];
		JLabel nextStarLabel = puzzStarLabel[nextLevNum];
		/*}
		else if (level.getName().startsWith("lightning")) {
			JButton nextButton = lightButton[nextLevNum];
			JLabel nextStarLabel = lightStarLabel[nextLevNum];
		}
		else {
			JButton nextButton = themeButton[nextLevNum];
			JLabel nextStarLabel = themeStarLabel[nextLevNum];
		}
		
		if (level.isUnlocked && currentLevNum < 6) {
			nextbutton.setEnabled(true);
			nextStarLabel.setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/0Stars.png")));
		}
		//currentButton.setIcon(new ImageIcon(LevelSelectPanel.class.getResource("/images/" + Level.maxStarsAchieved + "level.png")));
		*/
		}

}
