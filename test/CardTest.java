import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.CardSuit;
import cs3500.freecell.model.hw02.CardValue;
import org.junit.Test;

/**
 * Tests the constructor and methods for the Card class.
 */
public class CardTest {
  //local variables to use in tests
  Card testCard = new Card(CardValue.ACE, CardSuit.DIAMOND);
  Card testCard2 = new Card(CardValue.EIGHT, CardSuit.CLUB);
  Card testCard3 = new Card(CardValue.ACE, CardSuit.DIAMOND);
  Card testCard4 = new Card(CardValue.TEN, CardSuit.DIAMOND);


  Card nullCard = null;


  //CONSTRUCTOR TESTS


  /**
   * Test that the suit is correct in the card after constructing.
   */
  @Test
  public void testConstructorSuitCorrect() {
    assertEquals(CardSuit.CLUB, new Card(CardValue.SEVEN, CardSuit.CLUB).getSuit());
  }

  /**
   * Test that the value is correct in the card after constructing.
   */
  @Test
  public void testConstructorValueCorrect() {
    assertEquals(CardValue.SEVEN, new Card(CardValue.SEVEN, CardSuit.CLUB).getValue());
  }

  //TESTS THAT SHOULD THROW EXCEPTIONS
  /**
   * Check that a null pointer exception is thrown when trying to pass a null suit to Card class
   * when constructing.
   */
  @Test(expected = NullPointerException.class)
  public void testConstructorNullSuit() {
    Card card1 = new Card(CardValue.FIVE, null);
  }

  /**
   * Check that a null pointer exception is thrown when trying to pass a null value to Card class
   * when constructing.
   */
  @Test(expected = NullPointerException.class)
  public void testConstructorNullValue() {
    Card card2 = new Card(null, CardSuit.CLUB);
  }


  //getSuit TESTS


  /**
   * Test to ensure that the getSuit method retrieves the correct suit from the given Card object.
   */
  @Test
  public void testGetSuitNonNull() {
    assertEquals(CardSuit.DIAMOND, testCard.getSuit());
  }

  //TESTS THAT SHOULD CAUSE EXCEPTIONS
  /**
   * Test that if getSuit is called on a null instance of card, a null pointer exception is thrown.
   */
  @Test(expected = NullPointerException.class)
  public void testGetSuitNullCard() {
    nullCard.getSuit();
  }


  //getValue TESTS


  /**
   * Test to ensure that the getValue method retrieves the correct value from the given Card object.
   */
  @Test
  public void testGetValueNonNull() {
    assertEquals(CardValue.EIGHT, testCard2.getValue());
  }

  //TESTS THAT SHOULD CAUSE EXCEPTIONS
  /**
   * Test that if getValue is called on a null instance of card, a null pointer exception is thrown.
   */
  @Test(expected = NullPointerException.class)
  public void testGetValueNullCard() {
    nullCard.getValue();
  }


  //toString TESTS


  /**
   * Test that the ToString method returns the correct value on a non null instance of a face Card.
   */
  @Test
  public void testCardToStringNonNullFace() {
    assertEquals("A♦", testCard3.toString());
  }

  /**
   * Test that the ToString method returns the correct value on a non null instance of a non face
   * Card.
   */
  @Test
  public void testCardToStringNonNullNonFace() {
    assertEquals("10♦",
        testCard4.toString());
  }

  //TESTS THAT SHOULD THROW EXCEPTIONS
  /**
   * Test that if toString is called on a null instance of card, a null pointer exception is thrown.
   */
  @Test(expected = NullPointerException.class)
  public void testNullCard() {
    nullCard.toString();
  }


  //equals TESTS

  //variables I need for this
  Card nineOfSpades = new Card(CardValue.NINE, CardSuit.SPADE);
  Card aceOfSpades = new Card(CardValue.ACE, CardSuit.SPADE);
  Card nineOfHearts = new Card(CardValue.NINE, CardSuit.HEART);

  /**
   * Test a case where two cards are equal.
   */
  @Test
  public void testEqualsTrue() {
    assertEquals(true, nineOfSpades.equals(new Card(CardValue.NINE, CardSuit.SPADE)));
  }

  /**
   * Test a case where two cards are not equal but have the same suit.
   */
  @Test
  public void testEqualsFalseSameSuit() {
    assertEquals(false,
        nineOfSpades.equals(aceOfSpades));
  }

  /**
   * Test a case where two cards are not equal but have the same value.
   */
  @Test
  public void testEqualsFalseSameValue() {
    assertEquals(false,
        nineOfSpades.equals(nineOfHearts));
  }


  //isOppositeColor TESTS


  //variables needed
  Card fourOfSpades = new Card(CardValue.FOUR, CardSuit.SPADE);
  Card threeOfSpades = new Card(CardValue.THREE, CardSuit.SPADE);
  Card eightOfHearts = new Card(CardValue.EIGHT, CardSuit.HEART);
  Card sevenOfClubs = new Card(CardValue.SEVEN, CardSuit.CLUB);
  Card twoOfDiamonds = new Card(CardValue.TWO, CardSuit.DIAMOND);

  /**
   * Test same suit (same color).
   */
  @Test
  public void testIsOppositeColorSameSuit() {
    assertEquals(false, fourOfSpades.isOppositeColor(threeOfSpades));
  }

  /**
   * Test different suit (same color).
   */
  @Test
  public void testIsOppositeColorDiffSuitSameColor() {
    assertEquals(false, fourOfSpades.isOppositeColor(sevenOfClubs));
  }

  /**
   * Test different suit.
   */
  @Test
  public void testIsOppositeTrue() {
    assertEquals(true, fourOfSpades.isOppositeColor(eightOfHearts));
  }
}
