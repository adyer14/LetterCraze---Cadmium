package builder.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MainMenuPanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 6797683652563023292L;
	
	JButton newLevelButton;
	JButton loadLevelButton;
	JButton deleteLevelButton;

	/**
	 * Create the panel.
	 */
	public MainMenuPanel() {
		setBounds(0, 0, 800, 550);
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 160);
		titlePanel.setBackground(new Color(119, 136, 153));
		titlePanel.setLayout(null);
		add(titlePanel);
		
		JLabel mainMenuLabel = new JLabel("Main Menu");
		mainMenuLabel.setForeground(Color.BLACK);
		mainMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);	
		mainMenuLabel.setFont(new Font("OCR A Extended", Font.BOLD, 70));
		mainMenuLabel.setBounds(0, 0, 800, 160);
		titlePanel.add(mainMenuLabel);

		newLevelButton = new JButton("NEW LEVEL");
		newLevelButton.setForeground(new Color(0, 0, 0));
		newLevelButton.setBackground(new Color(176, 196, 222));
		newLevelButton.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		newLevelButton.setBounds(267, 210, 280, 70);
		newLevelButton.setBorder(new LineBorder(new Color(119, 136, 153), 3));
		add(newLevelButton);
		
		loadLevelButton = new JButton("LOAD LEVEL");
		loadLevelButton.setForeground(new Color(0, 0, 0));
		loadLevelButton.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		loadLevelButton.setBackground(new Color(176, 196, 222));
		loadLevelButton.setBounds(267, 320, 280, 70);
		loadLevelButton.setBorder(new LineBorder(new Color(119, 136, 153), 3));
		add(loadLevelButton);
		
		deleteLevelButton = new JButton("DELETE LEVEL");
		deleteLevelButton.setForeground(new Color(0, 0, 0));
		deleteLevelButton.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		deleteLevelButton.setBackground(new Color(176, 196, 222));
		deleteLevelButton.setBounds(267, 430, 280, 70);
		deleteLevelButton.setBorder(new LineBorder(new Color(119, 136, 153), 3));
		add(deleteLevelButton);
	}

}
