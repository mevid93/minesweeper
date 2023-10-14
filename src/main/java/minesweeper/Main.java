package minesweeper;

import javax.swing.SwingUtilities;
import minesweeper.gui.Window;

/**
 * Class containing the main function.
 */
public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Window());
  }

}
