package com.daswath.examples.oops;

import java.util.Random;

public class Deck {
    private Card[] cards = new Card[Suit.values().length * Rank.values().length];
    int curIndex = 0;

    public Deck() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new Card(suit, rank);
            }
        }
    }

    public void printDeck() {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
        }
    }

    public void shuffleDeck() {
        Random randGen = new Random();
        for (int i = cards.length - 1; i > 0 ; i--) {
            int randIndex = randGen.nextInt(i);
            Card temp = cards[randIndex];
            cards[randIndex] = cards[i];
            cards[i] = temp;
        }
    }

    public Card dealDeck() {
        if (curIndex == cards.length) {
            System.out.println("no cards left to deal");
        }
        return cards[curIndex++];
    }

    public static void main(String[] args) {
        Deck myCardDeck = new Deck();
        myCardDeck.shuffleDeck();
       // myCardDeck.printDeck();

        Hand myHand = new Hand();
        for (int i=0; i < 10; i++) {
            myHand.addCard(myCardDeck.dealDeck());
        }
       // myHand.sortByRank();
        myHand.printHand();

    }
}
