package com.daswath.examples.sorting;

import com.daswath.examples.utils.HashMapList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Two strings are anagrams if they have the same characters
 * in different order.
 * Problem : Sort an array of strings so all anagrams are next to each other
 * Solution1 : Arrays.sort(sArray, new AnagramSorter.AnagramComparator())
 * Solution2 :
 */
public class AnagramSorter {

    /**
     * A static nested class meant to be a helper to first sort the
     * characters in a string and then compare 2 strings
     */
    static class AnagramComparator implements Comparator<String> {
        private String sort(String s) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            return new String(sArr);
        }

        public int compare(String s1, String s2) {
            return sort(s1).compareTo(sort(s2));
        }
    }

    private static String sortChars(String s) {
        char[] cArray = s.toCharArray();
        Arrays.sort(cArray);
        return new String(cArray);
    }

    /**
     * Solution2 : No need to sort the whole input array of strings that takes O(n log n) time
     * Instead, group strings that have the same set of characters together.
     * Map a key (sorted chars in the string) to a list of strings that have the same set of characters
     * @param array
     */
    public static void sort(String[] array) {
        HashMapList<String, String> aMap = new HashMapList<String, String>();

        for (String s : array) {
            String key = sortChars(s);
            aMap.put(key, s);
        }

        int index = 0;
        for (String s : aMap.keySet()) {
            ArrayList<String> groupedAnagramsForSortedCharKey = aMap.get(s);
            for (String aValue : groupedAnagramsForSortedCharKey) {
                array[index++] = aValue;
            }
        }
    }


}
