package cs3500.freecell.view;

import cs3500.freecell.model.FreecellModel;
import java.io.IOException;

/**
 * To represent the view of the freecell game we are playing.
 */
public class FreecellTextView implements FreecellView {
  private final FreecellModel<?> model;
  private Appendable out;

  /**
   * Construct a view for a game of freecell.
   * @param model - the model to be represented.
   */
  public FreecellTextView(FreecellModel<?> model) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }
    this.model = model;
  }

  /**
   * Construct a view for a game of freecell with an appendable object for output.
   * @param model - the representation we are using for this game of freecell.
   * @param out - the appendable object to be used for output.
   */
  public FreecellTextView(FreecellModel<?> model, Appendable out) {
    this(model);
    if (out == null) {
      this.out = System.out;
    }
    else {
      this.out = out;
    }
  }

  /**
   * Convert this freecelltextview to a string to be viewed by the user.
   *
   * @return the string representing this game of freecell.
   */
  public String toString() {
    if (model.getNumCascadePiles() == -1) {
      //the case where the game has not started
      return "";
    }

    //construct the string for the foundation piles
    String foundString = "";
    for (int i = 0; i < 4; i++) {
      foundString += String.format("F%d:", i + 1);
      for (int j = 0; j < model.getNumCardsInFoundationPile(i); j++) {
        if (j == 0) {
          foundString += " " + model.getFoundationCardAt(i, j).toString();
        } else {
          foundString += ", " + model.getFoundationCardAt(i, j).toString();
        }
      }
      foundString += "\n";
    }

    //construct the string for open piles
    String openString = "";
    for (int i = 0; i < model.getNumOpenPiles(); i++) {
      openString += String.format("O%d:", i + 1);
      if (model.getNumCardsInOpenPile(i) == 1) {
        openString += " " + model.getOpenCardAt(i).toString();
      }
      openString += "\n";
    }

    //construct the string for cascade piles
    String cascadeString = "";
    for (int i = 0; i < model.getNumCascadePiles(); i++) {
      cascadeString += String.format("C%d:", i + 1);
      for (int j = 0; j < model.getNumCardsInCascadePile(i); j++) {
        if (j == 0) {
          cascadeString += " " + model.getCascadeCardAt(i, j).toString();
        } else {
          cascadeString += ", " + model.getCascadeCardAt(i, j).toString();
        }
      }
      if (i + 1 != model.getNumCascadePiles()) {
        cascadeString += "\n";
      }
    }
    return foundString + openString + cascadeString;
  }

  @Override
  public void renderBoard() throws IOException {
    this.out.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.out.append(message);
  }
}
