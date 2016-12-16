package game.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import game.controller.ChooseWordController;
import game.model.Level;

public class ScoreMessagePanel extends JPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 5745793052857452253L;
	
	private Level level;

	private JLabel starsAchievedLabel;
	
	/**
	 * Create the panel.
	 */
	public ScoreMessagePanel(Level level, ChooseWordController CWControl) {
		this.level = level;
		addMouseListener(CWControl);
		setBounds(202,220, 366, 220);
		setBackground(new Color(230,230,250));
		setBorder(new LineBorder(new Color(119, 136, 153), 5));
		setLayout(null);

		JLabel timesUpLabel = new JLabel("TIME'S UP!");
		timesUpLabel.setBounds(0, 39, 366, 52);
		timesUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timesUpLabel.setFont(new Font("OCR A Extended", Font.BOLD, 50));
		add(timesUpLabel);

		starsAchievedLabel = new JLabel("");
		starsAchievedLabel.setBounds(0, 113, 366, 62);
		starsAchievedLabel.setIcon(new ImageIcon(ScoreMessagePanel.class.getResource("/images/0GameStars.png")));
		starsAchievedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(starsAchievedLabel);

		setVisible(false);

	}
	
	public void updateStars() {
		int starsAchieved = level.getCurrentStars();
		starsAchievedLabel.setIcon(new ImageIcon(ScoreMessagePanel.class.getResource("/images/" + starsAchieved + "GameStars.png")));
	}

}
