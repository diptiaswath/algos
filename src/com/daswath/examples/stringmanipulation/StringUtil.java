package com.daswath.examples.stringmanipulation;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    /**
     * PROBLEM 1:
     * Getting the longest possible substring with no duplicates
     * @param input
     * @return
     */
    public static String getLongestSubWithNoDuplicates(String input) {
        String longestSoFar = "";
        String longestSub = new String();

        int[] lastSeen = new int[128];
        for (int i = 0; i < 128; i++) {
            lastSeen[i] = -1;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (lastSeen[c] == -1) {
                longestSoFar = longestSoFar + c;
            } else {
                longestSoFar = input.substring(lastSeen[c] + 1, i + 1);
            }
            lastSeen[c] = i;
            if(longestSoFar.length() > longestSub.length()) {
                longestSub = longestSoFar;
            }
        }
        return longestSub;
    }

    /**
     * PROBLEM 2:
     * Generate all possible permutations of a given string -
     * runtime is factorial not exponential
     * @param input
     * @param output
     * @param used
     * @param recursLev
     * @param ps
     */
    public static void permute(String input, char[] output, int[] used, int recursLev, List<String> ps) {
        if (recursLev == input.length()) {
            ps.add(new String(output));
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            if (used[i] != -1) {
                continue;
            }
            output[recursLev] = input.charAt(i);
            used[i] = 1;
            permute(input, output, used, recursLev + 1, ps);
            used[i] = -1;
        }
    }

    /**
     * PROBLEM 3:
     * Return true if a string has all unique characters.
     * Remember to use a boolean array for the characters seen
     * @param input
     * @return
     */
    public static boolean isUniqueCharacters(String input) {
        boolean[] used = new boolean[128];
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            if (used[val]) {
                return false;
            }
            used[val] = true;
        }
        return true;
    }

    /**
     * PROBLEM 4:
     * URLify - method to replace all spaces in a string
     * with a '%20'. Assume string has sufficient space at the end
     * to hold extra characters, and that you are given true length
     * of the string excluding the extra space buffer added at the end
     * @param a
     * @param trueLength
     */
    public static void replaceSpaces(char[] a, int trueLength) {
        int spaceCtr = 0;

        // count number of spaces
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ') {
                spaceCtr++;
            }
        }

        // now work backwards
        int index = trueLength + spaceCtr * 3;
        if (trueLength < a.length) {
            a[trueLength] = '\0';
        }

        for (int i = trueLength - 1; i >= 0; i--) {
            if (a[i] != ' ') {
                a[index - 1] = a[i];
                index--;
            } else {
                a[index - 1] = '0';
                a[index - 2] = '2';
                a[index - 3] = '%';
                index -= 3;
            }
        }
    }


    /**
     * PROBLEM 5:
     * String rotation: Check if one word is a rotation of another
     * eg., waterbottle is a rotation of erbottlewat
     *
     */
    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len > 0 && len == s2.length()) {
            StringBuilder s = new StringBuilder(s1);
            s.append(s2);
            return isSubstring(s.toString(), s2);
        }
        return false;
    }

    public static boolean isSubstring(String s1, String s2) {
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < s1.length() && idx2 < s2.length()) {
            if (s1.charAt(idx1) == s2.charAt(idx2)) {
                idx1++;
                idx2++;
            } else {
                idx1++;
            }
        }
        if (idx2 == s2.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "waterbottle";
        String rotatedInput = "erbottlewat";

        System.out.println(isRotation(input, rotatedInput));
    }
}