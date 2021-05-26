import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.CardSuit;
import cs3500.freecell.model.hw02.CardValue;
import cs3500.freecell.model.hw02.ICard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the constructor and methods for the SimpleFreecellModel class.
 */
public class SimpleFreecellModelTest {
  //CONSTRUCTOR TESTS

  SimpleFreecellModel constructorSFCM = new SimpleFreecellModel();

  /**
   * Test that the constructor worked successfully by using a method of the class.
   */
  @Test
  public void testConstructor() {
    assertEquals(-1, constructorSFCM.getNumOpenPiles());
  }


  //getDeck TESTS

  /*
   * Tests the getDeck method of the SimpleFreecellModel class.  Test that the getDeck
   * method returns the proper starting deck (should print the same deck every time).
   * Should go in number order and in suit alphabetical order (club, diamond, heart, spade).
   */

  /**
   * Test that the first suit is club and the number is in the right spot after getDeck is called.
   */
  @Test
  public void testGetDeckFirstValue() {
    assertEquals("A♣", new SimpleFreecellModel().getDeck().get(0).toString());
  }

  /**
   * Test that the values go in order (2 of clubs comes after ace) after getDeck is called.
   */
  @Test
  public void testGetDeckSecondValue() {
    assertEquals("2♣", new SimpleFreecellModel().getDeck().get(1).toString());
  }

  /**
   * Check that the next suit is in the correct order (should be diamond) after getDeck is called.
   */
  @Test
  public void testGetDeckNextSuitDiamond() {
    assertEquals("A♦", new SimpleFreecellModel().getDeck().get(13).toString());
  }

  /**
   * Check that the next suit is in the correct order (should be heart) after getDeck is called.
   */
  @Test
  public void testGetDeckNextSuitHeart() {
    assertEquals("A♥", new SimpleFreecellModel().getDeck().get(26).toString());
  }

  /**
   * Check that the next suit is in the correct order (should be heart) after getDeck is called.
   */
  @Test
  public void testGetDeckNextSuitSpade() {
    assertEquals("A♠", new SimpleFreecellModel().getDeck().get(39).toString());
  }


  //startGame TESTS


  //variables needed to run tests on this method
  SimpleFreecellModel startGameSFCMNonErrNoShuf;
  SimpleFreecellModel startGameSFCMNonErrWithShuf;
  SimpleFreecellModel startGameSFCM1;
  SimpleFreecellModel startGameSFCM2;
  SimpleFreecellModel startGameSFCM3;
  SimpleFreecellModel startGameSFCMGameAlreadyStarted;
  List<ICard> startGameDeckValid;
  List<ICard> startGameDeckInvalid;
  Card startGameTestCard;


  //Initialize some values

  /**
   * Initialize the variables needed to test the startGame method.
   */
  @Before
  public void startGameInit() {
    //variables needed to run tests on this method
    startGameSFCMNonErrNoShuf = new SimpleFreecellModel();
    startGameSFCMNonErrWithShuf = new SimpleFreecellModel();
    startGameSFCM1 = new SimpleFreecellModel();
    startGameSFCM2 = new SimpleFreecellModel();
    startGameSFCM3 = new SimpleFreecellModel();
    startGameSFCMGameAlreadyStarted = new SimpleFreecellModel();
    startGameDeckValid = startGameSFCM1.getDeck();
    startGameDeckInvalid = startGameSFCM1.getDeck();
    startGameTestCard = new Card(CardValue.ACE, CardSuit.CLUB);


    startGameSFCMNonErrNoShuf.startGame(startGameDeckValid,
        8, 4, false);
    startGameSFCMNonErrWithShuf.startGame(startGameDeckValid,
        8, 4, true);

  }


  //check that values for the class are correct after the game has started



  /**
   * Check that the cascadingPiles parameter is no longer null after the game has been started.
  */
  @Test
  public void testStartGameCascadingPilesNonNull() {
    assertEquals(true,
        nineOfSpades.equals(startGameSFCMNonErrNoShuf.getCascadeCardAt(7,5)));
  }



  /**
   * Check that cards were put in the right place if there was no shuffling of the deck.
   */
  @Test
  public void testStartGameCascadingPilesCorrectNoShuf() {
    assertEquals(startGameTestCard.getSuit(), startGameSFCMNonErrNoShuf.getCascadeCardAt(0,
        0).getSuit());
    assertEquals(startGameTestCard.getValue(), startGameSFCMNonErrNoShuf.getCascadeCardAt(
        0,0).getValue());
  }

  /**
   * Check that cards were not put in the same place if there was shuffling of the deck.
   */
  @Test
  public void testStartGameCascadingPilesDifferentAfterShuf() {
    assertNotEquals(startGameTestCard, startGameSFCMNonErrWithShuf.getCascadeCardAt(0,
        0));
  }

  //Tests that should throw exceptions
  /**
   * Test if the startGame method returns an exception if the deck is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameInvalidDeck() {
    startGameDeckInvalid.add(startGameTestCard);
    startGameSFCM1.startGame(startGameDeckInvalid, 8, 4, false);
  }

  /**
   * Test if the startGame method returns an exception if the number of cascade piles is less than
   * 4.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameInvalidNumCascPiles() {
    startGameSFCM2.startGame(startGameDeckValid, 2, 4, false);
  }

  /**
   * Test if the startGame method returns an exception if the number of open piles is less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameInvalidNumOpenPiles() {
    startGameSFCM3.startGame(startGameDeckValid, 8, 0, false);
  }


  //getCascadeCardAt TESTS


  SimpleFreecellModel getCascadeCardAtSFCMNoStart;
  SimpleFreecellModel getCascadeCardAtSFCMGameStarted;
  List<ICard> getCascadeCardAtDeck;
  Card getCascadeCardAtTestCard1;
  Card getCascadeCardAtTestCard2;


  /**
   * Initialize variables for the getCascadeCardAt method tests.
   */
  @Before
  public void getCascadeCardAtInit() {
    getCascadeCardAtSFCMNoStart = new SimpleFreecellModel();

    getCascadeCardAtSFCMGameStarted = new SimpleFreecellModel();
    getCascadeCardAtDeck = getCascadeCardAtSFCMGameStarted.getDeck();
    getCascadeCardAtSFCMGameStarted.startGame(getCascadeCardAtDeck,
        8, 4, false);

    getCascadeCardAtTestCard1 = new Card(CardValue.ACE, CardSuit.CLUB);
    getCascadeCardAtTestCard2 = new Card(CardValue.TWO, CardSuit.CLUB);

  }

  /**
   * Test that the method returns the correct value on a non-shuffled deck (because we know what
   * the value should be).
   */
  @Test
  public void testGetCascadeCardAtGameStarted() {
    assertEquals(getCascadeCardAtTestCard1.getSuit(),
        getCascadeCardAtSFCMGameStarted.getCascadeCardAt(0,0).getSuit());
    assertEquals(getCascadeCardAtTestCard1.getValue(),
        getCascadeCardAtSFCMGameStarted.getCascadeCardAt(0,0).getValue());
  }

  /**
   * Test that the next card is also returned correctly.
   */
  @Test
  public void testGetCascadeCardAtGameStartedNextCard() {
    assertEquals(getCascadeCardAtTestCard2.getSuit(),
        getCascadeCardAtSFCMGameStarted.getCascadeCardAt(1,0).getSuit());
    assertEquals(getCascadeCardAtTestCard2.getValue(),
        getCascadeCardAtSFCMGameStarted.getCascadeCardAt(1,0).getValue());
  }

  //TESTS THAT SHOULD RETURN EXCEPTIONS
  /**
   * Check that the method returns an illegal state exception if the game has not been started yet.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetCascadeCardAtGameNotStarted() {
    getCascadeCardAtSFCMNoStart.getCascadeCardAt(0,0);
  }

  /**
   * Check that the method throws an illegal argument exception if pileIndex is too low.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetCascadeCardAtPileIndexTooLow() {
    getCascadeCardAtSFCMGameStarted.getCascadeCardAt(-1, 0);
  }

  /**
   * Check that the method throws an illegal argument exception if cardIndex is too low.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetCascadeCardAtCardIndexTooLow() {
    getCascadeCardAtSFCMGameStarted.getCascadeCardAt(0, -1);
  }

  /**
   * Check that the method throws an illegal argument exception if pileIndex is too high.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetCascadeCardAtPileIndexTooHigh() {
    getCascadeCardAtSFCMGameStarted.getCascadeCardAt(200, 0);
  }

  /**
   * Check that the method throws an illegal argument exception if cardIndex is too high.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetCascadeCardAtCardIndexTooHigh() {
    getCascadeCardAtSFCMGameStarted.getCascadeCardAt(0, 200);
  }


  //isGameOver TESTS


  //variables to use in these tests
  SimpleFreecellModel isGameOverSFCMGameStartedNotDone;
  SimpleFreecellModel isGameOverSFCMNotStarted;
  SimpleFreecellModel getIsGameOverSFCMGameStartedDone;
  SimpleFreecellModel getIsGameOverSFCMGameAlreadyOver;
  List<ICard> isGameOverDeck;
  Card isGameOverCard;

  /**
   * Initialize the objects/variables needed for these tests.
   */
  @Before
  public void isGameOverInit() {
    isGameOverCard = new Card(CardValue.NINE, CardSuit.DIAMOND);

    isGameOverSFCMNotStarted = new SimpleFreecellModel();

    isGameOverSFCMGameStartedNotDone = new SimpleFreecellModel();
    isGameOverDeck = isGameOverSFCMGameStartedNotDone.getDeck();
    isGameOverSFCMGameStartedNotDone.startGame(isGameOverDeck,
        8, 4, false);

    getIsGameOverSFCMGameStartedDone = new SimpleFreecellModel();
    getIsGameOverSFCMGameStartedDone.startGame(isGameOverDeck,
        52, 4, false);
    for (int i = 0; i < 52; i++) {
      getIsGameOverSFCMGameStartedDone.move(PileType.CASCADE, i, 0,
          PileType.FOUNDATION, i / 13);
    }
  }

  /**
   * Test to see that the method returns false is the game has not started.
   */
  @Test
  public void testIsGameOverGameNotStarted() {
    assertEquals(false, isGameOverSFCMNotStarted.isGameOver());
  }


  /**
   * Check to see that if all the foundation piles are full, the method returns true.
  */
  @Test
  public void testIsGameOverGameStartedAndFinished() {
    assertEquals(true, getIsGameOverSFCMGameStartedDone.isGameOver());
  }



  /**
   * Check to see that the method returns false if the game has started but the piles are not full.
   */
  @Test
  public void testIsGameOverGameStartedNotFinished() {
    assertEquals(false, isGameOverSFCMGameStartedNotDone.isGameOver());
  }


  //move TESTS


  //variables I need for these tests
  List<ICard> moveDeck;
  SimpleFreecellModel moveSFCMNoStart;
  SimpleFreecellModel moveSFCMGameStarted;
  SimpleFreecellModel moveSFCMGameStarted1;
  SimpleFreecellModel moveSFCMGameStarted2;
  SimpleFreecellModel moveSFCMGameStarted3;
  SimpleFreecellModel moveSFCMGameStarted4;
  SimpleFreecellModel moveSFCMGameStarted5;
  SimpleFreecellModel moveSFCMGameStarted6;
  SimpleFreecellModel moveSFCMGameStarted7;
  SimpleFreecellModel moveSFCMGameStarted8;
  SimpleFreecellModel moveSFCMGameStarted9;
  SimpleFreecellModel moveSFCMGameStarted10;
  SimpleFreecellModel moveSFCMGameStarted11;
  SimpleFreecellModel moveSFCMGameStarted12;
  SimpleFreecellModel moveSFCMGameStarted13;
  SimpleFreecellModel moveSFCMGameStarted14;


  Card nineOfSpades;
  Card aceOfSpades;
  Card tenOfSpades;
  Card twoOfSpades;
  Card sixOfHearts;
  Card queenOfSpades;
  Card eightOfSpades;

  @Before
  public void moveInit() {
    tenOfSpades = new Card(CardValue.TEN, CardSuit.SPADE);
    twoOfSpades = new Card(CardValue.TWO, CardSuit.SPADE);
    nineOfSpades = new Card(CardValue.NINE, CardSuit.SPADE);
    aceOfSpades = new Card(CardValue.ACE, CardSuit.SPADE);
    sixOfHearts = new Card(CardValue.SIX, CardSuit.HEART);
    queenOfSpades = new Card(CardValue.QUEEN, CardSuit.SPADE);
    eightOfSpades = new Card(CardValue.EIGHT, CardSuit.SPADE);


    moveSFCMNoStart = new SimpleFreecellModel();

    moveDeck = moveSFCMNoStart.getDeck();

    moveSFCMGameStarted = new SimpleFreecellModel();
    moveSFCMGameStarted.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted1 = new SimpleFreecellModel();
    moveSFCMGameStarted1.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted2 = new SimpleFreecellModel();
    moveSFCMGameStarted2.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted3 = new SimpleFreecellModel();
    moveSFCMGameStarted3.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted4 = new SimpleFreecellModel();
    moveSFCMGameStarted4.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted5 = new SimpleFreecellModel();
    moveSFCMGameStarted5.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted6 = new SimpleFreecellModel();
    moveSFCMGameStarted6.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted7 = new SimpleFreecellModel();
    moveSFCMGameStarted7.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted8 = new SimpleFreecellModel();
    moveSFCMGameStarted8.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted9 = new SimpleFreecellModel();
    moveSFCMGameStarted9.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted10 = new SimpleFreecellModel();
    moveSFCMGameStarted10.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted11 = new SimpleFreecellModel();
    moveSFCMGameStarted11.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted12 = new SimpleFreecellModel();
    moveSFCMGameStarted12.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted13 = new SimpleFreecellModel();
    moveSFCMGameStarted13.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted14 = new SimpleFreecellModel();
    moveSFCMGameStarted14.startGame(moveDeck, 8, 4, false);
  }

  /**
   * Test a move from a cascade pile to an open pile.
   */
  @Test
  public void testMoveCascToOpen() {
    moveSFCMGameStarted1.move(PileType.CASCADE,
        0, 6, PileType.OPEN, 0);

    assertEquals(true, tenOfSpades.equals(moveSFCMGameStarted1.getOpenCardAt(0)));
    assertEquals(true, twoOfSpades.equals(moveSFCMGameStarted1.getCascadeCardAt(0,
        5)));
  }

  /**
   * Test a move from a cascade pile to a valid foundation pile.
   */
  @Test
  public void testMoveCascToFoundValid() {
    moveSFCMGameStarted2.move(PileType.CASCADE,
        7, 5, PileType.OPEN, 0);
    moveSFCMGameStarted2.move(PileType.CASCADE,
        7, 4, PileType.FOUNDATION, 3);

    assertEquals(true,
        nineOfSpades.equals(moveSFCMGameStarted2.getOpenCardAt(0)));
    assertEquals(true,
        aceOfSpades.equals(moveSFCMGameStarted2.getFoundationCardAt(3, 0)));
    assertEquals(true,
        sixOfHearts.equals(moveSFCMGameStarted2.getCascadeCardAt(7, 3)));
  }

  /**
   * Test a move from an open pile with a card in it to a valid cascade pile.
   */
  @Test
  public void testMoveFromOpenWithCardToValidCascade() {
    moveSFCMGameStarted5.move(PileType.CASCADE,
        6, 5, PileType.OPEN, 0);
    moveSFCMGameStarted5.move(PileType.CASCADE,
        2, 6, PileType.OPEN, 1);
    moveSFCMGameStarted5.move(PileType.OPEN,
        1, 0, PileType.CASCADE, 6);

    assertEquals(true,
        queenOfSpades.equals(moveSFCMGameStarted5.getCascadeCardAt(6, 5)));
  }

  /**
   * Test a move from a cascade pile to a valid cascade pile.
   */
  @Test
  public void testMoveFromCascadeToValidCascade() {
    moveSFCMGameStarted6.move(PileType.CASCADE,
        6, 5, PileType.OPEN, 0);
    moveSFCMGameStarted6.move(PileType.CASCADE,
        2, 6, PileType.CASCADE, 6);

    assertEquals(true,
        queenOfSpades.equals(moveSFCMGameStarted6.getCascadeCardAt(6, 5)));
  }

  /**
   * Test a move from an open pile with card to an open pile without card.
   */
  @Test
  public void testMoveOpenWithToOpenWithout() {
    moveSFCMGameStarted8.move(PileType.CASCADE,
        6, 5, PileType.OPEN, 0);
    moveSFCMGameStarted8.move(PileType.OPEN,
        0, 0, PileType.OPEN, 1);

    assertEquals(true, eightOfSpades.equals(moveSFCMGameStarted8.getOpenCardAt(1)));
  }



  /**
   * Test a move from an open pile to a valid foundation pile.
   */
  @Test
  public void testMoveOpenToValidFoundation() {
    moveSFCMGameStarted13.move(PileType.CASCADE,
        7, 5, PileType.OPEN, 0);
    moveSFCMGameStarted13.move(PileType.CASCADE,
        7, 4, PileType.OPEN, 1);
    moveSFCMGameStarted13.move(PileType.OPEN,
        1, 0, PileType.FOUNDATION, 3);

    assertEquals(true,
        aceOfSpades.equals(moveSFCMGameStarted13.getFoundationCardAt(3, 0)));
  }

  //TESTS THAT SHOULD THROW EXCEPTIONS

  /**
   * Test a move from an open pile without card to an open pile without card.
   */
  @Test(expected = IllegalStateException.class)
  public void testMoveOpenWithoutToOpenWithout() {
    moveSFCMGameStarted9.move(PileType.OPEN,
        0, 0, PileType.OPEN, 1);

    assertEquals(null, moveSFCMGameStarted9.getOpenCardAt(0));
    assertEquals(null, moveSFCMGameStarted9.getOpenCardAt(1));
  }

  /**
   * Test a move from a foundation pile (doesn't matter where because we should never move from
   * a foundation pile.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromFoundation() {
    moveSFCMGameStarted14.move(PileType.FOUNDATION,
        0, 0, PileType.OPEN, 0);
  }

  /**
   * Test a move from an open pile with a card in it to a non-valid cascade pile.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOpenWithToNonValidCascade() {
    moveSFCMGameStarted12.move(PileType.CASCADE,
        0, 0, PileType.OPEN, 0);
    moveSFCMGameStarted12.move(PileType.OPEN,
        0, 0, PileType.CASCADE, 0);
  }

  /**
   * Test a move from an open pile without card to an open pile with card.
   */
  @Test(expected = IllegalStateException.class)
  public void testMoveOpenWithoutToOpenWith() {
    moveSFCMGameStarted10.move(PileType.CASCADE,
        0, 6, PileType.OPEN, 1);
    moveSFCMGameStarted10.move(PileType.OPEN,
        0, 0, PileType.OPEN, 1);
  }

  /**
   * Test a move from an open pile with card to an open pile with card.
   */
  @Test(expected = IllegalStateException.class)
  public void testMoveOpenWithToOpenWith() {
    moveSFCMGameStarted11.move(PileType.CASCADE,
        0, 6, PileType.OPEN, 1);
    moveSFCMGameStarted11.move(PileType.CASCADE,
        6, 5, PileType.OPEN, 0);
    moveSFCMGameStarted11.move(PileType.OPEN,
        0, 0, PileType.OPEN, 1);
  }

  /**
   * Test a move from a cascade pile to an invalid cascade pile.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveCascToCascInvalid() {
    moveSFCMGameStarted7.move(PileType.CASCADE,
        2, 0, PileType.CASCADE, 3);
  }


  /**
   * Test a move from a cascade pile to an invalid foundation pile (based on the value).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveCascToFoundInvalidValue() {
    moveSFCMGameStarted4.move(PileType.CASCADE,
        7, 0, PileType.OPEN, 0);
    moveSFCMGameStarted4.move(PileType.CASCADE,
        7, 0, PileType.FOUNDATION, 3);
    moveSFCMGameStarted4.move(PileType.CASCADE,
        3, 0, PileType.FOUNDATION, 3);
  }

  /**
   * Check that the method throws an exception if the game has not started.
   */
  @Test(expected = IllegalStateException.class)
  public void testMoveGameNotStarted() {
    moveSFCMNoStart.move(PileType.CASCADE,
        0, 0, PileType.CASCADE, 0);
  }

  /**
   * Check that the method throws an exception if the source pile index is too low.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveSourcePileIndexTooLow() {
    moveSFCMGameStarted.move(PileType.CASCADE,
        -1, 0, PileType.OPEN, 0);
  }

  /**
   * Check that the method throws an exception if the source pile index is too high.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveSourcePileIndexTooHigh() {
    moveSFCMGameStarted.move(PileType.CASCADE,
        10, 0, PileType.OPEN, 0);
  }

  /**
   * Check that the method throws an exception if the destination pile index is too low.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveDestPileIndexTooLow() {
    moveSFCMGameStarted.move(PileType.CASCADE,
        0, 0, PileType.OPEN, -1);
  }

  /**
   * Check that the method throws an exception if the destination pile index is too high.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveDestPileIndexTooHigh() {
    moveSFCMGameStarted.move(PileType.CASCADE,
        0, 0, PileType.OPEN, 10);
  }


  //getOpenCardAt TESTS


  //variables needed
  List<ICard> getOpenCardAtDeck;
  SimpleFreecellModel getOpenCardAtSFCM1;
  SimpleFreecellModel getOpenCardAtSFCM2;

  @Before
  public void testGetOpenCardAtInit() {
    getOpenCardAtSFCM1 = new SimpleFreecellModel();
    getOpenCardAtSFCM2 = new SimpleFreecellModel();

    getOpenCardAtDeck = getOpenCardAtSFCM1.getDeck();

    getOpenCardAtSFCM1.startGame(getOpenCardAtDeck, 8, 4, false);
    getOpenCardAtSFCM2.startGame(getOpenCardAtDeck, 8, 4, false);
  }

  /**
   * Test getting a value from a non empty pile.
   */
  @Test
  public void testGetOpenCardAtNonEmptyPile() {
    getOpenCardAtSFCM1.move(PileType.CASCADE,
        7, 5, PileType.OPEN, 0);

    assertEquals(true,
        nineOfSpades.equals(getOpenCardAtSFCM1.getOpenCardAt(0)));
  }

  /**
   * Test getting a value from an empty pile (should return null).
   */
  @Test
  public void testGetOpenCardAtEmptyPile() {
    assertEquals(null, getOpenCardAtSFCM2.getOpenCardAt(0));
  }



  //getNumCardsInFoundationPile TESTS

  SimpleFreecellModel getNumCardsInFoundationPileSFCM1;
  SimpleFreecellModel getNumCardsInFoundationPileSFCM2;

  List<ICard> getNumCardsInFoundationPileDeck;


  /**
   * Initialize variables for these tests.
   */
  @Before
  public void testGetNumCardsInFoundationPileInit() {
    getNumCardsInFoundationPileSFCM1 = new SimpleFreecellModel();

    getNumCardsInFoundationPileDeck = getNumCardsInFoundationPileSFCM1.getDeck();

    getNumCardsInFoundationPileSFCM2 = new SimpleFreecellModel();
    getNumCardsInFoundationPileSFCM2.startGame(getNumCardsInFoundationPileDeck,
        8, 4, false);
  }

  /**
   * Test case where game has already started.
   */
  @Test
  public void testGetNumCardsInFoundationPileGameAlreadyStarted() {
    assertEquals(0, getNumCardsInFoundationPileSFCM2.getNumCardsInFoundationPile(0));
  }

  //tests that should throw exceptions
  /**
   * Test case where index is too low.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetNumCardsInFoundationPileStartedIndexTooLow() {
    getNumCardsInFoundationPileSFCM2.getNumCardsInFoundationPile(-1);
  }

  /**
   * Test case where index is too high.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetNumCardsInFoundationPileStartedIndexTooHigh() {
    getNumCardsInFoundationPileSFCM2.getNumCardsInFoundationPile(10);
  }

  /**
   * Test case where game has not started.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetNumCardsInFoundationPileNotStarted() {
    getNumCardsInFoundationPileSFCM1.getNumCardsInFoundationPile(2);
  }


  //getNumCascadePiles TESTS

  List<ICard> getNumCascadePilesDeck;
  SimpleFreecellModel getNumCascadePilesSFCM1;
  SimpleFreecellModel getNumCascadePilesSFCM2;


  /**
   * Initialize variables for these tests.
   */
  @Before
  public void testGetNumCascadePilesInit() {
    getNumCascadePilesSFCM1 = new SimpleFreecellModel();

    getNumCascadePilesDeck = getNumCascadePilesSFCM1.getDeck();

    getNumCascadePilesSFCM2 = new SimpleFreecellModel();
    getNumCascadePilesSFCM2.startGame(getNumCascadePilesDeck, 8, 4, false);

  }

  /**
   * Test that correct value is returned after game has started.
   */
  @Test
  public void testGetNumCascadePilesStarted() {
    assertEquals(8, getNumCascadePilesSFCM2.getNumCascadePiles());
  }

  /**
   * Test that exception is thrown when game has not started.
   */
  @Test
  public void testGetNumCascadePilesNotStarted() {
    assertEquals(-1, getNumCascadePilesSFCM1.getNumCascadePiles());
  }


  //getNumCardsInCascadePile TESTS

  List<ICard> getNumCardsInCascadePileDeck;
  SimpleFreecellModel getNumCardsInCascadePileSFCM1;
  SimpleFreecellModel getNumCardsInCascadePileSFCM2;

  /**
   * Variable initializations for these tests.
   */
  @Before
  public void testGetNumCardsInCascadePileInit() {
    getNumCardsInCascadePileSFCM1 = new SimpleFreecellModel();

    getNumCardsInCascadePileDeck = getNumCardsInCascadePileSFCM1.getDeck();

    getNumCardsInCascadePileSFCM2 = new SimpleFreecellModel();
    getNumCardsInCascadePileSFCM2.startGame(getNumCardsInCascadePileDeck,
        8, 4, false);

  }

  /**
   * Test that the correct number of cards is returned after the game has started.
   */
  @Test
  public void testGetNumCardsInCascadePileGameStartedValid() {
    assertEquals(7, getNumCardsInCascadePileSFCM2.getNumCardsInCascadePile(0));
  }

  //tests for exceptions
  /**
   * Test that exception is thrown if index is too high.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetNumCardsInCascadePileGameStartedIndexTooHigh() {
    getNumCardsInCascadePileSFCM2.getNumCardsInCascadePile(10);
  }

  /**
   * Test that exception is thrown if index is too low.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetNumCardsInCascadePileGameStartedIndexTooLow() {
    getNumCardsInCascadePileSFCM2.getNumCardsInCascadePile(-3);
  }

  /**
   * Test that the exception is thrown if the game has not yet started.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetNumCardsInCascadePileGameNotStarted() {
    getNumCardsInCascadePileSFCM1.getNumCardsInCascadePile(3);
  }


  //getNumCardsInOpenPile TESTS

  List<ICard> getNumCardsInOpenPileDeck;
  SimpleFreecellModel getNumCardsInOpenPileSFCM1;
  SimpleFreecellModel getNumCardsInOpenPileSFCM2;

  /**
   * Initialize variables for this set of tests.
   */
  @Before
  public void testGetNumCardsInOpenPileInit() {
    getNumCardsInOpenPileSFCM1 = new SimpleFreecellModel();

    getNumCardsInOpenPileDeck = getNumCardsInOpenPileSFCM1.getDeck();

    getNumCardsInOpenPileSFCM2 = new SimpleFreecellModel();
    getNumCardsInOpenPileSFCM2.startGame(getNumCardsInOpenPileDeck, 8, 4, false);
  }

  /**
   * Test where game has started.
   */
  @Test
  public void testGetNumCardsInOpenPileGameStarted() {
    assertEquals(0, getNumCardsInOpenPileSFCM2.getNumCardsInOpenPile(0));
  }

  //exception tests
  /**
   * Test where game has not started.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetNumCardsInOpenPileGameNotStarted() {
    getNumCardsInOpenPileSFCM1.getNumCardsInOpenPile(0);
  }

  /**
   * Test where game has started but index is too low.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetNumCardsInOpenPileGameStartedIndexTooLow() {
    getNumCardsInOpenPileSFCM2.getNumCardsInOpenPile(-4);
  }

  /**
   * Test wehre the game has started but index is too high.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetNumCardsInOpenPileGameStartedIndexTooHigh() {
    getNumCardsInOpenPileSFCM2.getNumCardsInOpenPile(10);
  }


  //getNumOpenPiles TESTS

  List<ICard> getNumOpenPilesDeck;
  SimpleFreecellModel getNumOpenPilesSFCM1;
  SimpleFreecellModel getNumOpenPilesSFCM2;

  /**
   * Initialize variables for this set of tests.
   */
  @Before
  public void testGetNumOpenPilesInit() {
    getNumOpenPilesSFCM1 = new SimpleFreecellModel();

    getNumOpenPilesDeck = getNumOpenPilesSFCM1.getDeck();

    getNumOpenPilesSFCM2 = new SimpleFreecellModel();
    getNumOpenPilesSFCM2.startGame(getNumOpenPilesDeck, 8, 4, false);
  }

  /**
   * Test the case where the game has started.
   */
  @Test
  public void testGetNumOpenPilesGameStarted() {
    assertEquals(4, getNumOpenPilesSFCM2.getNumOpenPiles());
  }

  /**
   * Test the case where the game has not started.
   */
  @Test
  public void testGetNumOpenPilesGameNotStarted() {
    assertEquals(-1, getNumOpenPilesSFCM1.getNumOpenPiles());
  }


  //getFoundationCardAt TESTS

  List<ICard> getFoundationCardAtDeck;
  SimpleFreecellModel getFoundationCardAtSFCM1;
  SimpleFreecellModel getFoundationCardAtSFCM2;

  /**
   * Initialize variables for this set of tests.
   */
  @Before
  public void testGetFoundationCardAtInit() {
    getFoundationCardAtSFCM1 = new SimpleFreecellModel();

    getFoundationCardAtDeck = getFoundationCardAtSFCM1.getDeck();

    getFoundationCardAtSFCM2 = new SimpleFreecellModel();
    getFoundationCardAtSFCM2.startGame(moveDeck, 8, 4, false);
    getFoundationCardAtSFCM2.move(PileType.CASCADE,
        7, 5, PileType.OPEN, 0);
    getFoundationCardAtSFCM2.move(PileType.CASCADE,
        7, 4, PileType.FOUNDATION, 3);
  }

  /**
   * Test the case where the game has started.
   */
  @Test
  public void testGetFoundationCardAtGameStarted() {
    assertEquals(true,
        aceOfSpades.equals(getFoundationCardAtSFCM2.getFoundationCardAt(3, 0)));
  }

  //exception tests
  /**
   * Test the case where the game hasnt started.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetFoundationCardAtGameNotStarted() {
    getFoundationCardAtSFCM1.getFoundationCardAt(0,0);
  }

  /**
   * Test the case where the pileIndex is too low.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetFoundationCardAtGameStartedPileIndexTooLow() {
    getFoundationCardAtSFCM2.getFoundationCardAt(-1, 0);
  }

  /**
   * Test the case where the pileIndex is too high.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetFoundationCardAtGameStartedPileIndexTooHigh() {
    getFoundationCardAtSFCM2.getFoundationCardAt(10, 0);
  }

  /**
   * Test the case where the cardIndex is too low.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetFoundationCardAtGameStartedCardIndexTooLow() {
    getFoundationCardAtSFCM2.getFoundationCardAt(3, -4);
  }

  /**
   * Test the case where the cardIndex is too high.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetFoundationCardAtGameStartedCardIndexTooHigh() {
    getFoundationCardAtSFCM2.getFoundationCardAt(3, 15);
  }
}

