/*package miinaharava.datastructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SquareTest {

    Square square;

    public SquareTest() {
    }

    @Before
    public void setUp() {
        square = new Square();
    }

    @Test
    public void ConstructorWorks() {
        assertFalse("Square had mine.", square.containsMine());
        assertFalse("Square was cleared.", square.isCleared());
        assertFalse("Square was flagged.", square.isFlagged());
    }

    @Test
    public void squareCanBeCLeared() {
        square.clear();
        assertTrue("Square was not cleared.", square.isCleared());
    }

    @Test
    public void cannotClearFlaggedSquare() {
        square.switchFlagState();
        square.clear();
        assertFalse("Square was cleared.", square.isCleared());
    }

    @Test
    public void squareCanBeFlagged() {
        square.switchFlagState();
        assertTrue("Square was not flagged.", square.isFlagged());
    }

    @Test
    public void squareCanBeUnflagged() {
    	square.switchFlagState();
        assertTrue("Square was not flagged.", square.isFlagged());
        square.switchFlagState();
        assertFalse("Square was flagged.", square.isFlagged());
    }

    @Test
    public void cannotFlagClearedSquare() {
        square.clear();
        square.switchFlagState();
        assertFalse("Square was flagged.", square.isFlagged());
    }

    @Test
    public void minesCanBeSet() {
        square.setMine();
        assertTrue("Square had no mine.", square.containsMine());
    }
}
*/