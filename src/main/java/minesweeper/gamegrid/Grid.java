package minesweeper.gamegrid;

import java.util.Random;

/**
 * Class representing game grid.
 */
public class Grid {

  private int height;         // height of the grid
  private int width;          // width of the grid
  private int numberOfMines;  // number of mines in the game
  private Square[][] squares; // all the squares in the grid

  /**
   * Constructor.
   *
   * @param width widht of the grid
   * @param heigth height of the grid
   * @param numberOfMines number of mines in the game grid
   */
  public Grid(int width, int heigth, int numberOfMines) {
    this.width = width;
    this.height = heigth;
    this.numberOfMines = numberOfMines;
    this.squares = new Square[height][width];
    initializeGrid();
    setMinesToGrid();
  }

  private void initializeGrid() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        squares[i][j] = new Square();
      }
    }
  }

  private void setMinesToGrid() {
    int mines = 0;
    Random rand = new Random();
    while (mines < numberOfMines) {
      int x = rand.nextInt(width);
      int y = rand.nextInt(height);
      if (!squares[y][x].containsMine()) {
        squares[y][x].setMine();
        mines++;
      }
    }
  }

  /**
   * Get height of the grid.
   *
   * @return grid height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Get width of the grid.
   *
   * @return grid width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Get number of mines in the grid.
   *
   * @return number of mines
   */
  public int getNumberOfMines() {
    return numberOfMines;
  }

  /**
   * Method returns the number of mines next to square at (x,y).
   *
   * @param x coordinate x
   * @param y coordinate y
   *
   * @return number of mines next to square
   */
  public int numberOfMinesNextToSquare(int x, int y) {
    int mines = 0;
    for (int i = y - 1; i < y + 2; i++) {
      for (int j = x - 1; j < x + 2; j++) {
        if (i >= 0 && i < height && j >= 0 && j < width && !(i == y && j == x)) {
          if (squares[i][j].containsMine()) {
            mines++;
          }
        }
      }
    }
    return mines;
  }

  /**
   * Method to return square at coordinate (x,y).
   *
   * @param x coordinate x
   * @param y coordinate y
   * @return square
   */
  public Square getSquareFromCoordinate(int x, int y) {
    return squares[y][x];
  }
}
