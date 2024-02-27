package com.www.week2;

import java.util.Scanner;

/**
 * @author Leo
 * @date 2024/2/27 9:41
 */
public class Contains {
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
