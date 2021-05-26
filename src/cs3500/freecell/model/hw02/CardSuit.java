package cs3500.freecell.model.hw02;

/**
 * An enumeration to represent the four suits in a deck of cards.
 */
public enum CardSuit {
  SPADE("♠"), DIAMOND("♦"), HEART("♥"), CLUB("♣");

  private final String suit;

  /**
   * Construct a CardSuit given a string representing the suit.
   * @param suit - a string representing the given suit.
   */
  CardSuit(String suit) {
    this.suit = suit;
  }

  /**
   * Convert CardSuit to a string.
   * @return a string corresponding to this CardSuit.
   */
  @Override
  public String toString() {
    return this.suit;
  }
}
