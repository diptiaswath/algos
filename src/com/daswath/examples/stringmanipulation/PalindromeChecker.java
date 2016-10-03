package com.daswath.examples.stringmanipulation;

/**
 * Created by DAswath on 10/1/2016.
 */
public class PalindromeChecker {

    /**
     * Check if the input string is a palindrome
     * @param input
     * @return
     */
    public static boolean isPalindrome(String input) {
        int mid = Math.round(input.length()/ 2);
        for (int i = input.length() - 1, j = 0; i > mid; i--, j++) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return a number value of the character. Map characters
     * as follows a -> 0, b -> 1, c -> 2 ...
     * @param c
     * @return
     */
    private static final int getNumericValue(char c) {
        int val = Character.getNumericValue(c);
        if (val > Character.getNumericValue('a') &&
                val < Character.getNumericValue('z')) {
            val -= Character.getNumericValue('a');
            return val;
        }
        return -1;
    }

    private static final int[] buildCharacterFrequencyTable(String input) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (int i = 0; i < input.length(); i++) {
            int val = getNumericValue(input.charAt(i));
            if (val != -1) {
                table[val]++;
            }
        }
        return table;
    }

    private static final boolean isMaxOddCountOne(int[] table) {
        boolean foundOdd = false;
        for (int i = 0; i < table.length; i++) {
            int charCount = table[i];
            if (charCount % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /**
     * Solution is based on the premise that a palindrome permutation cannot
     * have more than 1 odd character count.
     * For odd # length strings, palindrome  can have at max 1 odd character (in the middle)
     * For even # length strings, palindrome has even no of characters
     * @param input
     * @return
     */
    public static boolean isPalindromePermutation(String input) {
        int[] table = buildCharacterFrequencyTable(input);
        return isMaxOddCountOne(table);
    }


    public static void main(String[] args) {
        String input = "mumu";
        System.out.println(isPalindrome(input));
    }
}
