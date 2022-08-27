package game2048;

/** The main class for the 2048 game.
 *  @author P. N. Hilfinger
 */
public class Main {
    /** Probability of choosing 2 as random tile (as opposed to 4). */
    static final double TILE2_PROBABILITY = 0.9;

    /** Number of squares on the side of a board. */
    static final int BOARD_SIZE = 4;

    public static void main(String[] args) {
        Model model;
        model = new Model(BOARD_SIZE);

        GUI gui;

        gui = new GUI("2048 61B", model);
        gui.display(true);

        Game game = new Game(model, gui, TILE2_PROBABILITY, 0);

        try {
            while (game.playing()) {
                game.playGame(false);
            }
        } catch (IllegalStateException excp) {
            System.err.printf("Internal error: %s%n", excp.getMessage());
            System.exit(1);
        }

        System.exit(0);
    }

}
