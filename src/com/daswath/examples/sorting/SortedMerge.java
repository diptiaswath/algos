package com.daswath.examples.sorting;

import java.util.Arrays;

/**
 * You are given 2 sorted arrays A and B with enough buffer at the end of A to hold
 * all elements of array B. Write a method to merge
 */
public class SortedMerge {

    public static void merge(int[] a, int[] b, int lastA, int lastB) {
        int lastIndexOfA = lastA - 1;
        int lastIndexOfB = lastB - 1;
        int mergedIndex = lastIndexOfA + lastIndexOfB + 1;

        System.out.println(mergedIndex);
        while (lastIndexOfB >= 0) {
            if (lastIndexOfA >= 0 && a[lastIndexOfA] > b[lastIndexOfB]) {
                a[mergedIndex] = a[lastIndexOfA--];
            } else {
                a[mergedIndex] = b[lastIndexOfB--];
            }
            System.out.println(mergedIndex);
            mergedIndex--;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 7, 8, 9, 0, 0, 0};
        int[] b = {1, 2, 3};
        merge(a, b, 4, 3);

        AnagramSorter.AnagramComparator ac = new AnagramSorter.AnagramComparator();
        String s1 = "race";
        String s2 = "care";

        String[] sArray = {"mare", "dare", "care", "cars", "race"};
        System.out.println(ac.compare(s1, s2) == 0);
        Arrays.sort(sArray, ac);
        for (String s : sArray) {
            System.out.println(s);
        }

    }
}
