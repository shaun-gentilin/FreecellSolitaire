import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.hw02.CardSuit;
import org.junit.Test;

/**
 * Tests the methods of the CardSuit enum.
 */
public class CardSuitTest {

  //TOSTRING TESTS
  /**
   * Test to ensure that the toString method returns a string version of the given suit.
   */
  @Test
  public void testToString() {
    assertEquals("♥", CardSuit.HEART.toString());
  }
}
