package cs3500.freecell.model;

import cs3500.freecell.model.FreecellModelCreator.GameType;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiFreecellModel;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Test the methods for the FrecellModelCreator class.
 */
public class FreecellModelCreatorTest extends TestCase {

  //create TESTS

  FreecellModelCreator creator = new FreecellModelCreator();

  /**
   * Test the case where the single move type is passed to the method.
   */
  @Test
  public void testSingleMove() {
    assertTrue(creator.create(GameType.SINGLEMOVE) instanceof SimpleFreecellModel);
  }

  /**
   * Test the case where the multi move type is passed to the method.
   */
  @Test
  public void testMultiMove() {
    assertTrue(creator.create(GameType.MULTIMOVE) instanceof MultiFreecellModel);
  }
}