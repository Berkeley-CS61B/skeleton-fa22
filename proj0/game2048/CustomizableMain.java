package game2048;

/** The main class for the 2048 game.
 *  @author P. N. Hilfinger + Josh Hug
 */
public class CustomizableMain {
    /** Probability of choosing 2 as random tile (as opposed to 4). */
    static final double TILE2_PROBABILITY = 0.9;

    /** Number of squares on the side of a board. */
    static final int BOARD_SIZE = 4;

    /** Random seed. Ignored if 0. */
    static final long RANDOM_SEED = 0;

    public static void main(String[] args) {
        boolean customStart = true;

        Model model;
        model = createCustomStartModel();

        GUI gui;

        gui = new GUI("2048 61B", model);
        gui.display(true);

        Game game = new Game(model, gui, TILE2_PROBABILITY, RANDOM_SEED);

        try {
            while (game.playing()) {
                game.playGame(customStart);

                // new games will not have a custom start
                customStart = false;
            }
        } catch (IllegalStateException excp) {
            System.err.printf("Internal error: %s%n", excp.getMessage());
            System.exit(1);
        }

        System.exit(0);
    }

    public static Model createCustomStartModel() {
        int[][] initialBoard = new int[][]{
                {2, 0, 2, 128},
                {0, 0, 8, 0},
                {8, 64, 0, 128},
                {4, 64, 8, 256},
        };
        /* Example game over board:
        int[][] initialBoard = new int[][]{
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
        };
        */

        int initialScore = 0;
        int initialMaxScore = 0;

        return new Model(initialBoard, initialScore, initialMaxScore);
    }

}
