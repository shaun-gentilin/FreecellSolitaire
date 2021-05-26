package cs3500.freecell.view;

import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.ICard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the methods of the free cell text view class.
 */
public class FreecellTextViewTest {

  //toString TESTS

  SimpleFreecellModel toStringSFCM1;
  SimpleFreecellModel toStringSFCM2;
  List<ICard> toStringDeck;

  FreecellTextView toStringFCTV1;
  FreecellTextView toStringFCTV2;

  Appendable ap;

  /**
   * Initialize variables for the toString tests.
   */
  @Before
  public void testToStringInit() {
    toStringSFCM1 = new SimpleFreecellModel();

    toStringDeck = toStringSFCM1.getDeck();

    toStringSFCM2 = new SimpleFreecellModel();
    toStringSFCM2.startGame(toStringDeck, 8, 4, false);
    toStringSFCM2.move(PileType.CASCADE, 7, 5, PileType.OPEN, 0);
    toStringSFCM2.move(PileType.CASCADE, 7, 4,
        PileType.FOUNDATION, 0);

    ap = new StringBuilder();

    toStringFCTV1 = new FreecellTextView(toStringSFCM1, ap);
    toStringFCTV2 = new FreecellTextView(toStringSFCM2, ap);
  }

  /**
   * Test the method before the game is started.
   */
  @Test
  public void testToStringGameNotStarted() {
    assertEquals("", toStringFCTV1.toString());
  }

  /**
   * Test the method after the game has started (with cards moved into every type of pile).
   */
  @Test
  public void testToStringGameStarted() {
    assertEquals("F1: A♠\nF2:\nF3:\nF4:\nO1: 9♠\nO2:\nO3:\nO4:\n"
            + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            + "C8: 8♣, 3♦, J♦, 6♥",
        toStringFCTV2.toString());
  }


  //renderBoard TESTS


  SimpleFreecellModel renderBoardSFCM1;
  SimpleFreecellModel renderBoardSFCM2;
  SimpleFreecellModel renderBoardSFCM3;

  List<ICard> renderBoardDeck;

  FreecellTextView renderBoardFCTV1;
  FreecellTextView renderBoardFCTV2;
  FreecellTextView renderBoardFCTV3;

  Appendable renderBoardOut1;
  Appendable renderBoardOut2;

  ByteArrayOutputStream renderBoardOutContent;

  /**
   * Initialize variables for the renderBoard tests.
   */
  @Before
  public void testRenderBoardInit() {
    //set up stream to see what is printed to console
    renderBoardOutContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(renderBoardOutContent));

    //set up models and stuff
    renderBoardSFCM1 = new SimpleFreecellModel();

    renderBoardDeck = renderBoardSFCM1.getDeck();

    renderBoardSFCM2 = new SimpleFreecellModel();
    renderBoardSFCM2.startGame(renderBoardDeck, 8, 4, false);
    renderBoardSFCM2.move(PileType.CASCADE, 7, 5, PileType.OPEN, 0);
    renderBoardSFCM2.move(PileType.CASCADE, 7, 4,
        PileType.FOUNDATION, 0);

    renderBoardSFCM3 = new SimpleFreecellModel();
    renderBoardSFCM3.startGame(renderBoardDeck, 8, 4, false);
    renderBoardSFCM3.move(PileType.CASCADE, 7, 5, PileType.OPEN, 0);
    renderBoardSFCM3.move(PileType.CASCADE, 7, 4,
        PileType.FOUNDATION, 0);

    renderBoardOut1 = new StringBuilder();
    renderBoardOut2 = new StringBuilder();

    renderBoardFCTV1 = new FreecellTextView(renderBoardSFCM1, renderBoardOut1);
    renderBoardFCTV2 = new FreecellTextView(renderBoardSFCM2, renderBoardOut2);
    renderBoardFCTV3 = new FreecellTextView(renderBoardSFCM3, null);
  }

  /**
   * Test to see if the method appends the empty string before the game has started.
   */
  @Test
  public void testRenderBoardGameNotStarted() {
    assertEquals("", renderBoardOut1.toString());
  }

  /**
   * Test to see if the method appends the board correctly after the game has started (with cards
   * in every type of pile).
   */
  @Test
  public void testRenderBoardGameStarted() {
    try {
      renderBoardFCTV2.renderBoard();
    } catch (IOException ioException) {
      //should not throw an exception
    }
    assertEquals("F1: A♠\nF2:\nF3:\nF4:\nO1: 9♠\nO2:\nO3:\nO4:\n"
        + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
        + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
        + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
        + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
        + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
        + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
        + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
        + "C8: 8♣, 3♦, J♦, 6♥",
        renderBoardOut2.toString());
  }

  /**
   * Test to see if the method properly writes to the console if a proper appendable was not
   * provided.
   */
  @Test
  public void testRenderBoardGameStartedNoAppendable() {
    try {
      renderBoardFCTV3.renderBoard();
    } catch (IOException ioException) {
      //should not throw an exception
    }
    assertEquals("F1: A♠\nF2:\nF3:\nF4:\nO1: 9♠\nO2:\nO3:\nO4:\n"
            + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            + "C8: 8♣, 3♦, J♦, 6♥",
        renderBoardOutContent.toString());
  }

  //TESTS THAT SHOULD THROW EXCEPTIONS
  /*
   * TODO: Test to see if the method throws an I/O exception if the transmission did not work.
   */

  //renderMessage TESTS


  SimpleFreecellModel renderMessageSFCM1;
  SimpleFreecellModel renderMessageSFCM2;
  SimpleFreecellModel renderMessageSFCM3;

  List<ICard> renderMessageDeck;

  FreecellTextView renderMessageFCTV1;
  FreecellTextView renderMessageFCTV2;
  FreecellTextView renderMessageFCTV3;

  Appendable renderMessageOut1;
  Appendable renderMessageOut2;

  ByteArrayOutputStream renderMessageOutContent;
  PrintStream originalOut = System.out;

  /**
   * Initialize variables for the renderBoard tests.
   */
  @Before
  public void testRenderMessageInit() {
    //set up stream to see what is printed to console
    renderMessageOutContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(renderMessageOutContent));

    //set up models and stuff
    renderMessageSFCM1 = new SimpleFreecellModel();

    renderMessageDeck = renderMessageSFCM1.getDeck();

    renderMessageSFCM2 = new SimpleFreecellModel();
    renderMessageSFCM2.startGame(renderMessageDeck, 8, 4, false);
    renderMessageSFCM2.move(PileType.CASCADE, 7, 5, PileType.OPEN, 0);
    renderMessageSFCM2.move(PileType.CASCADE, 7, 4,
        PileType.FOUNDATION, 0);

    renderMessageSFCM3 = new SimpleFreecellModel();
    renderMessageSFCM3.startGame(renderMessageDeck, 8, 4, false);
    renderMessageSFCM3.move(PileType.CASCADE, 7, 5, PileType.OPEN, 0);
    renderMessageSFCM3.move(PileType.CASCADE, 7, 4,
        PileType.FOUNDATION, 0);

    renderMessageOut1 = new StringBuilder();
    renderMessageOut2 = new StringBuilder();

    renderMessageFCTV1 = new FreecellTextView(renderBoardSFCM1, renderMessageOut1);
    renderMessageFCTV2 = new FreecellTextView(renderBoardSFCM2, renderMessageOut2);
    renderMessageFCTV3 = new FreecellTextView(renderBoardSFCM3, null);
  }

  /**
   * Set the System.out stream back to the way it was.
   */
  @After
  public void testRenderMessageAfter() {
    System.setOut(originalOut);
  }

  /**
   * Test to see if the method appends the message if a proper appendable has been provided and game
   * has not been started.
   */
  @Test
  public void testRenderMessageGameNotStarted() {
    try {
      renderMessageFCTV1.renderMessage("hello");
    } catch (IOException ioException) {
      //not gonna go here
    }

    assertEquals("hello", renderMessageOut1.toString());
  }

  /**
   * Test to see if the method appends the message if a proper appendable has been provided and game
   * has been started.
   */
  @Test
  public void testRenderMessageGameStarted() {
    try {
      renderMessageFCTV2.renderMessage("hello");
    } catch (IOException ioException) {
      //not gonna go here
    }

    assertEquals("hello", renderMessageOut2.toString());
  }

  /**
   * Test to see if the method properly writes to the console if a proper appendable was not
   * provided.
   */
  @Test
  public void testRenderMessageGameStartedBadAppendable() {
    try {
      renderMessageFCTV3.renderMessage("hello");
    } catch (IOException ioException) {
      //not gonna go here
    }

    assertEquals("hello", renderMessageOutContent.toString());
  }

  //TESTS THAT SHOULD THROW EXCEPTIONS
  /*
   * TODO: Test to see if the method throws an I/O exception if the transmission did not work.
   */
}