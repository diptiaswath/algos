package com.daswath.examples.utils;

import com.daswath.examples.stringmanipulation.PalindromeChecker;

/**
 * Created by DAswath on 10/10/2016.
 */
public class StairCase {

    public static void print(int n) {
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n; j++) {
                if ((i + j) > n) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       String hello = "HelloWorld";
       System.out.println(hello.substring(5));
        System.out.println(hello);

    }
}
