package game2048;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Tests the emptySpaceExists() static method of Model.
 *
 * @author Omar Khan
 */
public class TestEmptySpace {

    /** The Board that we'll be testing on. */
    static Board b;

    /** Note that this isn't a possible board state. */
    @Test
    public void testCompletelyEmpty() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals);
        assertTrue("Board is full of empty space\n" + b,
                Model.emptySpaceExists(b));
    }

    /** Tests a board that is completely full except for the top row. */
    @Test
    public void testEmptyTopRow() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
        };

        b = new Board(rawVals);

        assertTrue("Top row is empty\n" + b, Model.emptySpaceExists(b));
    }

    /** Tests a board that is completely full except for the bottom row. */
    @Test
    public void testEmptyBottomRow() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals);
        assertTrue("Bottom row is empty\n" + b,
                Model.emptySpaceExists(b));
    }


    /** Tests a board that is completely full except for the left column. */
    @Test
    public void testEmptyLeftCol() {
        int[][] rawVals = new int[][] {
                {0, 4, 2, 4},
                {0, 2, 4, 2},
                {0, 4, 2, 4},
                {0, 2, 4, 2},
        };

        b = new Board(rawVals);

        assertTrue("Left col is empty\n" + b,
                Model.emptySpaceExists(b));
    }

    /** Tests a board that is completely full except for the right column. */
    @Test
    public void testEmptyRightCol() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 0},
                {4, 2, 4, 0},
                {2, 4, 2, 0},
                {4, 2, 4, 0},
        };

        b = new Board(rawVals);

        assertTrue("Right col is empty\n" + b,
                Model.emptySpaceExists(b));
    }

    /** Tests a completely full board except one piece. */
    @Test
    public void testAlmostFullBoard() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 0, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals);

        assertTrue("Board is not full\n" + b,
                Model.emptySpaceExists(b));
    }

    /** Tests a completely full board.
     * The game isn't over since you can merge, but the emptySpaceExists method
     * should only look for empty space (and not adjacent values).
     */
    @Test
    public void testFullBoard() {
        int[][] rawVals = new int[][] {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
        };

        b = new Board(rawVals);

        assertFalse("Board is full\n" + b, Model.emptySpaceExists(b));
    }

    /** Tests a completely full board. */
    @Test
    public void testFullBoardNoMerge() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals);

        assertFalse("Board is full\n" + b, Model.emptySpaceExists(b));
    }
}