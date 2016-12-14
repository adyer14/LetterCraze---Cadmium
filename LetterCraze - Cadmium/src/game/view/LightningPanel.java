package game.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import game.model.LightningLevel;
import game.model.Model;

public class LightningPanel extends LevelPanel{
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -7930599956477748320L;
	
	Model m;
	private JLabel timeLabel;
	private int timeLeft;
	
	/**
	 * Create the panel.
	 */
	public LightningPanel(Model model, JPanel panel, String levType, int levNum, LevelSelectPanel lsp) {
		super(model, panel, levType, levNum, lsp);
		this.levNum = levNum;
		titleLabel.setText("LIGHTNING" + " " + levNum);
		titlePanel.add(titleLabel);
		
		// TODO this probably need to get linked to timer somehow?
		timeLeft = ((LightningLevel) level).getTime();
		
		JLabel tLabel = new JLabel("TIMER");
		tLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tLabel.setBounds(0, 4, 101, 37);
		tLabel.setForeground(Color.BLACK);
		tLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(tLabel);
		
		timeLabel = new JLabel(Integer.toString(timeLeft));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(0, 35, 101, 37);
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		getConstraintPanel().add(timeLabel);
	}
	
	@Override
	public void refresh() {
		this.levelRefresh();
	}

}
