package cs3500.freecell.model.hw02;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * To represent the state of the game of Freecell that is being played.
 */
public class SimpleFreecellModel implements FreecellModel<ICard> {

  private boolean isGameStarted;
  private boolean isGameOver;
  protected List<CascadingPile> cascadingPiles;
  private List<OpenPile> openPiles;
  private List<FoundationPile> foundationPiles;

  /**
   * Constructs/ initializes a game of Freecell.  Initializes all parameters to where they should be
   * before the game has been started.
   */
  public SimpleFreecellModel() {
    this.isGameStarted = false;
    this.isGameOver = false;
    this.cascadingPiles = new ArrayList<>();
    this.openPiles = new ArrayList<>();
    this.foundationPiles = new ArrayList<>();
  }

  @Override
  public List<ICard> getDeck() {
    List<ICard> deck = new ArrayList<>();

    //iterate through the 52 cards in the deck, assigning suits and values to new cards as we
    //go and adding the new cards to the deck
    for (int i = 0; i < 52; i++) {
      if (i >= 0 && i <= 12) { //clubs
        deck.add(new Card(CardValue.intToCardValue((i % 13) + 1), CardSuit.CLUB));
      } else if (i >= 13 && i <= 25) { //diamonds
        deck.add(new Card(CardValue.intToCardValue((i % 13) + 1), CardSuit.DIAMOND));
      } else if (i >= 26 && i <= 38) { //hearts
        deck.add(new Card(CardValue.intToCardValue((i % 13) + 1), CardSuit.HEART));
      } else if (i >= 39) { //spades
        deck.add(new Card(CardValue.intToCardValue((i % 13) + 1), CardSuit.SPADE));
      } else {
        break;
      }
    }
    return deck;
  }


  /**
   * See if a deck is valid for a game of Freecell.
   *
   * @param deck - the deck to be tested.
   * @return a boolean represented whether the deck is invalid or not (true if invalid, false if
   *     not).
   */
  private boolean isDeckInvalid(List<ICard> deck) {
    if (deck.size() != 52) {
      return true;
    }

    //add elements to this deck if they are not already in there so we can see if there
    // are duplicates
    List<ICard> compDeck = new ArrayList<>();
    for (int i = 0; i < 52; i++) {
      if (compDeck.contains(deck.get(i))) { //add the element if it isnt already in compDeck
        return true;
      } else {
        compDeck.add(deck.get(i));
      }
    }

    //if there were no repeated cards and the length is good then return false
    return false;
  }

  @Override
  public void startGame(List<ICard> deck, int numCascadePiles, int numOpenPiles, boolean shuffle)
      throws IllegalArgumentException {

    //set the parameter to reflect that the game has not started before exceptions are checked
    this.isGameStarted = false;

    if (this.isDeckInvalid(deck)) {
      throw new IllegalArgumentException("A deck must consist of 52 cards.");
    } else if (numCascadePiles < 4) {
      throw new IllegalArgumentException("There must be at least 4 cascade piles.");
    } else if (numOpenPiles < 1) {
      throw new IllegalArgumentException("There must be at least 1 open pile.");
    }

    //set the parameter to reflect that the game has started if there were no problems
    this.isGameStarted = true;

    //create the necessary piles
    //starting with cascade piles
    this.cascadingPiles = new ArrayList<>();
    for (int i = 0; i < numCascadePiles; i++) {
      this.cascadingPiles.add(new CascadingPile());
    }

    //next the open piles
    this.openPiles = new ArrayList<>();
    for (int i = 0; i < numOpenPiles; i++) {
      this.openPiles.add(new OpenPile());
    }

    //finally, the foundation piles (one of each suit)
    this.foundationPiles = new ArrayList<>();
    this.foundationPiles.add(new FoundationPile(CardSuit.CLUB));
    this.foundationPiles.add(new FoundationPile(CardSuit.DIAMOND));
    this.foundationPiles.add(new FoundationPile(CardSuit.HEART));
    this.foundationPiles.add(new FoundationPile(CardSuit.SPADE));

    //if we are supposed to shuffle, do it
    if (shuffle) {
      Collections.shuffle(deck);
    }

    //next, add the cards to the cascade piles
    for (int i = 0; i < 52; i++) {
      this.cascadingPiles.get(i % numCascadePiles).addCard(deck.get(i), true);
    }
  }

  /**
   * Check that the pile index is valid for the given pile type.
   * @param type - the type of pile.
   * @param index - the index of the pile to be obtained.
   * @return a boolean representing if the index is valid.
   */
  private boolean checkPileIndex(PileType type, int index) {
    switch (type) {
      case CASCADE:
        return this.cascadingPiles.size() - 1 < index;
      case OPEN:
        return this.openPiles.size() - 1 < index;
      case FOUNDATION:
        return this.foundationPiles.size() - 1 < index;
      default:
        throw new IllegalArgumentException("That is not a valid type of pile.");
    }
  }

  /**
   * Remove the last card from the specified pile.
   * @param source - the pile type to remove from.
   * @param pileNumber - the pile number to remove from.
   * @return the card that was removed.
   */
  private ICard removeFromSource(PileType source, int pileNumber) {
    switch (source) {
      case CASCADE:
        return this.cascadingPiles.get(pileNumber).removeCardFromEnd();
      case OPEN:
        return this.openPiles.get(pileNumber).removeCardFromEnd();
      case FOUNDATION:
        return this.foundationPiles.get(pileNumber).removeCardFromEnd();
      default:
        throw new IllegalArgumentException("That is not a valid type of pile.");
    }
  }

  /**
   * Add the specified card to the end of the given pile.
   * @param dest - the pile type to add the card to.
   * @param destPileNum - the pile number to add the card to.
   * @param card -the card to add to the pile.
   */
  private void addToDestination(PileType dest, int destPileNum, ICard card) {
    switch (dest) {
      case CASCADE:
        this.cascadingPiles.get(destPileNum).addCard(card);
        break;
      case OPEN:
        this.openPiles.get(destPileNum).addCard(card);
        break;
      case FOUNDATION:
        this.foundationPiles.get(destPileNum).addCard(card);
        break;
      default:
        throw new IllegalArgumentException("That is not a valid type of pile.");
    }
  }

  private boolean isLastCard(PileType source, int sourceIdx, int index) {
    //invalid if it is negative
    if (index < 0) {
      return false;
    }

    //invalid if it isn't the last card in any pile type
    switch (source) {
      case OPEN:
        if (index != 0) {
          return false;
        }
        break;
      case CASCADE:
        if (index != this.cascadingPiles.get(sourceIdx).size() - 1) {
          return false;
        }
        break;
      case FOUNDATION:
        return false; //can't move from a foundation pile, so it will always be invalid
      default:
        throw new IllegalArgumentException("That is not a valid type of pile.");
    }

    return true;
  }

  /**
   * Move a card from the given source pile to the given destination pile, if
   * the move is valid.  The move is invalid if it is moving from or to a null pile type, from
   * any foundation pile, or if it does not follow the rules of freecell when moving from one pile
   * to the other.
   *
   * @param source         the type of the source pile see @link{PileType}
   * @param pileNumber     the pile number of the given type, starting at 0
   * @param cardIndex      the index of the card to be moved from the source
   *                       pile, starting at 0
   * @param destination    the type of the destination pile (see
   * @param destPileNumber the pile number of the given type, starting at 0
   * @throws IllegalArgumentException if the move is not possible {@link
   *                                  PileType})
   * @throws IllegalStateException    if a move is attempted before the game has
   *                                  starts
   */
  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) throws IllegalArgumentException, IllegalStateException {
    if (!isGameStarted) {
      throw new IllegalStateException("Game must be started already to move.");
    } else if (pileNumber < 0 || destPileNumber < 0) {
      throw new IllegalArgumentException("Indices must not be negative.");
    }
    else if (source == null || destination == null) {
      throw new IllegalArgumentException("If source or destination pile type is null, "
          + "we cannot make a move.");
    }

    //make sure that the pile indices are fine
    if (this.checkPileIndex(source, pileNumber)
        || this.checkPileIndex(destination, destPileNumber)) {
      throw new IllegalArgumentException("There are not that many piles.");
    }

    //check that the cardIndex is valid (has to be the last card in the pile)
    if (!isLastCard(source, pileNumber, cardIndex)) {
      throw new IllegalArgumentException("We can only move the last card in the pile.");
    }

    ICard remCard = this.removeFromSource(source, pileNumber);
    this.addToDestination(destination, destPileNumber, remCard);
  }

  @Override
  public boolean isGameOver() {
    if (this.isGameOver) {
      return true;
    } else if (!this.isGameStarted) {
      return false;
    }

    for (int i = 0; i < 4; i++) {
      if (!this.foundationPiles.get(i).isFull()) {
        return false;
      }
    }
    this.isGameOver = true;
    return true;
  }

  @Override
  public int getNumCardsInFoundationPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    if (!isGameStarted) {
      throw new IllegalStateException("The game must have already been started.");
    } else if (index < 0 || index >= 4) {
      throw new IllegalArgumentException("The index is out of range.");
    }

    return this.foundationPiles.get(index).size();
  }

  @Override
  public int getNumCascadePiles() {
    if (!this.isGameStarted) {
      return -1;
    }
    return this.cascadingPiles.size();
  }

  @Override
  public int getNumCardsInCascadePile(int index)
      throws IllegalArgumentException, IllegalStateException {
    if (!isGameStarted) {
      throw new IllegalStateException("The game must have already been started.");
    } else if (index < 0 || index >= this.getNumCascadePiles()) {
      throw new IllegalArgumentException("The index is out of range.");
    }

    return this.cascadingPiles.get(index).size();
  }

  @Override
  public int getNumCardsInOpenPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    if (!this.isGameStarted) {
      throw new IllegalStateException("The game must have already been started.");
    } else if (index < 0 || index >= this.getNumOpenPiles()) {
      throw new IllegalArgumentException("The index is out of range.");
    }

    return this.openPiles.get(index).size();
  }

  @Override
  public int getNumOpenPiles() {
    if (!this.isGameStarted) {
      return -1;
    }
    return this.openPiles.size();
  }

  @Override
  public ICard getFoundationCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    if (!isGameStarted) {
      throw new IllegalStateException("The game must be started.");
    } else if (pileIndex < 0
        || cardIndex < 0
        || pileIndex >= 4
        || cardIndex >= 13) {
      throw new IllegalArgumentException("Indices are out of bounds.");
    }

    return this.foundationPiles.get(pileIndex).getCard(cardIndex);
  }

  @Override
  public ICard getCascadeCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    if (!isGameStarted) {
      throw new IllegalStateException("The game must have already started.");
    }
    else if (pileIndex < 0
        || pileIndex > this.cascadingPiles.size() - 1) {
      throw new IllegalArgumentException("Pile indices must be in the bounds of the piles.");
    }
    else if (cardIndex < 0
        || cardIndex > this.cascadingPiles.get(pileIndex).size() - 1) {
      throw new IllegalArgumentException("Card indices must "
          + "be within the bounds of the chosen pile.");
    }

    return this.cascadingPiles.get(pileIndex).getCard(cardIndex);
  }

  @Override
  public ICard getOpenCardAt(int pileIndex) throws IllegalArgumentException, IllegalStateException {
    if (!this.isGameStarted) {
      throw new IllegalStateException("The game has to be started.");
    }
    else if (pileIndex < 0
        || pileIndex > this.openPiles.size() - 1) {
      throw new IllegalArgumentException("Index is out of range for open piles.");
    }
    return this.openPiles.get(pileIndex).getCard(0);
  }
}