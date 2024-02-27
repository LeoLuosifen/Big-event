package com.www.week2;

import java.util.Scanner;

/**
 * @author Leo
 * @date 2024/2/27 9:48
 */
public class ArrayMerge {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        // 二维数组的长度
//        int a_line = sc.nextInt();
//        int a_column = sc.nextInt();
//        int[][] arrayA = new int[a_line][a_column];
//
//        int b_line = sc.nextInt();
//        int b_column = sc.nextInt();
//        int[][] arrayB = new int[b_line][b_column];

//        int[][] arr = new int[4][3];
//        System.out.println(arr.length);
    }

    public static int[][] mergeArrays(int[][] arrayA, int[][] arrayB){

        if (arrayA.length == 0 || arrayA[0].length == 0
            || arrayB.length == 0 || arrayB[0].length == 0){
            return null;
        }

        if (arrayA.length != arrayB.length){
            return null;
        }

        int rows= arrayA.length;
        int columns = arrayA[0].length + arrayB[0].length;

        int[][] mergedArray = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < arrayA.length; j++) {
                mergedArray[i][j] = arrayA[i][j];
            }
            for (int j = 0; j < arrayB.length; j++) {
                mergedArray[i][arrayA.length + j] = arrayB[i][j];
            }
        }
        return mergedArray;
    }
}
