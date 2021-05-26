package cs3500.freecell.model.hw02;

import java.util.Objects;

/**
 * A class to represent a card in a game of Freecell.  The number parameter represents the number on
 * the card (with 1 == Ace, 11 == Jack, 12 == Queen, and 13 == King).  The suit parameter represents
 * the suit of the card (one of Spade, Diamond, Heart, or Club).
 */
public class Card implements ICard {

  private final CardValue value;
  private final CardSuit suit;

  /**
   * Constructs a card in terms of its card number and suit.
   *
   * @param value - the number on the card (with 1 == Ace, 11 == Jack, 12 == Queen, and 13 ==
   *              King).
   * @param suit  - the suit of the card (one of Spade, Diamond, Heart, or Club).
   */
  public Card(CardValue value, CardSuit suit) {
    this.value = Objects.requireNonNull(value);
    this.suit = Objects.requireNonNull(suit);
  }

  @Override
  public CardValue getValue() {
    return this.value;
  }

  @Override
  public CardSuit getSuit() {
    return this.suit;
  }

  /**
   * Convert the value and suit of a card into their string forms.
   *
   * @return the string resulting from adding the value string to the suit string, or a null pointer
   *     exception if the Card was null.
   */
  @Override
  public String toString() {
    return this.value.toString() + this.suit;
  }

  @Override
  public boolean equals(Object other) {
    return this.suit.equals(((ICard) other).getSuit())
        && this.value.equals(((ICard) other).getValue());
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public boolean isOppositeColor(ICard that) {
    switch (this.suit) {
      case CLUB:
      case SPADE:
        return that.getSuit() == CardSuit.HEART || that.getSuit() == CardSuit.DIAMOND;
      case HEART:
      case DIAMOND:
        return that.getSuit() == CardSuit.SPADE || that.getSuit() == CardSuit.CLUB;
      default:
        throw new IllegalArgumentException("Not a valid suit.");
    }
  }
}
