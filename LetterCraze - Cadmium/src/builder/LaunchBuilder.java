/**This is the Cadmium Builder main class
 * @author Team Cadmium
 */

package builder;

import javax.swing.*;

import builder.model.Model;
import builder.view.*;

public class LaunchBuilder {
	
	public static void main(String[] args) {
		Model model = new Model();
		BuilderApplication app = new BuilderApplication(model);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}