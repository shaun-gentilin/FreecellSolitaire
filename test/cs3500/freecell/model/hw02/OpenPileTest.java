package cs3500.freecell.model.hw02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the methods of the OpenPile class.
 */
public class OpenPileTest {

  //addCard TESTS

  OpenPile addCardPile1 = new OpenPile();
  OpenPile addCardPile2 = new OpenPile();
  Card fourOfHearts = new Card(CardValue.FOUR, CardSuit.HEART);
  Card threeOfHearts = new Card(CardValue.THREE, CardSuit.HEART);


  /**
   * Test adding a card to an empty open pile.
   */
  @Test
  public void testAddCardEmpty() {
    addCardPile1.addCard(fourOfHearts);
    assertEquals(true, fourOfHearts.equals(addCardPile1.getCard(0)));
  }

  //tests that should throw exceptions
  /**
   * Test adding a card to a non-empty open pile.
   */
  @Test(expected = IllegalStateException.class)
  public void testAddCardNonEmpty() {
    addCardPile2.addCard(fourOfHearts);
    addCardPile2.addCard(threeOfHearts);
  }


  //removeCardFromEnd TESTS

  OpenPile removeCardFromEndPile1 = new OpenPile();
  OpenPile removeCardFromEndPile2 = new OpenPile();

  /**
   * Test that card is removed if there was a card.
   */
  @Test
  public void testRemoveCardFromEndIsCard() {
    removeCardFromEndPile1.addCard(fourOfHearts);
    assertEquals(fourOfHearts, removeCardFromEndPile1.removeCardFromEnd());
  }

  /**
   * Test that exception is thrown if there was no card to remove.
   */
  @Test(expected = IllegalStateException.class)
  public void testRemoveCardFromEndNoCard() {
    removeCardFromEndPile2.removeCardFromEnd();
  }



  //getCard TESTS

  OpenPile getCardPile1 = new OpenPile();
  OpenPile getCardPile2 = new OpenPile();

  /**
   * Test that card is removed if there was a card.
   */
  @Test
  public void testGetCardIsCard() {
    getCardPile1.addCard(fourOfHearts);
    assertEquals(fourOfHearts, getCardPile1.getCard(0));
  }

  /**
   * Test that a null card is returned if there was no card.
   */
  @Test
  public void testGetCardNoCard() {
    assertEquals(null, getCardPile2.getCard(0));
  }

  //size TESTS

  OpenPile sizePile1;
  OpenPile sizePile2;

  /**
   * Initialize variables.
   */
  @Before
  public void testSizeInit() {
    sizePile1 = new OpenPile();
    sizePile2 = new OpenPile();

    sizePile2.addCard(fourOfHearts);
  }

  /**
   * Test the case where there is a card.
   */
  @Test
  public void testSizeIsCard() {
    assertEquals(1, sizePile2.size());
  }

  /**
   * Test the case where there is no card.
   */
  @Test
  public void testSizeNoCard() {
    assertEquals(0, sizePile1.size());
  }


}