package cs3500.freecell.model.hw04;

import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.ICard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;

/**
 * Class to represent a game of freecell in which we are able to move multiple cards from one
 * cascade pile to another.
 */
public class MultiFreecellModel extends SimpleFreecellModel {

  /**
   * Construct a new game of multi move freecell.
   */
  public MultiFreecellModel() {
    super();
  }

  /**
   * Return the number of cards that are trying to be moved in this move.
   * @param cardIndex - the index of the top card to be move.
   * @param pileNum - the index of the pile that the cards are being moved from.
   * @return an int representing the number of cards that are to be moved in this move.
   */
  private int numCardsToMove(int cardIndex, int pileNum) {
    int totalCardsInPile = super.getNumCardsInCascadePile(pileNum);
    return totalCardsInPile - cardIndex;
  }

  /**
   * Get the number of empty open piles in the game.
   * @return an int representing the number of empty open piles in the game.
   */
  private int getNumEmptyOpenPiles() {
    int ctr = 0;
    for (int i = 0; i < super.getNumOpenPiles(); i++) {
      if (super.getNumCardsInOpenPile(i) == 0) {
        ctr++;
      }
    }
    return ctr;
  }

  /**
   * Get the number of empty cascade piles in the game.
   * @return an int representing the number of empty cascade piles in the game.
   */
  private int getNumEmptyCascadePiles() {
    int ctr = 0;
    for (int i = 0; i < super.getNumCascadePiles(); i++) {
      if (super.getNumCardsInCascadePile(i) == 0) {
        ctr++;
      }
    }
    return ctr;
  }

  /**
   * Returns whether next can be placed on prev.
   * @param prev - the card to have cards placed on it.
   * @param next - the card to be placed on prev.
   * @return a boolean representing whether next can be placed on prev.
   */
  private boolean validNextCard(ICard prev, ICard next) {
    return prev.isOppositeColor(next)
        && prev.getValue().cardValueToInt() == next.getValue().cardValueToInt() + 1;
  }

  /**
   * Move cards in a multi move game.  Delegate to the single move method if we do not need to move
   * more than one card.
   * @param source         the type of the source pile see @link{PileType}
   * @param pileNumber     the pile number of the given type, starting at 0
   * @param cardIndex      the index of the card to be moved from the source
   *                       pile, starting at 0
   * @param destination    the type of the destination pile (see
   * @param destPileNumber the pile number of the given type, starting at 0
   * @throws IllegalArgumentException if parameters did not allow for a valid move.
   * @throws IllegalStateException if parameters did not allow for a valid move.
   */
  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) throws IllegalArgumentException, IllegalStateException {
    //try to do a single move, if there is an exception, either the arguments were invalid, or we
    //simply tried to move a card that was not the last card
    boolean multiMove = false;
    String exceptionMessage;
    try {
      super.move(source, pileNumber, cardIndex, destination, destPileNumber);
    } catch (IllegalArgumentException argumentException) {
      if (!(argumentException.getMessage().equals("We can only move the last card in the pile."))) {
        throw new IllegalArgumentException("Invalid parameters.");
      }
      else { //mark that the single move did not succeed
        multiMove = true;
      }
    }

    //if the single move succeeded, stop the function
    if (!multiMove) {
      return;
    }

    //if it didn't do a multi move

    //check if we are trying to move too many cards
    int numCards = this.numCardsToMove(cardIndex, pileNumber);
    int emptyOpens = this.getNumEmptyOpenPiles();
    int emptyCascades = this.getNumEmptyCascadePiles();
    if (numCards > (emptyOpens + 1) * Math.pow(2, emptyCascades)) {
      throw new IllegalArgumentException("Too many cards to move");
    }

    //check if the cards we are trying to move will form an invalid build with the new card
    if (!(this.validNextCard(super.getCascadeCardAt(destPileNumber,
        super.getNumCardsInCascadePile(destPileNumber) - 1),
        super.getCascadeCardAt(pileNumber, cardIndex)))) {
      throw new IllegalArgumentException("Does not form a valid build with the previous card.");
    }

    //check if we are trying to move an invalid build of cards (with each other)
    for (int i = 1; i < numCards; i++) {
      if (!(this.validNextCard(super.getCascadeCardAt(pileNumber, cardIndex + i - 1),
          super.getCascadeCardAt(pileNumber, cardIndex + i)))) {
        throw new IllegalArgumentException("Cards do not form a valid build with each other.");
      }
    }

    //if it passes all the cases, do the move

    //add the new cards
    for (int i = 0; i < numCards; i++) {
      super.cascadingPiles.get(destPileNumber).addCard(
          super.getCascadeCardAt(pileNumber, cardIndex + i));
    }

    //remove the old cards
    for (int i = 0; i < numCards; i++) {
      super.cascadingPiles.get(pileNumber).removeCardFromEnd();
    }
  }
}
