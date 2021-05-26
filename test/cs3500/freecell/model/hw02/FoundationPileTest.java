package cs3500.freecell.model.hw02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the methods for the FoundationPile class.
 */
public class FoundationPileTest {


  //addCard TESTS

  //variables needed
  FoundationPile foundPileSpadeEmpty1;
  FoundationPile foundPileSpadeEmpty2;
  FoundationPile foundPileSpadeNonEmpty;
  FoundationPile foundPileHeart;

  Card aceOfSpades;
  Card aceOfHearts;
  Card twoOfSpades;


  /**
   * Initialize variables needed for these tests.
   */
  @Before
  public void testAddCardInit() {
    aceOfSpades = new Card(CardValue.ACE, CardSuit.SPADE);
    twoOfSpades = new Card(CardValue.TWO, CardSuit.SPADE);
    aceOfHearts = new Card(CardValue.ACE, CardSuit.HEART);


    foundPileSpadeEmpty1 = new FoundationPile(CardSuit.SPADE);
    foundPileSpadeEmpty2 = new FoundationPile(CardSuit.SPADE);
    foundPileHeart = new FoundationPile(CardSuit.HEART);

    foundPileSpadeNonEmpty = new FoundationPile(CardSuit.SPADE);
    foundPileSpadeNonEmpty.pile.add(aceOfSpades);
  }

  /**
   * Test adding a valid card to a non empty foundation pile.
   */
  @Test
  public void testAddCardNonEmptyFoundPileValid() {
    foundPileSpadeNonEmpty.addCard(twoOfSpades);
    assertEquals(twoOfSpades, foundPileSpadeNonEmpty.getCard(1));
  }

  /**
   * Test adding a valid card to an empty foundation pile.
   */
  @Test
  public void testAddCardEmptyFoundPileValid() {
    foundPileSpadeEmpty1.addCard(aceOfSpades);
    assertEquals(aceOfSpades, foundPileSpadeEmpty1.getCard(0));
  }

  //tests that should throw exceptions

  /**
   * Test adding an invalid card to a foundation pile (wrong value).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddCardEmptyWrongValue() {
    foundPileSpadeEmpty2.addCard(twoOfSpades);
  }


  //removeCardFromEnd TESTS

  CascadingPile removeCardFromEnd = new CascadingPile();

  /**
   * Test removing a card (should always throw an exceptions because we cannot remove a card that
   * is already in a cascade pile).
   */
  @Test(expected = IllegalStateException.class)
  public void testRemoveCardFromEndTest() {
    removeCardFromEnd.removeCardFromEnd();
  }


  //getCard TESTS


  //variables needed for these tests
  FoundationPile getCardPile1 = new FoundationPile(CardSuit.CLUB);
  FoundationPile getCardPile2 = new FoundationPile(CardSuit.CLUB);

  Card aceOfClubs = new Card(CardValue.ACE, CardSuit.CLUB);

  /**
   * Test getting a card from a non-empty pile.
   */
  @Test
  public void testGetCardNonEmpty() {
    getCardPile1.addCard(aceOfClubs);
    assertEquals(aceOfClubs, getCardPile1.getCard(0));
  }

  //tests that should throw exceptions
  /**
   * Test getting a card from an empty pile.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetCardEmpty() {
    getCardPile2.getCard(5);
  }


  //size tests

  FoundationPile sizePile1;


  /**
   * Initialize variables.
   */
  @Before
  public void testSizeInit() {
    sizePile1 = new FoundationPile(CardSuit.SPADE);

    aceOfSpades = new Card(CardValue.ACE, CardSuit.SPADE);

    sizePile1.addCard(aceOfSpades);
  }

  /**
   * Test the case where there is a card.
   */
  @Test
  public void testSizeIsCard() {
    assertEquals(1, sizePile1.size());
  }
}