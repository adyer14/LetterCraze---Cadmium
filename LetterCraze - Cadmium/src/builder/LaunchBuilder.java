/**This is the Cadmium Builder main class
 * @author Team Cadmium
 */

package builder;

import javax.swing.*;

import builder.view.*;

public class LaunchBuilder {
	
	public static void main(String[] args) {
		
		BuilderApplication app = new BuilderApplication();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}