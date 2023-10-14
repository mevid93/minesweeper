package minesweeper.gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Class represents single square in the mine field. This is GUI element.
 */
public class SquareButton extends JButton {

  private static final long serialVersionUID = 1L;
  private final int xxCoordinate;
  private final int yyCoordinate;

  /**
   * Constructor.
   *
   * @param x coordinate x
   * @param y coordinate y
   */
  public SquareButton(int x, int y) {
    this.xxCoordinate = x;
    this.yyCoordinate = y;
  }

  /**
   * Method returns x coordinate.
   *
   * @return x coordinate
   */
  public int getCoordinateX() {
    return xxCoordinate;
  }

  /**
   * Method returns y coordinate.
   *
   * @return y coordinate
   */
  public int getCoordinateY() {
    return yyCoordinate;
  }

  /**
   * Method changes the square to show mine icon.
   */
  public void showMine() {
    setPressedLook();
    ImageIcon mine = new ImageIcon(getClass().getResource("/mine.png"));
    this.setIcon(mine);
    this.setDisabledIcon(mine);
  }

  /**
   * Method changes the square to show number of mines next to square.
   *
   * @param numOfMines number of mines next to square
   */
  public void showNumberOfMines(int numOfMines) {
    setPressedLook();
    if (numOfMines != 0) {
      ImageIcon hint = new ImageIcon(getClass().getResource("/number" + numOfMines + ".png"));
      setIcon(hint);
      setDisabledIcon(hint);
    }
  }

  /**
   * Method changes the square to show flag/or no flag.
   *
   * @param flag should the square show flag or not
   */
  public void showFlag(boolean flag) {
    if (flag) {
      ImageIcon icon = new ImageIcon(getClass().getResource("/flag.png"));
      setIcon(icon);
    } else {
      setIcon(null);
    }
    validate();
  }

  private void setPressedLook() {
    setBorder(BorderFactory.createLoweredBevelBorder());
    setBackground(Color.white);
    setEnabled(false);
  }
}
