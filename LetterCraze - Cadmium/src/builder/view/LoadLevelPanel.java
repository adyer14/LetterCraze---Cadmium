package builder.view;

import javax.swing.JPanel;

import builder.controller.LoadLevelController;
import builder.model.Model;

public class LoadLevelPanel extends SelectLevelPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 2187303783705914924L;
	private BuilderApplication app;
	
	/**
	 * Create the panel.
	 */
	public LoadLevelPanel(BuilderApplication app, Model m, JPanel contentPane) {
		super(m, contentPane);
		this.app = app;
		this.getTitleLabel().setText("LOAD LEVEL");
			
		for (int i = 1; i < 6; i++) {
			LoadLevelController PLLcontrol = new LoadLevelController(app, "PUZZLE", i);
			LoadLevelController LLLcontrol = new LoadLevelController(app, "LIGHTNING", i);
			LoadLevelController TLLcontrol = new LoadLevelController(app, "THEME", i);
			
			this.getPuzzleButton(i).addActionListener(PLLcontrol);
			this.getLightningButton(i).addActionListener(LLLcontrol);
			this.getThemeButton(i).addActionListener(TLLcontrol);
		}
		
		
	}

}
