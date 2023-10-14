package minesweeper.gamegrid;

/**
 * Class representing a single square in game grid.
 */
public class Square {

  private boolean isCleared; // has the square been cleared
  private boolean isFlagged; // has the square been flagged to contain mine
  private boolean containsMine; // does to square have a mine in it

  /**
   * Constructor.
   */
  public Square() {
    isCleared = false;
    isFlagged = false;
    containsMine = false;
  }

  /**
   * Method to check if square has been cleared.
   *
   * @return true if square is cleared
   */
  public boolean isCleared() {
    return isCleared;
  }

  /**
   * Method for clearing a square. Cannot clear a flagged square.
   */
  public void clear() {
    if (!isFlagged) {
      isCleared = true;
    }
  }

  /**
   * Method to check if square has been flagged to contain mine.
   *
   * @return true if square is flagged
   */
  public boolean isFlagged() {
    return isFlagged;
  }

  /**
   * Method to switch flag state of square.
   */
  public void switchFlagState() {
    if (isCleared) {
      return;
    }
    isFlagged = !isFlagged;
  }

  /**
   * Method to check if square contains a mine.
   *
   * @return true if square contains mine
   */
  public boolean containsMine() {
    return containsMine;
  }

  /**
   * Method to set mine in the square.
   */
  public void setMine() {
    containsMine = true;
  }

}
