package com.www.week2;

import java.util.Scanner;

/**
 * @author Leo
 * @date 2024/2/27 9:41
 * int[] array = {1, 1, 5, 6, 5, 3, 8, 1, 9, 2, 8};
 * int result = count(array, 1); //3
 */
public class Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        int element = sc.nextInt();
        int result = count(array, element);
    }

    public static int count(int[] array, int element) {

        if (array == null || array.length == 0){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                count++;
            }
        }

        return count;
    }
}
