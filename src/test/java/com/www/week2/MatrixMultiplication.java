package com.www.week2;

import java.util.Scanner;

/**
 * @author Leo
 * @date 2024/2/27 12:15
 */
public class MatrixMultiplication {

    public static boolean isZero(int[][] arr, int row, int col){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a_weight = sc.nextInt();
        int a_height = sc.nextInt();
        int b_weight = sc.nextInt();
        int b_height = sc.nextInt();

        if (a_weight != b_height){
            System.out.println("Invalid input.");
            sc.close();
            return;
        }

        int[][] a = new int[a_height][a_weight];
        int[][] b = new int[b_height][b_weight];

        for (int i = 0; i < a_height; i++) {
            for (int j = 0; j < a_weight; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < b_height; i++) {
            for (int j = 0; j < b_weight; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        boolean a1 = isZero(a, a_height, a_weight);
        boolean b1 = isZero(b, b_height, b_weight);

        if (a1 || b1){
            System.out.println(0);
            return;
        }

        int[][] c = new int[a_height][b_weight];
        for (int i = 0; i < a_height; i++) {
            for (int j = 0; j < b_weight; j++) {
                for (int k = 0; k < a_weight; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        // input
        for (int i = 0; i < a_height; i++) {
            for (int j = 0; j < b_weight; j++) {
                if (j == b_weight - 1) {
                    System.out.print(c[i][j]);
                }else {
                    System.out.print(c[i][j] + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
