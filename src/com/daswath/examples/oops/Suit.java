package com.daswath.examples.oops;

/**
 * Created by DAswath on 9/28/2016.
 */
public enum Suit {
    DIAMONDS(0), CLUBS(1), HEARTS(2), SPADES(3);

    private final int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int value) {
        Suit[] suits = values();
        for (Suit s : suits) {
            if (s.getValue() == value) {
                return s;
            }
        }
        return null;
    }
}
