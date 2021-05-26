package cs3500.freecell.model.hw02;

import java.util.ArrayList;
import java.util.List;

/**
 * To represent a foundation pile in a game of Freecell.  This is the type of pile that cards will
 * be place in in order from A to K in order to complete the game.
 */
public class FoundationPile implements IPile<ICard> {
  protected CardSuit suit;
  protected List<ICard> pile;

  FoundationPile(CardSuit suit) {
    this.suit = suit;
    this.pile = new ArrayList<>();
  }

  @Override
  public void addCard(ICard card) throws IllegalArgumentException {
    if (this.pile.size() == 0) {
      this.suit = card.getSuit();
    }

    if (!(card.getSuit().equals(this.suit))) {
      throw new IllegalArgumentException("That is not the right suit for this pile.");
    } else if (this.pile.size() == 0) {
      if (card.getValue().equals(CardValue.ACE)) {
        this.pile.add(card);
      } else {
        throw new IllegalArgumentException("The first card is an ace you moron.");
      }
    } else {
      if (this.pile.get(this.pile.size() - 1).getValue().cardValueToInt()
          == card.getValue().cardValueToInt() - 1) { //if this is the next card in the sequence
        this.pile.add(card);
      } else {
        throw new IllegalArgumentException("That card does not come next.");
      }
    }
  }

  @Override
  public ICard removeCardFromEnd() {
    throw new IllegalCallerException("Cannot remove a card from a foundation pile.");
  }

  @Override
  public ICard getCard(int index) {
    if (index < 0 || index >= this.pile.size()) {
      throw new IllegalArgumentException("Must be a valid index to get a card.");
    }
    return this.pile.get(index);
  }

  @Override
  public int size() {
    return this.pile.size();
  }

  protected boolean isFull() {
    return this.pile.size() == 13;
  }
}
