package cs3500.freecell.model.hw02;

/**
 * To represent an open pile in a game of Freecell.  This is the type of pile where one card each
 * can be placed in order to free up other cards in cascading piles.
 */
public class OpenPile implements IPile<ICard> {
  private ICard card;

  OpenPile() {
    this.card = null;
  }

  @Override
  public void addCard(ICard card) {
    if (this.card == null) {
      this.card = card;
    }
    else {
      throw new IllegalStateException("You cannot add more than one card to an OpenPile.");
    }
  }

  @Override
  public ICard removeCardFromEnd() {
    if (this.card == null) {
      throw new IllegalStateException("Should not be moving around null cards.");
    }
    ICard retCard = this.card;
    this.card = null;
    return retCard;
  }

  @Override
  public ICard getCard(int index) {
    return this.card;
  }

  @Override
  public int size() {
    if (this.card == null) {
      return 0;
    }
    else {
      return 1;
    }
  }
}
