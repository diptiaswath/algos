package com.daswath.examples.moderate;

/**
 * Created by DAswath on 10/12/2016.
 */
public class SmallestDifference {

    /**
     * Given 2 arrays of integers, find the pair (one element from each array)
     * which will give the smallest (non-negative) difference.
     * Return the difference.
     * @param a
     * @param b
     * @return
     */
    public int getSmallestDifference(int[] a, int[] b) {
        int aCtr = 0;
        int bCtr = 0;
        int sDiff = Integer.MAX_VALUE;
        while (aCtr < a.length && bCtr < b.length) {
            int absDiff = Math.abs(a[aCtr] - b[bCtr]);
            if (absDiff < sDiff) {
                sDiff = absDiff;
            }

            if (a[aCtr] < b[bCtr]) {
                aCtr++;
            } else {
                bCtr++;
            }
        }
        return sDiff;
    }
}
