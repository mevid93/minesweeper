package miinaharava;

import javax.swing.SwingUtilities;

import miinaharava.gui.Window;

public class Main {

	/**
	 * Method for starting the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Window());
	}

}
