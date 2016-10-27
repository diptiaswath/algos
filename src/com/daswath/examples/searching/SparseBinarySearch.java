package com.daswath.examples.searching;

/**
 * Created by DAswath on 10/8/2016.
 */

/**
 * Given a sorted array of strings mixed with empty strings, write
 * a method that finds the location of a target string
 *
 * Strategy - Modification to binsary search where if the string at mid
 * is empty adjust the mid to the closest non-empty string
 */
public class SparseBinarySearch {

    private static int locateTarget(String[] array, String target, int first, int last) {
        if (first > last) {
            return -1;
        }
        int mid = (last + first) / 2;

        // if the middle element in array is empty, adjust middle to closest non-empty string
        if (array[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first || right > last) {
                    return -1;
                }
                if (right <= last && !array[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !array[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        if (target.compareTo(array[mid]) == 0) {
            return mid;
        } else if (target.compareTo(array[mid]) < 0) {
            return locateTarget(array, target, first, mid -1 );
        } else {
            return locateTarget(array, target, mid + 1, last);
        }
    }

    public static int sparseBinarySearch(String[] array, String target) {
        if (target == null || target == "" || array == null) {
            throw new IllegalArgumentException();
        }
        return locateTarget(array, target, 0, array.length);
    }


}
