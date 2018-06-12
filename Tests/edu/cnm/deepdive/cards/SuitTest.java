package edu.cnm.deepdive.cards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuitTest {

  private static final String[] SUIT_SYMBOLS = {
    "\u2663",
    "\u2666",
    "\u2665",
    "\u2660",
  };

  // can run all tests right clicking Tests folder and selecting "Run all tests"
  @Test
  void toStringTest() {
    // alternative without jUnit is simply assert
    // assert suit.toString().equals(SUIT_SYMBOLS[suit.ordinal()]);
    for (Suit suit : Suit.values()) {
      // put SUIT_SYMBOLS first
      assertEquals(SUIT_SYMBOLS[suit.ordinal()], suit.toString());
      System.out.println(suit);
    }
//      if (suit == Suit.HEARTS) {
//        assertTrue(suit.toString().equals("\u2665"));
//      } else if (suit == Suit.CLUBS) {
//        assertTrue(suit.toString().equals("\u2663"));
//      } else if (suit == Suit.DIAMONDS) {
//        assertTrue(suit.toString().equals("\u2666"));
//      } else if (suit == Suit.SPADES) {
//        assertTrue(suit.toString().equals("\u2660"));
//      }
//    }
  }
}

