package minesweeper.gamegrid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class for Grid unit tests.
 */
public class GridTest {

  @Test
  public void constructorWorks() {
    Grid grid = new Grid(10, 10, 5);
    assertEquals(10, grid.getWidth());
    assertEquals(10, grid.getHeight());
    assertEquals(5, grid.getNumberOfMines());
  }

  @Test
  public void settingMinesWork() {
    Grid grid = new Grid(10, 10, 5);
    int numOfMines = 0;
    for (int i = 0; i < grid.getHeight(); i++) {
      for (int j = 0; j < grid.getWidth(); j++) {
        if (grid.getSquareFromCoordinate(j, i).containsMine()) {
          numOfMines++;
        }
      }
    }
    assertEquals(5, numOfMines);
  }

  @Test
  public void numberOfMinesNextToSquareWorksWithoutMines() {
    Grid grid = new Grid(3, 3, 0);
    assertEquals(0, grid.numberOfMinesNextToSquare(1, 1));
    grid = new Grid(1, 1, 1);
    assertEquals(0, grid.numberOfMinesNextToSquare(0, 0));
  }

  @Test
  public void numberOfMinesNextToSquareWorksWithMines() {
    Grid grid;
    // keep creating an new grid until there is no mine in the middle
    while (true) {
      grid = new Grid(3, 3, 1);
      if (grid.getSquareFromCoordinate(1, 1).containsMine() == false) {
        break;
      }
    }
    assertEquals(1, grid.numberOfMinesNextToSquare(1, 1));
  }

}
