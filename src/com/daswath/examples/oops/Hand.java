package com.daswath.examples.oops;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("card to add cannot be null");
        }
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public void clear() {
        hand.clear();
    }

    public void removeCard(int position) {
        if (position > hand.size() || position < hand.size()) {
            throw new IllegalArgumentException("position illegal");
        }
        hand.remove(position);
    }

    public void addCard(int position, Card card) {
        if (position > hand.size() || position < hand.size()) {
            throw new IllegalArgumentException("position illegal");
        }
        hand.add(position, card);
    }

    /**
     * Sorts the cards in the hand so that cards of the same
     * suit are grouped together, and within a suit the cards
     * are sorted by value.
     */
    public void sortBySuit() {
        List<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int minPos = 0;
            Card minCard = hand.get(0);
            for (int i = 1; i < hand.size(); i++) {
                Card curCard = hand.get(i);
                if (curCard.getSuit().ordinal() < minCard.getSuit().ordinal() ||
                        (curCard.getSuit().ordinal() == minCard.getSuit().ordinal() && curCard.getRank().ordinal() < minCard.getRank().ordinal())) {
                    minPos = i;
                    minCard = curCard;
                }
            }
            hand.remove(minPos);
            newHand.add(minCard);
        }
        hand = newHand;
    }

    public void sortByRank() {
        List<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int minPos = 0;
            Card minCard = hand.get(0);
            for (int j = 1; j < hand.size(); j++) {
                Card curCard = hand.get(j);
                if (curCard.getRank().ordinal() < minCard.getRank().ordinal() ||
                        (curCard.getRank().ordinal() == minCard.getRank().ordinal() && curCard.getSuit().ordinal() < minCard.getSuit().ordinal())) {
                    minPos = j;
                    minCard = curCard;
                }
            }
            hand.remove(minPos);
            newHand.add(minCard);
        }
        hand = newHand;
    }

    public void printHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i));
        }
    }
}
