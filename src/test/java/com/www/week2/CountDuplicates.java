package com.www.week2;

import java.util.Scanner;

/**
 * @author Leo
 * @date 2024/2/27 10:54
 */
public class CountDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        int result = countDuplicates(arr);
    }

    public static int countDuplicates(int[] a) {

        if (a == null || a.length == 0){
            return 0;
        }

        int maxCount = 0;
        boolean[] flag = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            if (!flag[i]){
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == a[j] && !flag[j]){
                        maxCount++;
                        flag[j] = true;
                        break;
                    }
                }
            }
        }
        return maxCount;
    }
}
