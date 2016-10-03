package com.daswath.examples.stringmanipulation;

import java.util.Arrays;

/**
 * Created by DAswath on 10/1/2016.
 */
public class PermutationChecker {

    /**
     * Both input string should have the same number of characters in a different sort order
     * if one is a permutation of the other
     * @param in1
     * @param in2
     * @return
     */
    public static boolean isPermutation(String in1, String in2) {
        if (in1.length() != in2.length()) {
            return false;
        }

        int[] letter = new int[128];
        for (int i = 0; i < 128; i++) {
            letter[i] = 0;
        }
        for (int i = 0; i < in1.length(); i++) {
            int iVal = in1.charAt(i);
            letter[iVal]++;
        }
        for (int i = 0; i < 128; i++) {
            if (letter[i] > 0) {
                System.out.println(i);
            }
        }
        for (int i = 0; i < in2.length(); i++) {
            int iVal = in2.charAt(i);
            letter[iVal]--;

            if (letter[iVal]  < 0) {
                return false;
            }
        }
        return true; // letter array has no negative values so no positives either for the characters appearing in 2 strings
    }

    // Solution 2 - Permutations of strings have the same characters but in different order
    // So, in this solutions, sort the 2 strings and compare them to see if the strings are the same
    // after sorting
    public static String sort(String i) {
        char[] cArray = i.toCharArray();
        Arrays.sort(cArray);
        return new String(cArray);
    }

    public static boolean isPermutationSolution2(String in1, String in2) {
        if (in1.length() != in2.length()) {
            return false;
        }

        return sort(in1).equals(sort(in2));
    }

    public static void main(String[] args) {
        String input1 = "abcdabcd";
        String input2 = "dcbadcba1";
        System.out.println(isPermutation(input1, input2));
        System.out.println(isPermutationSolution2(input1, input2));
    }
}
