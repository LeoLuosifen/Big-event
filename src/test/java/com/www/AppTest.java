package com.www;

import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arrs = new int[length];

        for (int i = 0; i < arrs.length; i++) {
            int element = sc.nextInt();
            arrs[i] = element;
        }

        int number = sc.nextInt();

        boolean contains = contains(arrs, number);
    }

    public static boolean contains(int[] a, int element) {

        for (int i = 0; i < a.length; i++) {
            if (element == a[i]){
                return true;
            }
        }
        return false;
    }
}
