package com.daswath.examples.oops;

/**
 * Created by DAswath on 10/24/2016.
 */
public class BlackJackCard extends Card {

    public BlackJackCard(Suit s, Rank r) {
        super(s, r);
    }

    public int value() {
        if (isAce()) {
            return 1;
        } else if (isFaceCard()) {
            return 10;
        } else {
            return getRank().getValue();
        }
    }

    public int minValue() {
        if (isAce()) {
            return 1;
        }
        return value();
    }

    public int maxValue() {
        if (isAce()) {
            return 11;
        }
        return value();
    }

    public boolean isAce() {
        return getRank().getValue() == 1;
    }

    public boolean isFaceCard() {
        return (getRank().getValue() >= 11 && getRank().getValue() <= 13);
    }


}
