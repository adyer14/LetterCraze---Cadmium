package builder.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SplashScreenWindow extends JFrame {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 775123944017819492L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SplashScreenWindow() {
		setBounds(250, 80, 816, 589);
		setTitle("Builder");

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 275);
		titlePanel.setBackground(new Color(119, 136, 153));
		titlePanel.setLayout(null);
		contentPane.add(titlePanel);
		
		JLabel lblNewLabel = new JLabel("LETTERCRAZE BUILDER");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 117, 800, 133);
		titlePanel.add(lblNewLabel);
		
		JLabel lblMonika = new JLabel("Monika Danielewicz");
		lblMonika.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		lblMonika.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonika.setBounds(0, 310, 800, 32);
		contentPane.add(lblMonika);
		
		JLabel lblAlexD = new JLabel("Alexander Dyer");
		lblAlexD.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		lblAlexD.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlexD.setBounds(0, 350, 800, 32);
		contentPane.add(lblAlexD);
		
		JLabel lblErin = new JLabel("Erin Leger");
		lblErin.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		lblErin.setHorizontalAlignment(SwingConstants.CENTER);
		lblErin.setBounds(0, 390, 800, 32);
		contentPane.add(lblErin);
		
		JLabel lblAlexM = new JLabel("Alex Michelson");
		lblAlexM.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		lblAlexM.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlexM.setBounds(0, 430, 800, 32);
		contentPane.add(lblAlexM);
		
		JLabel lblJuan = new JLabel("Juan Pablo de Lima");
		lblJuan.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		lblJuan.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuan.setBounds(0, 470, 800, 32);
		contentPane.add(lblJuan);
	}

}
