package edu.cnm.deepdive.cards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuitTest {

  @Test
  void toStringTest() {
    for (Suit suit : Suit.values()) {
      if (suit == Suit.HEARTS) {
        assertTrue(suit.toString().equals("\u2665"));
      } else if (suit == Suit.CLUBS) {
        assertTrue(suit.toString().equals("\u2663"));
      } else if (suit == Suit.DIAMONDS) {
        assertTrue(suit.toString().equals("\u2666"));
      } else if (suit == Suit.SPADES) {
        assertTrue(suit.toString().equals("\u2660"));
      }
    }
  }
}

