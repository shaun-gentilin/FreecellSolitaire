package cs3500.freecell.model;

import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiFreecellModel;

/**
 * Class to create a new game of freecell and distinguish between the two different types of games:
 * multi or single move.
 */
public class FreecellModelCreator {

  /**
   * Enum to represent what kind of game this will be.  One in which only one card can be moved at a
   * time, or one in which multiple cards can be moved at a time.
   */
  public enum GameType {
    SINGLEMOVE, MULTIMOVE
  }

  /**
   * Creates and returns a new model representing a game of freecell based on user input.
   * @param type - the type of game to return (multi or single move).
   * @return the new model representing the type of game we want to play.
   */
  public static SimpleFreecellModel create(GameType type) {
    switch (type) {
      case SINGLEMOVE:
        return new SimpleFreecellModel();
      case MULTIMOVE:
        return new MultiFreecellModel();
      default:
        throw new IllegalArgumentException("Not a valid game type.");
    }
  }
}
