import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.hw02.CardValue;
import org.junit.Test;

/**
 * Tests the methods for the CardValue enum.
 */
public class CardValueTest {


  //toString TESTS


  /**
   * Test that the toString method returns the string version of a number from 2 to 10.
   */
  @Test
  public void testToStringNonFace() {
    assertEquals("5", CardValue.FIVE.toString());
  }

  /**
   * Test that the toString method returns the string version of Ace.
   */
  @Test
  public void testToStringAce() {
    assertEquals("A", CardValue.ACE.toString());
  }

  /**
   * Test that the toString method returns the string version of Jack.
   */
  @Test
  public void testToStringJack() {
    assertEquals("J", CardValue.JACK.toString());
  }

  /**
   * Test that the toString method returns the string version of Queen.
   */
  @Test
  public void testToStringQueen() {
    assertEquals("Q", CardValue.QUEEN.toString());
  }

  /**
   * Test that the toString method returns the string version of King.
   */
  @Test
  public void testToStringKing() {
    assertEquals("K", CardValue.KING.toString());
  }


  //intToCardValue TESTS


  /**
   * Test if the method returns the correct card value on valid input.
   */
  @Test
  public void testIntToCardValueValidInput() {
    assertEquals(CardValue.FIVE, CardValue.intToCardValue(5));
  }

  //TESTS THAT SHOULD THROW EXCEPTIONS
  /**
   * Test if the method is given invalid input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIntToCardValueInvalidInput() {
    CardValue.intToCardValue(50);
  }


  //cardValueToInt TESTS

  /**
   * Test if the value returns the correct int for the CardValue.
   */
  @Test
  public void testCardValueToInt() {
    assertEquals(5, CardValue.FIVE.cardValueToInt());
  }
}
