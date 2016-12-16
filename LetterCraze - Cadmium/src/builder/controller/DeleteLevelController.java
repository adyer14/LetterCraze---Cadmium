/**Delete level controller for builder
 * 
 */
package builder.controller;

import builder.model.*;
import builder.view.*;

/**Load a level file from the file system and delete it
 * @param lvl The level that is being selected
 * @param mainMenu The main builder menu to be returned to
 * @param mainMenuPanel visual for the menu
 */
public class DeleteLevelController {
	Level lvl;
	MainMenu mainMenu;
	MainMenuPanel mainMenuPanel;
	
	public DeleteLevelController(Level lvl, MainMenu mainMenu, MainMenuPanel mainMenuPanel){
		this.lvl = lvl;
		this.mainMenu = mainMenu;
		this.mainMenuPanel = mainMenuPanel;
	}
	
}
