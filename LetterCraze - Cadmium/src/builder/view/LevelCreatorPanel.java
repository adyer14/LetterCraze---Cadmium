package builder.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;


public class LevelCreatorPanel extends JPanel {
	// TODO create update methods for all editable fields - or just one refresh?
	// TODO figure out proper format for displaying information on the right
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 5512267083227412445L;
	
	private JTextField star1TextField;
	private JTextField star2TextField;
	private JTextField star3TextField;
	private JTextField movesTextField;
	private JTextField timeTextField;
	private JTextField themeNameTextField;
	private JTextPane themeWordsTextPane;
	private int star1Value;
	private int star2Value;
	private int star3Value;
	private int movesValue;
	private int timeValue;
	private String themeName;
	private String themeWords[];
	
	/**
	 * Create the panel.
	 */
	public LevelCreatorPanel() {
		setBounds(0, 0, 800, 550);
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		initInputPanel();
		initOutputPanel();
	}
	
	public void initInputPanel() {
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(176, 196, 222));
		inputPanel.setBounds(19, 134, 236, 391);
		inputPanel.setLayout(null);
		add(inputPanel);
				
		JLabel star1Label = new JLabel("1 STAR:");
		star1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		star1Label.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		star1Label.setBounds(12, 22, 118, 14);
		inputPanel.add(star1Label);
		
		JLabel star2Label = new JLabel("2 STARS:");
		star2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		star2Label.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		star2Label.setBounds(12, 47, 118, 14);
		inputPanel.add(star2Label);
		
		JLabel star3Label = new JLabel("3 STARS:");
		star3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		star3Label.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		star3Label.setBounds(12, 72, 118, 14);
		inputPanel.add(star3Label);
		
		JLabel movesLabel = new JLabel("# MOVES:");
		movesLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		movesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		movesLabel.setBounds(12, 97, 118, 14);
		inputPanel.add(movesLabel);
		
		JLabel timeLabel = new JLabel("TIME:");
		timeLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		timeLabel.setBounds(12, 122, 118, 14);
		inputPanel.add(timeLabel);
		
		JLabel themeNameLabel = new JLabel("THEME NAME:");
		themeNameLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		themeNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		themeNameLabel.setBounds(12, 147, 118, 14);
		inputPanel.add(themeNameLabel);
		
		JLabel themeWordsLabel = new JLabel("WORDS:");
		themeWordsLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		themeWordsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		themeWordsLabel.setBounds(12, 172, 118, 14);
		inputPanel.add(themeWordsLabel);
		
		star1TextField = new JTextField();
		star1TextField.setBounds(140, 21, 60, 20);
		inputPanel.add(star1TextField);
		
		star2TextField = new JTextField();
		star2TextField.setBounds(140, 46, 60, 20);
		inputPanel.add(star2TextField);
		
		star3TextField = new JTextField();
		star3TextField.setBounds(140, 71, 60, 20);
		inputPanel.add(star3TextField);
		
		movesTextField = new JTextField();
		movesTextField.setBounds(140, 96, 60, 20);
		inputPanel.add(movesTextField);
		
		timeTextField = new JTextField();
		timeTextField.setBounds(140, 121, 60, 20);
		inputPanel.add(timeTextField);
		
		themeNameTextField = new JTextField();
		themeNameTextField.setEnabled(false);
		themeNameTextField.setBounds(140, 146, 75, 20);
		inputPanel.add(themeNameTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(141, 171, 73, 199);
		inputPanel.add(scrollPane);
		
		themeWordsTextPane = new JTextPane();
		themeWordsTextPane.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		scrollPane.setViewportView(themeWordsTextPane);
	}
	
	public void initOutputPanel() {
		JPanel outputPanel = new JPanel();
		outputPanel.setBackground(new Color(176, 196, 222));
		outputPanel.setBounds(545, 134, 236, 391);
		outputPanel.setLayout(null);
		add(outputPanel);
				
		JLabel star1Label = new JLabel("1 STAR:");
		star1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		star1Label.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		star1Label.setBounds(12, 22, 118, 14);
		outputPanel.add(star1Label);
		
		JLabel star2Label = new JLabel("2 STARS:");
		star2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		star2Label.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		star2Label.setBounds(12, 47, 118, 14);
		outputPanel.add(star2Label);
		
		JLabel star3Label = new JLabel("3 STARS:");
		star3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		star3Label.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		star3Label.setBounds(12, 72, 118, 14);
		outputPanel.add(star3Label);
		
		JLabel movesLabel = new JLabel("# MOVES:");
		movesLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		movesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		movesLabel.setBounds(12, 97, 118, 14);
		outputPanel.add(movesLabel);
		
		JLabel timeLabel = new JLabel("TIME:");
		timeLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		timeLabel.setBounds(12, 122, 118, 14);
		outputPanel.add(timeLabel);
		
		JLabel themeNameLabel = new JLabel("THEME NAME:");
		themeNameLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		themeNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		themeNameLabel.setBounds(12, 147, 118, 14);
		outputPanel.add(themeNameLabel);
		
		JLabel themeWordsLabel = new JLabel("WORDS:");
		themeWordsLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		themeWordsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		themeWordsLabel.setBounds(12, 172, 118, 14);
		outputPanel.add(themeWordsLabel);
		
		
		
		JLabel star1ValueLabel = new JLabel("");
		star1ValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		star1ValueLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		star1ValueLabel.setBounds(130, 22, 118, 14);
		outputPanel.add(star1ValueLabel);
		
		JLabel star2ValueLabel = new JLabel("");
		star2ValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		star2ValueLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		star2ValueLabel.setBounds(130, 47, 118, 14);
		outputPanel.add(star2ValueLabel);
		
		JLabel star3ValueLabel = new JLabel("");
		star3ValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		star3ValueLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		star3ValueLabel.setBounds(130, 72, 118, 14);
		outputPanel.add(star3ValueLabel);
		
		JLabel movesValueLabel = new JLabel("");
		movesValueLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		movesValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		movesValueLabel.setBounds(130, 97, 118, 14);
		outputPanel.add(movesValueLabel);
		
		JLabel timeValueLabel = new JLabel("");
		timeValueLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		timeValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		timeValueLabel.setBounds(130, 122, 118, 14);
		outputPanel.add(timeValueLabel);
		
		JLabel themeNameValueLabel = new JLabel("");
		themeNameValueLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		themeNameValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		themeNameValueLabel.setBounds(130, 147, 118, 14);
		outputPanel.add(themeNameValueLabel);
		
		JLabel themeWordsValueLabel = new JLabel("");
		themeWordsValueLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		themeWordsValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		themeWordsValueLabel.setBounds(130, 172, 118, 14);
		outputPanel.add(themeWordsValueLabel);
	}

}
