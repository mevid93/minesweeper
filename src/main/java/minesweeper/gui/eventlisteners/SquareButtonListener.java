package minesweeper.gui.eventlisteners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import minesweeper.gamegrid.Grid;
import minesweeper.gui.GamePanel;
import minesweeper.gui.SquareButton;

/**
 * MouseListener for square buttons.
 */
public class SquareButtonListener implements MouseListener {

  private SquareButton squareButton;
  private GamePanel minefield;
  private Grid gamegrid;

  /**
   * Constructor.
   *
   * @param button square button under observation
   * @param field  GUI element of game field
   * @param grid   square grid
   */
  public SquareButtonListener(SquareButton button, GamePanel field, Grid grid) {
    minefield = field;
    gamegrid = grid;
    squareButton = button;
  }

  /**
   * Method to execute when mouse is pressed on button.
   *
   * @param e mouse press event
   */
  @Override
  public void mousePressed(MouseEvent e) {
    if (e.getSource() == squareButton) {
      int x = squareButton.getCoordinateX();
      int y = squareButton.getCoordinateY();
      if (SwingUtilities.isLeftMouseButton(e) && !gamegrid.getSquareFromCoordinate(x, y).isFlagged()
          && !gamegrid.getSquareFromCoordinate(x, y).isCleared()) {
        leftClick(x, y);
      } else if (SwingUtilities.isRightMouseButton(e)
          && !this.gamegrid.getSquareFromCoordinate(x, y).isCleared()) {
        rightClick(x, y);
      }
    }
  }

  private void rightClick(int x, int y) {
    gamegrid.getSquareFromCoordinate(x, y).switchFlagState();
    squareButton.showFlag(gamegrid.getSquareFromCoordinate(x, y).isFlagged());
    checkDidPlayerWin();
  }

  private void leftClick(int x, int y) {
    if (gamegrid.getSquareFromCoordinate(x, y).containsMine()) {
      gamegrid.getSquareFromCoordinate(x, y).clear();
      ;
      playerLoseAction();
    } else {
      clearSquareWithoutMine(x, y);
      checkDidPlayerWin();
    }
  }

  private void markAsCleared() {
    for (int i = 0; i < gamegrid.getHeight(); i++) {
      for (int j = 0; j < gamegrid.getWidth(); j++) {
        if (gamegrid.getSquareFromCoordinate(j, i).isFlagged()) {
          gamegrid.getSquareFromCoordinate(j, i).switchFlagState();
        }
        gamegrid.getSquareFromCoordinate(j, i).clear();
      }
    }
  }

  private void playerLoseAction() {
    squareButton.showMine();
    squareButton.setBackground(Color.red);
    minefield.revealAllMines();
    markAsCleared();
    JOptionPane.showMessageDialog(null, "You lose");
  }

  private void clearSquareWithoutMine(int x, int y) {
    if (!gamegrid.getSquareFromCoordinate(x, y).isFlagged()) {
      gamegrid.getSquareFromCoordinate(x, y).clear();
      int numOfCloseMines = gamegrid.numberOfMinesNextToSquare(x, y);
      minefield.setCloseMinesVisible(x, y, numOfCloseMines);

      if (numOfCloseMines == 0) {
        if (x + 1 < gamegrid.getWidth()
            && !gamegrid.getSquareFromCoordinate(x + 1, y).isCleared()) {
          clearSquareWithoutMine(x + 1, y);
        }
        if (x + 1 < gamegrid.getWidth() && y + 1 < gamegrid.getHeight()
            && !gamegrid.getSquareFromCoordinate(x + 1, y + 1).isCleared()) {
          clearSquareWithoutMine(x + 1, y + 1);
        }
        if (y + 1 < gamegrid.getHeight()
            && !gamegrid.getSquareFromCoordinate(x, y + 1).isCleared()) {
          clearSquareWithoutMine(x, y + 1);
        }
        if (x - 1 >= 0 && y + 1 < gamegrid.getHeight()
            && !gamegrid.getSquareFromCoordinate(x - 1, y + 1).isCleared()) {
          clearSquareWithoutMine(x - 1, y + 1);
        }
        if (x - 1 >= 0 && !gamegrid.getSquareFromCoordinate(x - 1, y).isCleared()) {
          clearSquareWithoutMine(x - 1, y);
        }
        if (x - 1 >= 0 && y - 1 >= 0
            && !gamegrid.getSquareFromCoordinate(x - 1, y - 1).isCleared()) {
          clearSquareWithoutMine(x - 1, y - 1);
        }
        if (y - 1 >= 0 && !gamegrid.getSquareFromCoordinate(x, y - 1).isCleared()) {
          clearSquareWithoutMine(x, y - 1);
        }
        if (x + 1 < gamegrid.getHeight() && y - 1 >= 0
            && !gamegrid.getSquareFromCoordinate(x + 1, y - 1).isCleared()) {
          clearSquareWithoutMine(x + 1, y - 1);
        }
      }
    }
  }

  private void checkDidPlayerWin() {
    for (int i = 0; i < gamegrid.getHeight(); i++) {
      for (int j = 0; j < gamegrid.getWidth(); j++) {
        if (!gamegrid.getSquareFromCoordinate(j, i).containsMine()
            && !gamegrid.getSquareFromCoordinate(j, i).isCleared()) {
          return;
        } else if (gamegrid.getSquareFromCoordinate(j, i).containsMine()
            && !gamegrid.getSquareFromCoordinate(j, i).isFlagged()) {
          return;
        }
      }
    }
    markAsCleared();
    JOptionPane.showMessageDialog(null, "You win");
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

}
