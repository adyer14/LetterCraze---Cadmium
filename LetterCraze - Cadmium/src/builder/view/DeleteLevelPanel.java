package builder.view;

import javax.swing.JPanel;

import builder.controller.DeleteLevelController;
import builder.model.Model;

public class DeleteLevelPanel extends SelectLevelPanel {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 5563532463653783273L;

	/**
	 * Create the panel.
	 */
	public DeleteLevelPanel(Model m, JPanel contentPane) {
		super(m, contentPane);

		this.getTitleLabel().setText("DELETE LEVEL");
		
		for (int i = 1; i < 6; i++) {
			DeleteLevelController PDLcontrol = new DeleteLevelController(this, "PUZZLE", i);
			DeleteLevelController LDLcontrol = new DeleteLevelController(this, "LIGHTNING", i);
			DeleteLevelController TDLcontrol = new DeleteLevelController(this, "THEME", i);
			
			this.getPuzzleButton(i).addActionListener(PDLcontrol);
			this.getLightningButton(i).addActionListener(LDLcontrol);
			this.getThemeButton(i).addActionListener(TDLcontrol);
		}
	}

}
