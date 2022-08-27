package game2048;

import ucb.gui2.LayoutSpec;
import ucb.gui2.TopLevel;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;


/** The GUI controller for a 2048 board and buttons.
 *  @author P. N. Hilfinger
 */
class GUI extends TopLevel implements Observer {

    /** A new window with given TITLE providing a view of MODEL. */
    GUI(String title, Model model) {
        super(title, true);
        addMenuButton("Game->New", this::newGame);
        addMenuButton("Game->Quit", this::quit);

        addLabel("", "Score", new LayoutSpec("y", 1));

        _model = model;
        _model.addObserver(this);

        _widget = new BoardWidget(model.size());
        add(_widget,
            new LayoutSpec("y", 0,
                           "height", "REMAINDER",
                           "width", "REMAINDER"));

        _widget.requestFocusInWindow();
        _widget.setKeyHandler("keypress", this::keyPressed);
        setPreferredFocus(_widget);
        setScore(0, 0);
    }

    /** Response to "Quit" button click. */
    public void quit(String dummy) {
        _pendingKeys.offer("Quit");
        _widget.requestFocusInWindow();
    }

    /** Response to "New Game" button click. */
    public void newGame(String dummy) {
        _pendingKeys.offer("New Game");
        _widget.requestFocusInWindow();
    }

    /** Respond to the user pressing key E by queuing the key on our
     *  queue of pending keys.*/
    public void keyPressed(String unused, KeyEvent e) {
        _pendingKeys.offer(e.getKeyCode() + "");
    }

    /** Return the next pending event, waiting for it as necessary.
     *  Ordinary key presses are reported as the key codes of the
     *  character pressed.  In addition, menu-button clicks result in
     *  the messages "Quit" or "New Game". */
    String readKey() {
        try {
            return _pendingKeys.take();
        } catch (InterruptedException excp) {
            throw new Error("unexpected interrupt");
        }
    }

    /** Return which direction arrow was pressed. */
    String getKey() {
        String command = readKey();
        switch (command) {
            case "↑" -> command = "Up";
            case "→" -> command = "Right";
            case "↓" -> command = "Down";
            case "←" -> command = "Left";
            default -> {}
        }

        return command;
    }

    /** Set the current score being displayed to SCORE and the current
     *  maximum score to MAXSCORE. */
    public void setScore(int score, int maxScore) {
        setLabel("Score", String.format("Score: %6d / Max score: %6d",
                                        score, maxScore));
    }

    /** The model notifies me that is has changed when its notifyObservers
     *  method is called, because my constructor registered me as an
     *  Observer of the model. */
    @Override
    public void update(Observable model, Object arg) {
        _widget.update(_model);
        setScore(_model.score(), _model.maxScore());
    }

    /** The board widget. */
    private final BoardWidget _widget;

    /** The game model being viewed. */
    private final Model _model;

    /** Queue of pending key presses. */
    private final ArrayBlockingQueue<String> _pendingKeys =
        new ArrayBlockingQueue<>(5);

}
