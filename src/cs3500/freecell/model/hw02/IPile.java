package cs3500.freecell.model.hw02;

/**
 * To represent the various piles in a game of Freecell (e.g. Foundation Pile).
 * @param <T> - The implementation of Card being used.
 */
public interface IPile<T> {

  /**
   * Add this card to the end of this pile.
   * @param card - the card to add to the end of the pile.
   */
  public void addCard(T card);

  /**
   * Remove this card from the end of this pile.
   * @return the card that was removed;
   */
  public ICard removeCardFromEnd();

  /**
   * Return the card at the given index.
   * @param index - the index at which we want to retrieve a card from this pile.
   * @return the card at the given index.
   */
  public T getCard(int index);

  /**
   * To get the size of the given pile.
   * @return the size of the given pile as an int.
   */
  public int size();
}
