package cs3500.freecell.model.hw04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.CardSuit;
import cs3500.freecell.model.hw02.CardValue;
import cs3500.freecell.model.hw02.ICard;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the methods of the MultiFreecellModel class.
 */
public class MultiFreecellModelTest {

  //move TESTS


  //variables I need for these tests
  List<ICard> moveDeck;
  MultiFreecellModel moveSFCMNoStart;
  MultiFreecellModel moveSFCMGameStarted;
  MultiFreecellModel moveSFCMGameStarted1;
  MultiFreecellModel moveSFCMGameStarted2;
  MultiFreecellModel moveSFCMGameStarted3;
  MultiFreecellModel moveSFCMGameStarted4;
  MultiFreecellModel moveSFCMGameStarted5;
  MultiFreecellModel moveSFCMGameStarted6;
  MultiFreecellModel moveSFCMGameStarted7;
  MultiFreecellModel moveSFCMGameStarted8;
  MultiFreecellModel moveSFCMGameStarted9;
  MultiFreecellModel moveSFCMGameStarted10;
  MultiFreecellModel moveSFCMGameStarted11;
  MultiFreecellModel moveSFCMGameStarted12;
  MultiFreecellModel moveSFCMGameStarted13;
  MultiFreecellModel moveSFCMGameStarted14;
  MultiFreecellModel moveSFCMGameStarted15;
  MultiFreecellModel moveSFCMGameStarted16;
  MultiFreecellModel moveSFCMGameStarted17;
  MultiFreecellModel moveSFCMGameStarted18;
  MultiFreecellModel moveSFCMGameStarted19;

  Card nineOfSpades;
  Card aceOfSpades;
  Card tenOfSpades;
  Card twoOfSpades;
  Card sixOfHearts;
  Card queenOfSpades;
  Card eightOfSpades;
  Card fourOfClubs;
  Card threeOfDiamonds;
  Card twoOfClubs;

  @Before
  public void moveInit() {
    tenOfSpades = new Card(CardValue.TEN, CardSuit.SPADE);
    twoOfSpades = new Card(CardValue.TWO, CardSuit.SPADE);
    nineOfSpades = new Card(CardValue.NINE, CardSuit.SPADE);
    aceOfSpades = new Card(CardValue.ACE, CardSuit.SPADE);
    sixOfHearts = new Card(CardValue.SIX, CardSuit.HEART);
    queenOfSpades = new Card(CardValue.QUEEN, CardSuit.SPADE);
    eightOfSpades = new Card(CardValue.EIGHT, CardSuit.SPADE);

    fourOfClubs = new Card(CardValue.FOUR, CardSuit.CLUB);
    threeOfDiamonds = new Card(CardValue.THREE, CardSuit.DIAMOND);
    twoOfClubs = new Card(CardValue.TWO, CardSuit.CLUB);


    moveSFCMNoStart = new MultiFreecellModel();

    moveDeck = moveSFCMNoStart.getDeck();

    moveSFCMGameStarted = new MultiFreecellModel();
    moveSFCMGameStarted.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted1 = new MultiFreecellModel();
    moveSFCMGameStarted1.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted2 = new MultiFreecellModel();
    moveSFCMGameStarted2.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted3 = new MultiFreecellModel();
    moveSFCMGameStarted3.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted4 = new MultiFreecellModel();
    moveSFCMGameStarted4.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted5 = new MultiFreecellModel();
    moveSFCMGameStarted5.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted6 = new MultiFreecellModel();
    moveSFCMGameStarted6.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted7 = new MultiFreecellModel();
    moveSFCMGameStarted7.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted8 = new MultiFreecellModel();
    moveSFCMGameStarted8.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted9 = new MultiFreecellModel();
    moveSFCMGameStarted9.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted10 = new MultiFreecellModel();
    moveSFCMGameStarted10.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted11 = new MultiFreecellModel();
    moveSFCMGameStarted11.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted12 = new MultiFreecellModel();
    moveSFCMGameStarted12.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted13 = new MultiFreecellModel();
    moveSFCMGameStarted13.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted14 = new MultiFreecellModel();
    moveSFCMGameStarted14.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted15 = new MultiFreecellModel();
    moveSFCMGameStarted15.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted16 = new MultiFreecellModel();
    moveSFCMGameStarted16.startGame(moveDeck, 52, 4, false);

    moveSFCMGameStarted17 = new MultiFreecellModel();
    moveSFCMGameStarted17.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted18 = new MultiFreecellModel();
    moveSFCMGameStarted18.startGame(moveDeck, 8, 4, false);

    moveSFCMGameStarted19 = new MultiFreecellModel();
    moveSFCMGameStarted19.startGame(moveDeck, 52, 4, false);
  }

  /**
   * Test a move from a cascade to a foundation with a card in it already.
   */
  @Test
  public void testMoveCascToFoundationWithCard() {
    moveSFCMGameStarted15.move(PileType.CASCADE,
        7, 5, PileType.OPEN, 0);
    moveSFCMGameStarted15.move(PileType.CASCADE,
        7, 4, PileType.FOUNDATION, 0);
    moveSFCMGameStarted15.move(PileType.CASCADE,
        0, 6, PileType.OPEN, 1);
    moveSFCMGameStarted15.move(PileType.CASCADE,
        0, 5, PileType.FOUNDATION, 0);

    assertEquals(true,
        aceOfSpades.equals(moveSFCMGameStarted15.getFoundationCardAt(0, 0)));
    assertEquals(true,
        twoOfSpades.equals(moveSFCMGameStarted15.getFoundationCardAt(0, 1)));
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
   * Test a move from a foundation pile (doesn't matter where because we should never move from a
   * foundation pile.
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


  //TESTS THAT INVOLVE A MULTI MOVE
  /**
   * Test a case where we are able to successfully move one group of cards from one cascade pile to
   * another.
   */
  @Test
  public void testMultiMoveValid() {
    moveSFCMGameStarted16.move(PileType.CASCADE, 1, 0,
        PileType.CASCADE, 15);
    moveSFCMGameStarted16.move(PileType.CASCADE, 15, 0,
        PileType.CASCADE, 3);
    assertTrue(fourOfClubs.equals(moveSFCMGameStarted16.getCascadeCardAt(3, 0)));
    assertTrue(threeOfDiamonds.equals(moveSFCMGameStarted16.getCascadeCardAt(3, 1)));
    assertTrue(twoOfClubs.equals(moveSFCMGameStarted16.getCascadeCardAt(3, 2)));
  }

  /**
   * Test a case where we cannot move the cards because there are too many to move.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMultiMoveTooManyCards() {
    moveSFCMGameStarted17.move(PileType.CASCADE, 0, 0,
        PileType.CASCADE, 1);
  }

  /**
   * Test a case where we cannot move the cards because they do not form a valid build with
   * each other.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMultiMoveInvalidBuildWithEachOther() {
    moveSFCMGameStarted18.move(PileType.CASCADE, 0, 3,
        PileType.CASCADE, 1);
  }

  /**
   * Test a case where we cannot move the cards because they do not form a valid build with the
   * card they are moving to.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMultiMoveInvalidBuildWithNewCard() {
    moveSFCMGameStarted19.move(PileType.CASCADE, 1, 0,
        PileType.CASCADE, 15);
    moveSFCMGameStarted19.move(PileType.CASCADE, 15, 0,
        PileType.CASCADE, 6);
  }
}