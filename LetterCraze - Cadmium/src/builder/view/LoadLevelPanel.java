package builder.view;

import javax.swing.JPanel;

import builder.controller.LoadLevelController;
import builder.model.Model;

public class LoadLevelPanel extends SelectLevelPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 2187303783705914924L;

	/**
	 * Create the panel.
	 */
	public LoadLevelPanel(Model m, JPanel contentPane) {
		super(m, contentPane);
		
		this.getTitleLabel().setText("LOAD LEVEL");
		
		for (int i = 0; i < 5; i++) {
			LoadLevelController PLLcontrol = new LoadLevelController(this, "puzzle", i);
			LoadLevelController LLLcontrol = new LoadLevelController(this, "lightning", i);
			LoadLevelController TLLcontrol = new LoadLevelController(this, "theme", i);
			
			this.getPuzzleButton(i).addActionListener(PLLcontrol);
			this.getLightningButton(i).addActionListener(LLLcontrol);
			this.getThemeButton(i).addActionListener(TLLcontrol);
		}
		
		
	}

}
