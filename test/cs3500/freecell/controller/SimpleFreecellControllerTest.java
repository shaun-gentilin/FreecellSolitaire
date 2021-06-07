package cs3500.freecell.controller;

import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.hw02.ICard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import java.io.StringReader;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the methods for the simple freecell controller class.
 */
public class SimpleFreecellControllerTest {


  //playGame TESTS

  List<ICard> deck;

  //test1
  SimpleFreecellModel model1;
  Readable in1;
  Appendable out1;
  SimpleFreecellController cont1;

  //test2
  SimpleFreecellModel model2;
  Readable in2;
  Appendable out2;
  SimpleFreecellController cont2;

  //test3
  SimpleFreecellModel model3;
  Readable in3;
  Appendable out3;
  SimpleFreecellController cont3;

  //test4
  SimpleFreecellModel model4;
  Readable in4;
  Appendable out4;
  SimpleFreecellController cont4;

  //test5
  SimpleFreecellModel model5;
  Readable in5;
  Appendable out5;
  SimpleFreecellController cont5;

  //test6
  SimpleFreecellModel model6;
  Readable in6;
  Appendable out6;
  SimpleFreecellController cont6;

  //test7
  SimpleFreecellModel model7;
  Readable in7;
  Appendable out7;
  SimpleFreecellController cont7;

  //test8
  SimpleFreecellModel model8;
  Readable in8;
  Appendable out8;
  SimpleFreecellController cont8;

  //test9
  SimpleFreecellModel model9;
  Readable in9;
  Appendable out9;
  SimpleFreecellController cont9;

  //test10
  SimpleFreecellModel model10;
  Readable in10;
  Appendable out10;
  SimpleFreecellController cont10;

  //test11
  SimpleFreecellModel model11;
  Readable in11;
  Appendable out11;
  SimpleFreecellController cont11;

  //test12
  SimpleFreecellModel model12;
  Readable in12;
  Appendable out12;
  SimpleFreecellController cont12;

  //test13
  SimpleFreecellModel model13;
  Readable in13;
  Appendable out13;
  SimpleFreecellController cont13;

  //test14
  SimpleFreecellModel model14;
  Readable in14;
  Appendable out14;
  SimpleFreecellController cont14;

  //test15
  SimpleFreecellModel model15;
  Readable in15;
  Appendable out15;
  SimpleFreecellController cont15;

  //test16
  SimpleFreecellModel model16;
  Readable in16;
  Appendable out16;
  SimpleFreecellController cont16;

  //test17
  SimpleFreecellModel model17;
  Readable in17;
  Appendable out17;
  SimpleFreecellController cont17;


  /**
   * Initialize variables and states for the playGame method.
   */
  @Before
  public void playGameInit() {
    //test1
    model1 = new SimpleFreecellModel();
    in1 = new StringReader("q");
    out1 = new StringBuilder();
    cont1 = new SimpleFreecellController(model1, in1, out1);

    deck = model1.getDeck();

    //test2
    model2 = new SimpleFreecellModel();
    in2 = new StringReader("C1 7 O1 q");
    out2 = new StringBuilder();
    cont2 = new SimpleFreecellController(model2, in2, out2);

    //test3
    model3 = new SimpleFreecellModel();
    in3 = new StringReader("C1 7 O1");
    out3 = new StringBuilder();
    cont3 = new SimpleFreecellController(model3, in3, out3);

    //test4
    model4 = new SimpleFreecellModel();
    in4 = new StringReader("asdf");
    out4 = new StringBuilder();
    cont4 = new SimpleFreecellController(model4, in4, out4);

    //test5
    model5 = new SimpleFreecellModel();
    in5 = new StringReader("asdf Q");
    out5 = new StringBuilder();
    cont5 = new SimpleFreecellController(model5, in5, out5);

    //test6
    model6 = new SimpleFreecellModel();
    in6 = new StringReader("C1 7 asdf O1 Q");
    out6 = new StringBuilder();
    cont6 = new SimpleFreecellController(model6, in6, out6);

    //test7
    model7 = new SimpleFreecellModel();
    in7 = new StringReader("C1 7 asdf O1 Q");
    out7 = new StringBuilder();
    cont7 = new SimpleFreecellController(model7, in7, out7);

    //test8
    model8 = new SimpleFreecellModel();
    in8 = new StringReader("C1 7 O1 Q");
    out8 = new StringBuilder();
    cont8 = new SimpleFreecellController(model8, in8, out8);

    //test9
    model9 = new SimpleFreecellModel();
    in9 = new StringReader("C1 7 C5 Q");
    out9 = new StringBuilder();
    cont9 = new SimpleFreecellController(model9, in9, out9);

    //test10
    model10 = new SimpleFreecellModel();
    in10 = new StringReader("");
    out10 = new StringBuilder();
    cont10 = new SimpleFreecellController(model10, in10, out10);

    //test11
    model11 = new SimpleFreecellModel();
    in11 = new StringReader("C1 7 O1 q");
    out11 = new StringBuilder();
    cont11 = new SimpleFreecellController(model11, in11, out11);

    //test12
    model12 = new SimpleFreecellModel();
    in12 = new StringReader("Ca q");
    out12 = new StringBuilder();
    cont12 = new SimpleFreecellController(model12, in12, out12);

    //test13
    model13 = new SimpleFreecellModel();
    in13 = new StringReader("C1 7 O1 q C2 7 O2");
    out13 = new StringBuilder();
    cont13 = new SimpleFreecellController(model13, in13, out13);

    //test14
    model14 = new SimpleFreecellModel();
    in14 = new StringReader("C1 1 F1 C2 1 F1 C3 1 F1 C4 1 F1 C5 1 F1 C6 1 F1 C7 1 F1 C8 1 F1 "
        + "C9 1 F1 C10 1 F1 C11 1 F1 C12 1 F1 C13 1 F1 "
        + "C14 1 F2 C15 1 F2 C16 1 F2 C17 1 F2 C18 1 F2 C19 1 F2 C20 1 F2 C21 1 F2 "
        + "C22 1 F2 C23 1 F2 C24 1 F2 C25 1 F2 C26 1 F2 "
        + "C27 1 F3 C28 1 F3 C29 1 F3 C30 1 F3 C31 1 F3 C32 1 F3 C33 1 F3 C34 1 F3 "
        + "C35 1 F3 C36 1 F3 C37 1 F3 C38 1 F3 C39 1 F3 "
        + "C40 1 F4 C41 1 F4 C42 1 F4 C43 1 F4 C44 1 F4 C45 1 F4 C46 1 F4 C47 1 F4 "
        + "C48 1 F4 C49 1 F4 C50 1 F4 C51 1 F4 C52 1 F4");
    out14 = new StringBuilder();
    cont14 = new SimpleFreecellController(model14, in14, out14);

    //test15
    model15 = new SimpleFreecellModel();
    in15 = new StringReader("q C1 7 O1");
    out15 = new StringBuilder();
    cont15 = new SimpleFreecellController(model15, in15, out15);

    //test16
    model16 = new SimpleFreecellModel();
    in16 = new StringReader("C1 q 7 O1");
    out16 = new StringBuilder();
    cont16 = new SimpleFreecellController(model16, in16, out16);

    //test17
    model17 = new SimpleFreecellModel();
    in17 = new StringReader("C1 7 q O1");
    out17 = new StringBuilder();
    cont17 = new SimpleFreecellController(model17, in17, out17);
  }

  /**
   * Test a case where the game was quit prematurely.
   */
  @Test
  public void testPlayGameQuitEarly() {
    cont1.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
        + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
        + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
        + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
        + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
        + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
        + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
        + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
        + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\nGame quit prematurely.", out1.toString());
  }

  /**
   * Test a case where a valid move was made, and then the game was quit.
   */
  @Test
  public void testPlayGameValidMoveThenQuit() {
    cont2.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
        + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
        + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
        + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
        + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
        + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
        + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
        + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
        + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
        + "F1:\nF2:\nF3:\nF4:\nO1: 10♠\nO2:\nO3:\nO4:\n"
        + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠\n"
        + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
        + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
        + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
        + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
        + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
        + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
        + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\nGame quit prematurely.", out2.toString());
  }

  /**
   * Test a case where only invalid input is provided and then there is a q.
   */
  @Test
  public void testInvalidInputThenQuit() {
    cont5.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
            + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
            + "Not a valid pile. Try again.\n"
            + "Game quit prematurely.",
        out5.toString());
  }

  /**
   * Test a case where a valid move is made with invalid inputs in between (and then quit).
   */
  @Test
  public void testPlayGameValidMoveInvalidsInBetweenThenQuit() {
    cont6.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
        + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
        + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
        + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
        + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
        + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
        + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
        + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
        + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
        + "Not a valid pile. Try again.\n"
        + "F1:\nF2:\nF3:\nF4:\nO1: 10♠\nO2:\nO3:\nO4:\n"
        + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠\n"
        + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
        + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
        + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
        + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
        + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
        + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
        + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
        + "Game quit prematurely.", out6.toString());
  }

  /**
   * Test a case where only valid moves are made and the game is finished.
   */
  @Test
  public void gameFinished() {
    cont14.playGame(deck, 52, 4, false);
    assertEquals("C52:\nGame over.",
        out14.toString().substring(out14.toString().length() - 15));
  }

  /**
   * Test that we can quit while searching for a source pile.
   */
  @Test
  public void quitSearchingSource() {
    cont15.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
        + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
        + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
        + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
        + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
        + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
        + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
        + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
        + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
        + "Game quit prematurely.",
        out15.toString());
  }

  /**
   * Test that we can quit while searching for a card index.
   */
  @Test
  public void quitSearchingCard() {
    cont16.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
            + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
            + "Game quit prematurely.",
        out16.toString());
  }

  /**
   * Test that we can quit while searching for a dest pile.
   */
  @Test
  public void quitSearchingDestination() {
    cont17.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
            + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
            + "Game quit prematurely.",
        out17.toString());
  }

  /**
   * Test a case where the game could not be started (invalid game parameters).
   */
  @Test
  public void gameCantStart() {
    cont8.playGame(deck, -1, -10, false);
    assertEquals("Could not start game.", out8.toString());
  }

  /**
   * Test a case where the move was invalid (signified by the model).
   */
  @Test
  public void testInvalidMove() {
    cont9.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
            + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
            + "Invalid move. Try again.\n"
            + "Game quit prematurely.",
        out9.toString());
  }

  /**
   * Test a case where the pile was valid but the number after it was not.
   */
  @Test
  public void testPileValidIndexNot() {
    cont12.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
            + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
            + "Not a valid pile index. Try again.\n"
            + "Game quit prematurely.",
        out12.toString());
  }

  /**
   * Test case where there was a q and then more after it.
   */
  @Test
  public void testValidMoveThenQuitThenMore() {
    cont13.playGame(deck, 8, 4, false);
    assertEquals("F1:\nF2:\nF3:\nF4:\nO1:\nO2:\nO3:\nO4:\n"
            + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠, 10♠\n"
            + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
            + "F1:\nF2:\nF3:\nF4:\nO1: 10♠\nO2:\nO3:\nO4:\n"
            + "C1: A♣, 9♣, 4♦, Q♦, 7♥, 2♠\n"
            + "C2: 2♣, 10♣, 5♦, K♦, 8♥, 3♠, J♠\n"
            + "C3: 3♣, J♣, 6♦, A♥, 9♥, 4♠, Q♠\n"
            + "C4: 4♣, Q♣, 7♦, 2♥, 10♥, 5♠, K♠\n"
            + "C5: 5♣, K♣, 8♦, 3♥, J♥, 6♠\n"
            + "C6: 6♣, A♦, 9♦, 4♥, Q♥, 7♠\n"
            + "C7: 7♣, 2♦, 10♦, 5♥, K♥, 8♠\n"
            + "C8: 8♣, 3♦, J♦, 6♥, A♠, 9♠\n"
            + "Game quit prematurely.",
        out13.toString());
  }

  //exception tests
  /**
   * Test a case where a null deck is passed to the method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullDeck() {
    cont11.playGame(null, 8, 4, false);
  }

  /**
   * Test a case where a valid move is made and then there is no more input.
   */
  @Test(expected = IllegalStateException.class)
  public void testValidMoveThenNoMoreInput() {
    cont3.playGame(deck, 8, 4, false);
  }


  /**
   * Test a case where only invalid input is provided and there is no more input.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidInputThenNoMoreInput() {
    cont4.playGame(deck, 8, 4, false);
  }

  /**
   * Test a case where there is just the empty string as input.
   */
  @Test(expected = IllegalStateException.class)
  public void testEmptyStringAsInput() {
    cont10.playGame(deck, 8, 4, false);
  }
}