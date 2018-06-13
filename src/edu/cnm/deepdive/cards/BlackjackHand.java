package edu.cnm.deepdive.cards;

import edu.cnm.deepdive.cards.Deck.InsufficientCardsException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class BlackjackHand implements Comparable<BlackjackHand> {

  public static final int[] VALUES = {
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      10,
      10,
      10,
  };

  private List<Card> hand;
  private Deck deck;
  private boolean hasAce;
  private boolean soft;
  private boolean blackjack;
  private boolean busted;
  private int value;

  protected BlackjackHand(Deck deck) throws InsufficientCardsException {
    hand = new LinkedList<>();
    hand.addAll(Arrays.asList(deck.deal(2)));
    this.deck = deck;
    update();
  }

  private void update() {
    value = 0;
    hasAce = false;
    soft = false;
    blackjack = false;
    busted = false;
    for (Card card : hand) {
      if (card.getRank() == Rank.ACE) {
        hasAce = true;
      }
      value += VALUES[card.getRank().ordinal()];
    }
    if (value > 21) {
      value = 0;
      busted = true;
    } else if (hasAce && value <= 11) {
      value += 10;
      soft = true;
      if (hand.size() == 2 && value == 21) {
        blackjack = true;
      }
    }
    // could just write:
    // return;
    // but that's kind of silly - unless it was to get out of a method early - not at the end
  }


  // final means it can't be overridden by an instance
  // static means it's a member of the class, not instance
  // we want final because it is a core function of our game that won't change
  protected final void hit() throws InsufficientCardsException {
    hand.add(deck.deal());
    update();
  }

  @Override
  public int compareTo(BlackjackHand otherHand) {
    int comparison = Integer.compare(value, otherHand.value);
    if (comparison == 0) {
      if (blackjack && !otherHand.blackjack) {
        comparison = 1;
      } else if(otherHand.blackjack && !blackjack) {
        comparison = -1;
      }
    }
    return comparison;
  }

  public int getValue() {
    return value;
  }

  protected boolean isSoft() {
    return soft;
  }

  public boolean isBlackjack() {
    return blackjack;
  }

  public boolean isBusted() {
    return busted;
  }

  public Card[] getHand() {
    return hand.toArray(new Card[hand.size()]);
  }

  public abstract void play() throws Deck.InsufficientCardsException;

  @Override
  public String toString() {
    String status;
    if (isBusted()) {
      status = "busted";
    } else if (isBlackjack()) {
      status = "blackjack!";
    } else {
      status = String.format("%d", getValue());
    }
    return String.format("Current hand: %s (%s)", Arrays.toString(getHand()), status);
  }
}
