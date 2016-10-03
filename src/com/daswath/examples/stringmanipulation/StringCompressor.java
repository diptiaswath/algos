package com.daswath.examples.stringmanipulation;

/**
 * Created by DAswath on 10/3/2016.
 */
public class StringCompressor {

    /**
     * Perform basic string compression using counts of repeated characters
     * e.g, string aabcccccaaa will become a2b1c5a3
     * @param input
     * @return
     */
    public static String compressString(String input) {
        StringBuilder compressedStr = new StringBuilder();
        int ctr = 0;
        int i = 0;
        while (i < input.length()) {
            char cur = input.charAt(i);
            ctr++;
            if ( i + 1 >= input.length() || cur != input.charAt(i + 1)) {
                compressedStr.append(cur);
                compressedStr.append(ctr);
                ctr = 0;
            }
            i++;
        }
        return compressedStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }
}
