package minesweeper.gui.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import minesweeper.gui.RulesDialog;
import minesweeper.gui.SettingsDialog;
import minesweeper.gui.Window;

/**
 * MenuItem event listener.
 */
public class MenuItemListener implements ActionListener {

  private JMenuItem menuItem;   // menu item that is observed
  private Window parentWindow;  // parent window

  /**
   * Constructor.
   *
   * @param menuItem menu item
   * @param window   parent window
   */
  public MenuItemListener(JMenuItem menuItem, Window window) {
    this.parentWindow = window;
    this.menuItem = menuItem;
  }

  /**
   * Method to execute when action is registered.
   *
   * @param e menu event
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (menuItem.getText()) {
      case "Quit":
        System.exit(0);
        break;
      case "Settings":
        settingsButtonAction();
        break;
      case "Rules":
        rulesButtonAction();
        break;
      default:
        break;
    }
  }

  private void settingsButtonAction() {
    SettingsDialog settings = new SettingsDialog(parentWindow.getFrame(), true);
    int[] size = settings.showDialog();
    if (size[0] != 0) {
      parentWindow.changeSettings(size[0], size[1], size[2]);
    }
  }

  private void rulesButtonAction() {
    RulesDialog rd = new RulesDialog(parentWindow.getFrame(), true);
    rd.showDialog();
  }

}
