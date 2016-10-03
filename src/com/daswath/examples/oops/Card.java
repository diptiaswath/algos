package com.daswath.examples.oops;


public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Card)) {
            return false;
        }

        if (this == o) {
            return true;
        }

        Card card = (Card) o;
        if (card.getRank().equals(getRank()) &&
                card.getSuit().equals(getSuit())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getRank().hashCode() + getSuit().hashCode();
        return result;
    }

    public String toString() {
        return new StringBuilder().
                append("Suit : ").
                append(getSuit().name()).
                append(" , Rank : ").
                append(getRank().name()).toString();

    }
}
