package cs3500.freecell.controller;

import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.ICard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.view.FreecellTextView;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * This is a class to manage the playing of a game of freecell.  It will get input from
 * the user, play the game using the SimpleFreecellModel implementation created in homework 2,
 * and output the state of the game using the modified FreecellTextView implementation.
 */
public class SimpleFreecellController implements FreecellController<ICard> {
  private final SimpleFreecellModel model;
  private Readable in;
  private FreecellTextView view;

  /**
   * Constructs a controller that will allow for the input and output for a game of freecell.
   * @param model - the model used to represent this game of freecell.
   * @param in - the input stream used to get input from the user.
   * @param out - the output stream to write game outcomes to.
   * @throws IllegalArgumentException - if any of the initial arguments are null.
   */
  public SimpleFreecellController(SimpleFreecellModel model,
      Readable in, Appendable out) throws IllegalArgumentException {
    if (model == null || in == null || out == null) {
      throw new IllegalArgumentException("Inputs to the controller cannot be null.");
    }
    this.model = model;
    this.in = in;
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

  private PileType getPileType(String pile) {
    //get the first character to determine what the pile type is
    char typeChar = pile.charAt(0);

    //see if it is a valid type and return the correct PileType if it is
    switch (typeChar) {
      case 'C':
        return PileType.CASCADE;
      case 'O':
        return PileType.OPEN;
      case 'F':
        return PileType.FOUNDATION;
      default:
        throw new IllegalArgumentException("That was not a valid pile.");
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

    //run the game as long as we have input
    Scanner scanner = new Scanner(this.in);

    //set up variables and initialize them with dummy values so we can tell that they were actually
    //replaced with the correct values
    int gameCtr = 0;
    PileType sourcePileType = null;
    int sourcePileIndex = -123456;
    int cardIndex = -123456;
    PileType destPileType = null;
    int destPileIndex = -123456;
    while (scanner.hasNext()) {
      String curr = scanner.next();

      if (curr.toLowerCase().equals("q")) {
        this.renderMessageHelper("Game quit prematurely.");
        return;
      }

      switch (gameCtr) {
        case 0:
          try {
            sourcePileType = this.getPileType(curr);
          } catch (IllegalArgumentException e) {
            this.renderMessageHelper("Not a valid pile. Try again.\n");
            continue;
          }

          try {
            sourcePileIndex = Integer.parseInt(curr.substring(1)) - 1;
          } catch (NumberFormatException e) {
            this.renderMessageHelper("Not a valid pile index. Try again.\n");
            continue;
          }

          //if both of them worked, move on to the next item
          gameCtr++;
          break;
        case 1:
          try {
            cardIndex = Integer.parseInt(curr) - 1;
          } catch (NumberFormatException e) {
            this.renderMessageHelper("Not a valid card index. Try again.\n");
            continue;
          }

          //if it worked, move onto the last item
          gameCtr++;
          break;
        case 2:
          try {
            destPileType = this.getPileType(curr);
          } catch (IllegalArgumentException e) {
            this.renderMessageHelper("Not a valid pile. Try again.\n");
            continue;
          }

          try {
            destPileIndex = Integer.parseInt(curr.substring(1)) - 1;
          } catch (NumberFormatException e) {
            this.renderMessageHelper("Not a valid pile index. Try again.\n");
            continue;
          }

          //if it worked, move on to the actual move
          gameCtr++;
          break;
        default:
          gameCtr = 0;
      }

      //check if we have all the values (when gameCtr gets to 4 and they have actually been changed)
      if (gameCtr == 3
          && sourcePileType != null
          && sourcePileIndex != -123456
          && cardIndex != -123456
          && destPileType != null
          && destPileIndex != -123456) {
        try {
          this.model.move(sourcePileType, sourcePileIndex, cardIndex, destPileType, destPileIndex);
        } catch (IllegalArgumentException argumentException) {
          this.renderMessageHelper("Invalid move. Try again.\n");
          gameCtr = 0;
          continue;
        } catch (IllegalStateException stateException) {
          this.renderMessageHelper("Invalid move. Try again.\n");
          gameCtr = 0;
          continue;
        }

        //render the game after the move
        this.renderBoardHelper();
        this.renderMessageHelper("\n");

        //check if this move made the game end
        if (model.isGameOver()) {
          this.renderMessageHelper("Game over.");
          return;
        }

        gameCtr = 0;
      }
    }

    //should only get here if we ran out of input
    this.renderMessageHelper("No more input.");
    throw new IllegalStateException("No more input in readable.");
  }
}
