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
        boolean[] used = new boolean[input.length()];
        int a = Character.valueOf('a');
        int z = Character.valueOf('z');
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            if (val >= a && val <= z) {
                val -= a;
                if (used[val]) {
                    return false;
                }
                used[val] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       //String input = "baabcdefghhijkl";

       // String actual = getLongestSubWithNoDuplicates(input);
       // System.out.println(actual);


      /*  String input = "abcd";
        char[] output = new char[input.length()];
        int[] used = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            used[i] = -1;
        }
        List<String> allPermutations = new ArrayList<String>();
        permute(input, output, used, 0, allPermutations);
        for (String p : allPermutations) {
            System.out.println(p);
        }*/

        //System.out.println(Character.getNumericValue(''));

        System.out.println(isUniqueCharacters("abcdd"));
    }
}