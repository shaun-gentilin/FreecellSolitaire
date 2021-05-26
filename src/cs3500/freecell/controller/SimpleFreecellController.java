package cs3500.freecell.controller;

import cs3500.freecell.model.hw02.ICard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.view.FreecellTextView;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * This is a class to manage the playing of a game of freecell.  It will get input from
 * the user, play the game using the SimpleFreecellModel implementation created in homework 2,
 * and output the state of the game using the modified FreecellTextView implementation.
 */
public class SimpleFreecellController implements FreecellController<ICard> {
  private final SimpleFreecellModel model;
  private Reader stringReader;
  private FreecellTextView view;

  /**
   * Constructs a controller that will allow for the input and output for a game of freecell.
   * @param model - the model used to represent this game of freecell.
   * @param stringReader - the input stream used to get input from the user.
   * @param out - the output stream to write game outcomes to.
   * @throws IllegalArgumentException - if any of the initial arguments are null.
   */
  public SimpleFreecellController(SimpleFreecellModel model,
      Reader stringReader, Appendable out) throws IllegalArgumentException {
    if (model == null || stringReader == null || out == null) {
      throw new IllegalArgumentException("Inputs to the controller cannot be null.");
    }
    this.model = model;
    this.stringReader = stringReader;
    this.view = new FreecellTextView(model, out);
  }

  /**
   * Send a message and catch the exceptions that may come from the method used to do it.
   * @param message - the message to send to the output.
   * @throws IllegalStateException - if the appendable failed.
   */
  private void renderMessageHelper(String message) throws IllegalStateException {
    try {
      this.view.renderMessage(message);
    } catch (IOException ioException) {
      throw new IllegalStateException("Appendable failed.");
    }
  }

  private void renderBoardHelper() {
    try {
      this.view.renderBoard();
    } catch (IOException ioException) {
      throw new IllegalStateException("Appendable failed.");
    }
  }

  @Override
  public void playGame(List<ICard> deck, int numCascades, int numOpens, boolean shuffle)
      throws IllegalStateException, IllegalArgumentException {
    if (deck == null) {
      throw new IllegalArgumentException("The deck cannot be null.");
    }

    //try to start the game, and return with a message if it was not possible
    try {
      this.model.startGame(deck, numCascades, numOpens, shuffle);
    } catch (IllegalArgumentException e) {
      this.renderMessageHelper("Could not start game.");
      return;
    }

    //show the board for the game after it has just started plus a new line
    this.renderBoardHelper();
    this.renderMessageHelper("\n");

    //run the game as long as we have input from the user/ the game has not ended
    Reader str = this.stringReader;
  }
}
