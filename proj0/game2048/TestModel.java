package game2048;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Tests of the Model class.
 *
 * These tests will cover all the things you've written together. You
 * shouldn't try to pass these tests until every other Test file passes.
 *
 * @author Omar Khan
 */
public class TestModel extends TestUtils {

    /*
     * ******************
     * *  TESTING TILT  *
     * ******************
     * <p>
     * The following tests determine the correctness of your `tilt`
     * method.
     */

    /** Checks that the right two pieces merge when 3 adjacent pieces have same value. */
    @Test
    public void testTripleMerge1() {
        int[][] before = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 4, 0, prevBoard, Side.NORTH);
    }

    /** Checks that the right two pieces merge when 3 adjacent pieces have same value. */
    @Test
    public void testTripleMerge2() {
        int[][] before = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.SOUTH);
        checkModel(after, 4, 0, prevBoard, Side.SOUTH);
    }

    /** Checks two adjacent merges work. */
    @Test
    public void testQuadrupleMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 2},
                {0, 0, 0, 2},
                {0, 0, 0, 2},
                {0, 0, 0, 2},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 4},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 8, 0, prevBoard, Side.NORTH);
    }

    /** Checks that a tile only merges once per tilt. */
    @Test
    public void testSingleMergeUp() {
        int[][] before = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 4, 0, prevBoard, Side.NORTH);
    }

    /** Checks that a tile only merges once per tilt. */
    @Test
    public void testSingleMergeSouth() {
        int[][] before = new int[][]{
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {4, 0, 0, 0},
        };
        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.SOUTH);
        checkModel(after, 4, 0, prevBoard, Side.SOUTH);
    }

    /** Checks that a tile only merges once per tilt. */
    @Test
    public void testSingleMergeEast() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 2, 2},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 4, 4},
        };
        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.EAST);
        checkModel(after, 4, 0, prevBoard, Side.EAST);
    }

    /** Checks that a tile only merges once per tilt. */
    @Test
    public void testSingleMergeWest() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 2, 0, 4},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 4, 0, 0},
        };
        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.WEST);
        checkModel(after, 4, 0, prevBoard, Side.WEST);
    }

    /** Checks that a tilt that causes no change returns false. */
    @Test
    public void testNoMove() {
        int[][] before = new int[][]{
                {2, 0, 2, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {2, 0, 2, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 0, 0, prevBoard, Side.NORTH);
    }

    /** Move tiles up (no merging). */
    @Test
    public void testUpNoMerge() {
        int[][] before = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 0, 0, prevBoard, Side.NORTH);
    }

    /** Move adjacent tiles up (no merging). */
    @Test
    public void testUpAdjacentNoMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 4, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 0, 0, prevBoard, Side.NORTH);
    }

    /** Move non-adjacent tiles up (no merging). */
    @Test
    public void testUpNonAdjacentNoMerge1() {
        int[][] before = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 0, 0, prevBoard, Side.NORTH);
    }

    /** Move non-adjacent tiles up (no merging); case 2: both tiles move. */
    @Test
    public void testMoveUpNonAdjacentNoMerge2() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 0, 0, prevBoard, Side.NORTH);
    }

    /** Merge adjacent tiles up. */
    @Test
    public void testUpAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 2, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 4, 0, prevBoard, Side.NORTH);
    }

    /** Merge non-adjacent tiles up. */
    @Test
    public void testUpNonAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 4, 0, prevBoard, Side.NORTH);
    }

    /** Move and merge adjacent tiles up. */
    @Test
    public void testUpAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.NORTH);
        checkModel(after, 4, 0, prevBoard, Side.NORTH);
    }

    /** Move tiles right (no merging). */
    @Test
    public void testRightNoMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 2, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 2},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.EAST);
        checkModel(after, 0, 0, prevBoard, Side.EAST);
    }

    /** Move adjacent tiles right (no merging). */
    @Test
    public void testRightAdjacentNoMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 4, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 4},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.EAST);
        checkModel(after, 0, 0, prevBoard, Side.EAST);
    }

    /** Move adjacent tiles right (no merging). */
    @Test
    public void testRightNonAdjacentNoMerge1() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 4},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 4},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.EAST);
        checkModel(after, 0, 0, prevBoard, Side.EAST);
    }

    /** Move adjacent tiles right (no merging); case 2: both tiles move. */
    @Test
    public void testRightNonAdjacentNoMerge2() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 4, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 4},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.EAST);
        checkModel(after, 0, 0, prevBoard, Side.EAST);
    }

    /** Merge adjacent tiles right. */
    @Test
    public void testRightAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 2},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.EAST);
        checkModel(after, 4, 0, prevBoard, Side.EAST);
    }

    /** Merge non-adjacent tiles right. */
    @Test
    public void testRightNonAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 2},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.EAST);
        checkModel(after, 4, 0, prevBoard, Side.EAST);
    }

    /** Move and merge adjacent tiles right. */
    @Test
    public void testRightAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 2, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.EAST);
        checkModel(after, 4, 0, prevBoard, Side.EAST);
    }

    /** Move and merge non-adjacent tiles right. */
    @Test
    public void testRightNonAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 2, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.EAST);
        checkModel(after, 4, 0, prevBoard, Side.EAST);
    }

    /** Move tiles down (no merging). */
    @Test
    public void testDownNoMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 4, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 4, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.SOUTH);
        checkModel(after, 0, 0, prevBoard, Side.SOUTH);
    }

    /** Move adjacent tiles down (no merging). */
    @Test
    public void testDownAdjacentNoMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 4, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 4, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.SOUTH);
        checkModel(after, 0, 0, prevBoard, Side.SOUTH);
    }

    /** Move non-adjacent tiles down (no merging). */
    @Test
    public void testDownNonAdjacentNoMerge1() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 4, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.SOUTH);
        checkModel(after, 0, 0, prevBoard, Side.SOUTH);
    }

    /** Merge adjacent tiles down. */
    @Test
    public void testDownAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 2, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.SOUTH);
        checkModel(after, 4, 0, prevBoard, Side.SOUTH);
    }

    /** Merge non-adjacent tiles down. */
    @Test
    public void testDownNonAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.SOUTH);
        checkModel(after, 4, 0, prevBoard, Side.SOUTH);
    }

    /** Move and merge adjacent tiles down. */
    @Test
    public void testDownAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.SOUTH);
        checkModel(after, 4, 0, prevBoard, Side.SOUTH);
    }

    /** Move and merge non-adjacent tiles down. */
    @Test
    public void testDownNonAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.SOUTH);
        checkModel(after, 4, 0, prevBoard, Side.SOUTH);
    }

    /** Move tiles left (no merging). */
    @Test
    public void testLeftNoMerge() {
        int[][] before = new int[][]{
                {4, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.WEST);
        checkModel(after, 0, 0, prevBoard, Side.WEST);
    }

    /** Move adjacent tiles left (no merging). */
    @Test
    public void testLeftAdjacentNoMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 4, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.WEST);
        checkModel(after, 0, 0, prevBoard, Side.WEST);
    }

    /** Move non-adjacent tiles left (no merging). */
    @Test
    public void testLeftNonAdjacentNoMerge1() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.WEST);
        checkModel(after, 0, 0, prevBoard, Side.WEST);
    }

    /** Merge adjacent tiles left. */
    @Test
    public void testLeftAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {2, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.WEST);
        checkModel(after, 4, 0, prevBoard, Side.WEST);
    }

    /** Merge non-adjacent tiles left. */
    @Test
    public void testLeftNonAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.WEST);
        checkModel(after, 4, 0, prevBoard, Side.WEST);
    }

    /** Move and merge adjacent tiles left. */
    @Test
    public void testLeftAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 2, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.WEST);
        checkModel(after, 4, 0, prevBoard, Side.WEST);
    }

    /** Move and merge non-adjacent tiles left. */
    @Test
    public void testLeftNonAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 2, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        updateModel(before, 0, 0, false);
        String prevBoard = model.toString();
        model.tilt(Side.WEST);
        checkModel(after, 4, 0, prevBoard, Side.WEST);
    }

    /*
     * ***********************
     * *  TESTING GAME OVER  *
     * ***********************
     * <p>
     * The following tests determine the correctness of your `checkGameOver`
     * method.
     */

    /** No tilt can cause a change. */
    @Test
    public void testGameOverNoChange1() {
        int[][] board = {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2}
        };

        updateModel(board, 0, 0, false);
        assertTrue("Game is over. No tilt would result in a change"
                + model, model.gameOver());
    }

    /** The MAX_PIECE (2048) tile is on the board. */
    @Test
    public void testGameOverMaxPiece() {
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2048}
        };

        updateModel(board, 0, 0, false);
        assertTrue("Game is over. Tile with 2048 is on board:"
                + model, model.gameOver());
    }

    /** No tilt can cause a change. */
    @Test
    public void testGameOverNoChange2() {
        int[][] board = {
                {128, 4, 2, 4},
                {4, 32, 4, 2},
                {8, 16, 2, 8},
                {4, 32, 4, 1024}
        };

        updateModel(board, 0, 0, false);
        assertTrue("Game is over. Tile with 2048 is on board:"
                + model, model.gameOver());
    }

    /** Any tilt will change the board. */
    @Test
    public void testGameNotOver1() {
        int[][] board = {
                {2, 4, 2, 2},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2}
        };
        updateModel(board, 0, 0, false);
        assertFalse("Game isn't over. Any tilt will result in a change:"
                + model, model.gameOver());
    }

    /** A tilt right or down will change the board. */
    @Test
    public void testGameNotOver2() {
        int[][] board = {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 0}
        };
        updateModel(board, 0, 0, false);
        assertFalse("Game isn't over. A tilt right or down will result"
                + " in a change:" + model, model.gameOver());
    }

    /*
     * *************************
     * *  MULTIPLE MOVE TESTS  *
     * *************************
     * <p>
     * The following tests will call the `tilt` method multiple times and check
     * the correctness of the board after each move. You shouldn't expect these
     * tests to pass until all of the above tests pass.
     */

    /** Will test multiple moves on the Model. */
    @Test
    public void testMultipleMoves1() {
        int[][] board = new int[][]{
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };

        String prevBoard;
        Side currMove;
        Tile toAdd;
        int totalScore = 0;

        updateModel(board, 0, 0, false);

        prevBoard = model.toString();
        currMove = Side.EAST;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(2, 3, 1);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.NORTH;
        totalScore += 4;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 0, 0, 4},
                {0, 0, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(2, 0, 1);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.EAST;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 0, 0, 4},
                {0, 0, 0, 2},
                {0, 0, 0, 2},
                {0, 0, 0, 0}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(4, 2, 0);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.NORTH;
        totalScore += 4;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 0, 4, 4},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(4, 0, 3);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.SOUTH;
        totalScore += 8;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 4, 8}
        }, totalScore, 0, prevBoard, currMove);
    }

    /** Will test multiple moves on the Model that end the game. */
    @Test
    public void testMultipleMoves2() {
        int[][] board = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 256, 256, 0},
                {1024, 0, 0, 512}
        };

        String prevBoard;
        Side currMove;
        Tile toAdd;
        int totalScore = 0;

        updateModel(board, 0, 0, false);

        prevBoard = model.toString();
        currMove = Side.EAST;
        totalScore += 512;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 512},
                {0, 0, 1024, 512}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(2, 0, 0);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.SOUTH;
        model.tilt(currMove);
        totalScore += 1024;
        checkModel(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 1024, 1024}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(2, 0, 1);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.WEST;
        model.tilt(currMove);
        totalScore += 2048;
        assertTrue("Game is over. Tile with 2048 is on board:"
                + model, model.gameOver());
        checkModel(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 2048, 0, 0}
        }, totalScore, totalScore, prevBoard, currMove);
    }

    /** Will test multiple moves on the Model. */
    @Test
    public void testMultipleMoves3() {
        int[][] board = new int[][]{
                {0, 2, 2, 0},
                {4, 0, 4, 0},
                {4, 0, 8, 0},
                {8, 0, 0, 0}
        };

        String prevBoard;
        Side currMove;
        Tile toAdd;
        int totalScore = 0;

        updateModel(board, 0, 0, false);

        prevBoard = model.toString();
        currMove = Side.EAST;
        totalScore += 4 + 8;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 0, 0, 4},
                {0, 0, 0, 8},
                {0, 0, 4, 8},
                {0, 0, 0, 8}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(2, 1, 2);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.SOUTH;
        totalScore += 16;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 8},
                {0, 2, 4, 16}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(2, 1, 1);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.NORTH;
        totalScore += 4;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 4, 4, 4},
                {0, 0, 0, 8},
                {0, 0, 0, 16},
                {0, 0, 0, 0}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(4, 0, 0);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.NORTH;
        model.tilt(currMove);
        checkModel(new int[][]{
                {4, 4, 4, 4},
                {0, 0, 0, 8},
                {0, 0, 0, 16},
                {0, 0, 0, 0}
        }, totalScore, 0, prevBoard, currMove);
        toAdd = Tile.create(2, 3, 0);
        model.addTile(toAdd);

        prevBoard = model.toString();
        currMove = Side.EAST;
        totalScore += 8 + 8;
        model.tilt(currMove);
        checkModel(new int[][]{
                {0, 0, 8, 8},
                {0, 0, 0, 8},
                {0, 0, 0, 16},
                {0, 0, 0, 2}
        }, totalScore, 0, prevBoard, currMove);
    }
}
