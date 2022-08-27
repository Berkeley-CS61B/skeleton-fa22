package game2048;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Tests the maxTileExists() static method of Model.
 *
 * @author Omar Khan
 */
public class TestMaxTileExists {
    /** The board we'll be testing. */
    static Board b;

    /** Note that this isn't a possible board state. */
    @Test
    public void testEmptyBoard() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals);

        assertFalse("Board is empty\n" + b, Model.maxTileExists(b));
    }

    /** Tests a full board with no max piece. */
    @Test
    public void testFullBoardNoMax() {
        int[][] rawVals = new int[][] {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
        };

        b = new Board(rawVals);

        assertFalse("No 2048 tile on board\n" + b, Model.maxTileExists(b));
    }

    /** Tests a full board with the max piece. */
    @Test
    public void testFullBoardMax() {
        int[][] rawVals = new int[][] {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2048},
        };

        b = new Board(rawVals);

        assertTrue("One 2048 tile on board\n" + b,
                Model.maxTileExists(b));
    }

    /** Tests multiple max pieces. */
    @Test
    public void testMultipleMax() {
        int[][] rawVals = new int[][] {
                {2, 2, 2, 2},
                {2, 2048, 0, 0},
                {0, 0, 0, 2},
                {0, 0, 2, 2048},
        };

        b = new Board(rawVals);

        assertTrue("Two 2048 tiles on board\n" + b,
                Model.maxTileExists(b));
    }

    /** Tests when the max piece is in the top right corner. */
    @Test
    public void testTopRightCorner() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 2048},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        b = new Board(rawVals);

        assertTrue("One 2048 tile on board\n" + b,
                Model.maxTileExists(b));
    }

    /** Tests when the max piece is in the top left corner. */
    @Test
    public void testTopLeftCorner() {
        int[][] rawVals = new int[][] {
                {2048, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        b = new Board(rawVals);

        assertTrue("One 2048 tile on board\n" + b,
                Model.maxTileExists(b));
    }

    /** Tests when the max piece is in the bottom left corner. */
    @Test
    public void testBottomLeftCorner() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2048, 0, 0, 0}
        };

        b = new Board(rawVals);

        assertTrue("One 2048 tile on board\n" + b,
                Model.maxTileExists(b));
    }

    /** Tests when the max piece is in the bottom right corner. */
    @Test
    public void testBottomRightCorner() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2048}
        };

        b = new Board(rawVals);

        assertTrue("One 2048 tile on board\n" + b,
                Model.maxTileExists(b));
    }

}
