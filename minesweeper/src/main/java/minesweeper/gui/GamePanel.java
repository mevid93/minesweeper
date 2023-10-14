package minesweeper.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import minesweeper.gamegrid.Grid;
import minesweeper.gui.eventlisteners.SquareButtonListener;

/**
 * Class representing game area (GUI element).
 */
public class GamePanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private Grid grid;
  private ArrayList<SquareButton> buttonList;

  /**
   * Constructor.
   *
   * @param grid game area grid
   */
  public GamePanel(Grid grid) {
    this.grid = grid;
    buttonList = new ArrayList<>();
    initializeSquareButtons();
  }

  private void initializeSquareButtons() {
    setLayout(new GridBagLayout());
    setBackground(Color.GRAY);
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    for (int i = 0; i < grid.getHeight(); i++) {
      c.gridy = i;
      for (int j = 0; j < grid.getWidth(); j++) {
        c.gridx = j;
        SquareButton b = createSquareButton(j, i);
        this.add(b, c);
      }
    }
  }

  private SquareButton createSquareButton(int x, int y) {
    SquareButton squareButton = new SquareButton(x, y);
    squareButton.setPreferredSize(new Dimension(40, 40));
    squareButton.addMouseListener(new SquareButtonListener(squareButton, this, grid));
    squareButton.setMargin(new Insets(0, 0, 0, 0));
    buttonList.add(squareButton);
    return squareButton;
  }

  /**
   * Method sets square at coordinate (x,y) to show number of close mines.
   *
   * @param x x coordinate
   * @param y y coordinate
   * @param mines number of close mines
   */
  public void setCloseMinesVisible(int x, int y, int mines) {
    for (SquareButton button : buttonList) {
      if (button.getCoordinateX() == x && button.getCoordinateY() == y) {
        button.showNumberOfMines(mines);
        break;
      }
    }
  }

  /**
   * Method to reveal all mines.
   */
  public void revealAllMines() {
    for (int i = 0; i < grid.getHeight(); i++) {
      for (int j = 0; j < grid.getWidth(); j++) {
        if (!grid.getSquareFromCoordinate(j, i).isCleared()
            && !grid.getSquareFromCoordinate(j, i).isFlagged()) {
          if (grid.getSquareFromCoordinate(j, i).containsMine()) {
            for (SquareButton button : buttonList) {
              if (button.getCoordinateX() == j && button.getCoordinateY() == i) {
                button.showMine();
                break;
              }
            }
          }
        }
      }
    }
  }

  /**
   * Method returns width of the game area.
   *
   * @return width of the game area
   */
  public int getWidthOfGameArea() {
    return grid.getWidth();
  }

  /**
   * Method returns height of the game area.
   *
   * @return height of the game area
   */
  public int getHeightOfGameArea() {
    return this.grid.getHeight();
  }

  /**
   * Method returns list of all square buttons.
   *
   * @return list of square buttons
   */
  public ArrayList<SquareButton> getListOfSquareButtons() {
    return buttonList;
  }

}
