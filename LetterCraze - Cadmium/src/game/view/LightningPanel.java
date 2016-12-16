package game.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import game.controller.EndLightningLevelController;
import game.model.LightningLevel;
import game.model.Model;

public class LightningPanel extends LevelPanel{
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -7930599956477748320L;
	
	Model m;
	private JLabel timeLabel;
	private Timer timer;
	private int initialTime;
	private EndLightningLevelController ELLControl;
	
	/**
	 * Create the panel.
	 */
	public LightningPanel(Model model, JPanel panel, String levType, int levNum, LevelSelectPanel lsp) {
		super(model, panel, levType, levNum, lsp);
		this.levNum = levNum;
		titleLabel.setText("LIGHTNING" + " " + levNum);
		titlePanel.add(titleLabel);
		
		// Get the time for the level and initialize the Swing Time with EndLightningLevelController
		initialTime = ((LightningLevel) this.level).getTime();
		initTimer();
		
		JLabel tLabel = new JLabel("TIMER");
		tLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tLabel.setBounds(0, 4, 101, 37);
		tLabel.setForeground(Color.BLACK);
		tLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(tLabel);
		
		timeLabel = new JLabel(Integer.toString(initialTime));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(0, 35, 101, 37);
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(timeLabel);
	}
	
	
	public void initTimer() {
		ELLControl = new EndLightningLevelController(this, (LightningLevel) this.level);
		timer = new Timer(1000, ELLControl);
		timer.setRepeats(true);
	}
	
	@Override
	public void refresh() {
		this.levelRefresh();
	}

	public void resetLightning() {
		this.smp.setVisible(false);
		this.getBoardPanel().resetBoard();
		resetButton.setEnabled(true);
		undoButton.setEnabled(true);
		timer.stop();
		this.ELLControl.setTime(initialTime);
		timeLabel.setText(Integer.toString(initialTime));
	}
	
	public void endLevel() {
		this.smp.updateStars();
		this.smp.setVisible(true);
		this.getBoardPanel().turnOffBoard();
		resetButton.setEnabled(false);
		undoButton.setEnabled(false);
		timer.stop();
	}
	
	public ScoreMessagePanel getScoreMessagePanel() {
		return smp;
	}
	/**
	 * get/set
	 * 
	 */
	public Timer getTimer() {
		return this.timer;
	}
	
	public JLabel getTimeLabel() {
		return timeLabel;
	}
}
