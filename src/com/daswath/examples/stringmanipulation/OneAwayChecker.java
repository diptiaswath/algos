package com.daswath.examples.stringmanipulation;

/**
 * Created by DAswath on 10/3/2016.
 */
public class OneAwayChecker {

    /**
     * Returns true is both strings are the same length and only 1 character
     * needs to be replaced for both these strings to be the same
     * eg., 1) pale and bale - true
     * 2) pale and same - false
     *
     * @param s1
     * @param s2
     * @return boolean
     */
    public static boolean isOneEditReplace(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    /**
     * Check if the shorter string s1 can become longer string s2 by inserting just 1 character
     * Return true if thats' the case
     * @param s1 shorter string
     * @param s2 longer string
     * @return true
     */
    public static boolean isOneReplacementAway(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return false;
        }
        if (s1.length() > s2.length()) {
            throw new IllegalArgumentException("expected input string 1 to be shorter that input string 2");
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean isOneAwayCheck(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return isOneEditReplace(s1, s2);
        }
        if (s1.length() < s2.length()) {
            return isOneReplacementAway(s1, s2);
        }

        if (s2.length() < s1.length()) {
            return isOneReplacementAway(s2, s1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isOneAwayCheck("pale", "male"));
        System.out.println(isOneAwayCheck("apple", "aples"));
        System.out.println(isOneAwayCheck("anana", "banana"));
    }
}
