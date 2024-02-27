package com.www.week2;

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

        int a_row = sc.nextInt();
        int a_col = sc.nextInt();
        int b_row = sc.nextInt();
        int b_col = sc.nextInt();

        if (a_col != b_row){
            System.out.println("Invalid input.");
            sc.close();
            return;
        }

        int[][] a = new int[a_row][a_col];
        int[][] b = new int[b_row][b_col];

        for (int i = 0; i < a_row; i++) {
            for (int j = 0; j < a_col; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < b_row; i++) {
            for (int j = 0; j < b_col; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        boolean a1 = isZero(a, a_row, a_col);
        boolean b1 = isZero(b, b_row, b_col);

        if (a1 || b1){
            System.out.println(0);
            return;
        }

        int[][] c = new int[a_row][b_col];
        for (int i = 0; i < a_row; i++) {
            for (int j = 0; j < b_col; j++) {
                for (int k = 0; k < a_col; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        // input
        for (int i = 0; i < a_row; i++) {
            for (int j = 0; j < b_col; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
}
