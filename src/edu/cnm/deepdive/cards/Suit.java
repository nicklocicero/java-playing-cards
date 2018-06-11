package edu.cnm.deepdive.cards;

// Using an enum because there is a finite possible number of vals and they are not going to change.
public enum Suit {
  // Fields are constants so they are all caps.
  // .toString() method returns the field variable as default
  CLUBS("\u2663"),
  DIAMONDS("\u2666"),
  HEARTS("\u2665"),
  SPADES("\u2660");

  // Using String instead of Char because some chars can have more than 2 bytes in size.
  private String symbol;

  // Enums are final and cannot be subclassed the normal way, so this must be private (not protected or public).
  private Suit(String symbol) {
    this.symbol = symbol;
  }


  @Override
  public String toString() {
    return symbol;
  }
}
