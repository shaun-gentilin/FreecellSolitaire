package cs3500.freecell.model.hw02;

/**
 * Interface to hold representations of cards.
 */
public interface ICard {

  /**
   * Get the value associated with a card.
   * @return the value associated with this card as a CardValue.
   */
  CardValue getValue();

  /**
   * Get the suit associated with this card.
   * @return the suit associated with this card as a CardSuit.
   */
  CardSuit getSuit();

  boolean isOppositeColor(ICard that);
}
