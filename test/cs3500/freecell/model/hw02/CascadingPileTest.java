package cs3500.freecell.model.hw02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the methods of the cascading pile class.
 */
public class CascadingPileTest {


  //addCard TESTS


  CascadingPile pile1 = new CascadingPile();
  CascadingPile pile2 = new CascadingPile();

  Card aceOfClubs = new Card(CardValue.ACE, CardSuit.CLUB);
  Card twoOfClubs = new Card(CardValue.TWO, CardSuit.CLUB);
  Card twoOfHearts = new Card(CardValue.TWO, CardSuit.HEART);
  Card fiveOfClubs = new Card(CardValue.FIVE, CardSuit.HEART);
  Card tenOfHearts = new Card(CardValue.TEN, CardSuit.HEART);
  Card nineOfSpades = new Card(CardValue.NINE, CardSuit.SPADE);



  /**
   * Test adding a card to an empty list.
   */
  @Test
  public void testAddCardEmptyList() {
    pile1.addCard(aceOfClubs);
    assertEquals(aceOfClubs, pile1.pile.get(0));
  }

  /**
   * Test adding a valid card to a non-empty list.
   */
  @Test
  public void testAddCardNonEmptyList() {
    pile2.addCard(tenOfHearts, true);
    pile2.addCard(nineOfSpades);
    assertEquals(nineOfSpades, pile2.pile.get(1));
  }

  //tests that will throw exceptions
  /**
   * Test adding a non-valid card to a non-empty list (suit wrong).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddCardNonEmptyListNonValidSuit() {
    pile2.addCard(aceOfClubs);
    pile2.addCard(twoOfHearts);
  }

  /**
   * Test adding a non-valid card to a non-empty list (value wrong).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddCardNonEmptyListNonValidValue() {
    pile2.addCard(aceOfClubs);
    pile2.addCard(fiveOfClubs);
  }


  //removeCardFromEnd TESTS


  //variables needed


  CascadingPile removeCardFromEndPile1 = new CascadingPile();
  CascadingPile removeCardFromEndPile2 = new CascadingPile();

  /**
   * Test removing a card from a non-empty pile.
   */
  @Test
  public void testRemoveCardFromEndNonEmpty() {
    removeCardFromEndPile1.addCard(aceOfClubs);
    assertEquals(aceOfClubs, removeCardFromEndPile1.removeCardFromEnd());
    assertEquals(true, removeCardFromEndPile1.pile.isEmpty());
  }

  //tests that should throw exceptions
  /**
   * Test removing a card from empty pile.
   */
  @Test(expected = IllegalStateException.class)
  public void testRemoveCardFromEndEmpty() {
    removeCardFromEndPile2.removeCardFromEnd();
  }


  //getCard TESTS

  //variables needed for these tests
  CascadingPile getCardPile1 = new CascadingPile();
  CascadingPile getCardPile2 = new CascadingPile();

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

  CascadingPile sizePile1;

  /**
   * Initialize variables.
   */
  @Before
  public void testSizeInit() {
    sizePile1 = new CascadingPile();

    sizePile1.addCard(twoOfHearts);
  }

  /**
   * Test the case where there is a card.
   */
  @Test
  public void testSizeIsCard() {
    assertEquals(1, sizePile1.size());
  }
}