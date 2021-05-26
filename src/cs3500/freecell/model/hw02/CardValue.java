package cs3500.freecell.model.hw02;

/**
 * An enumeration to represent card values in a deck of cards.
 */
public enum CardValue {
  ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
  JACK(11), QUEEN(12), KING(13);

  private final int value;

  /**
   * Construct the given CardValue in terms of the given integer value.
   * @param value - integer value corresponding to card value.
   */
  CardValue(int value) {
    this.value = value;
  }

  /**
   * Convert this CardValue to a string.
   * @return the CardValue as a string.
   */
  @Override
  public String toString() {
    switch (value) {
      case 1:
        return "A";
      case 11:
        return "J";
      case 12:
        return "Q";
      case 13:
        return "K";
      default:
        return Integer.toString(value);
    }
  }

  /**
   * Given an int, return the corresponding CardValue.
   * @param value - the value to convert to a card value.
   * @return the card value associated with this int.
   */
  public static CardValue intToCardValue(int value) {
    switch (value) {
      case 1:
        return CardValue.ACE;
      case 2:
        return CardValue.TWO;
      case 3:
        return CardValue.THREE;
      case 4:
        return CardValue.FOUR;
      case 5:
        return CardValue.FIVE;
      case 6:
        return CardValue.SIX;
      case 7:
        return CardValue.SEVEN;
      case 8:
        return CardValue.EIGHT;
      case 9:
        return CardValue.NINE;
      case 10:
        return CardValue.TEN;
      case 11:
        return CardValue.JACK;
      case 12:
        return CardValue.QUEEN;
      case 13:
        return CardValue.KING;
      default:
        throw new IllegalArgumentException("The value must be a number between 1 and 13.");
    }
  }

  /**
   * Convert the given CardValue to integer.
   * @return an integer corresponding to this CardValue.
   */
  public int cardValueToInt() {
    return this.value;
  }
}

