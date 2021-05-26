package cs3500.freecell.model.hw02;

import java.util.ArrayList;
import java.util.List;

/**
 * To represent a cascading pile in a game of Freecell.  This is the type of pile that will hold the
 * cards that are in play and can be moved around in order to get more cards into foundation piles.
 */
public class CascadingPile implements IPile<ICard> {
  protected List<ICard> pile;

  CascadingPile() {
    this.pile = new ArrayList<>();
  }

  /**
   * Method to add cards right after the game has started. Should ignore the regular rules of adding
   * cards for the sake of starting the game.
   * @param card - card to add to this pile.
   * @param notStarted - flag to indicate that we want to use this version of the function.
   */
  public void addCard(ICard card, boolean notStarted) {
    if (notStarted) {
      this.pile.add(card);
    }
    else {
      addCard(card);
    }
  }

  @Override
  public void addCard(ICard card) {
    if (this.pile.size() == 0) {
      this.pile.add(card);
    }
    else if (this.pile.get(this.pile.size() - 1).getValue().cardValueToInt()
        > card.getValue().cardValueToInt()
        && this.pile.get(this.pile.size() - 1).isOppositeColor(card)) {
      this.pile.add(card);
    }
    else {
      throw new IllegalArgumentException("This card cannot be added to the cascade pile.");
    }
  }

  @Override
  public ICard removeCardFromEnd() {
    if (this.pile.size() != 0) {
      return this.pile.remove(pile.size() - 1);
    }
    else {
      throw new IllegalStateException("List cannot be empty if we want to remove something.");
    }
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
}
