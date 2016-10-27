package com.daswath.examples.moderate;

/**
 * Created by DAswath on 10/12/2016.
 */
public class NumberSwapper {
    // a = 9, b = 5
    // after swap, a = 5, b = 9

    public static void swapInPlace(int a, int b) {
        a = a - b; //4
        b = a + b; //9
        a = b - a; //4
        System.out.println("a = " + a + ", b = " + b);
    }


    public static void main(String[] args) {
        NumberSwapper.swapInPlace(12, 4);
    }
}
