package com.daswath.examples.stringmanipulation;

/**
 * Created by DAswath on 10/3/2016.
 */
public class ZeroMatrix {

    /**
     * If an element in an M * N matrix is 0, its entire row and
     * column are to be zeroed out
     *
     * @param a
     * @return
     */
    public static void zeroRowColumnOfZeroValue(int[][] a) {
        boolean[] row = new boolean[a.length];
        boolean[] column = new boolean[a[0].length];

        // first identify which row and column have a zero value
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // for a row identified as having a zero value, zero out
        // whole row
        for (int i = 0; i < a.length; i++) {
            if (row[i]) {
                nullifyWholeRow(a, i);
            }
        }

        // for a column identified as having a zero value, zero out
        // whole column
        for (int j = 0; j < a[0].length; j++) {
            if (column[j]) {
                nullifyWholeColumn(a, j);
            }
        }
    }



    private static void nullifyWholeRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyWholeColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }
}
