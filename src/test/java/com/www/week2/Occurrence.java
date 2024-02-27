package com.www.week2;

import java.util.Scanner;

/**
 * @author Leo
 * @date 2024/2/27 12:14
 */
public class Occurrence {

    public static void main(String[] args) {
        //YOUR CODE HERE
        Scanner sc = new Scanner(System.in);
        String arrays = sc.next();
        int[] numbers = new int[10];

        getCount(arrays, numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(i + ": " + numbers[i]);
        }
    }

    private static void getCount(String arrays, int[] numbers) {
        for (int i = 0; i < arrays.length(); i++) {
            String digit = String.valueOf(arrays.charAt(i));
            for (int j = 0; j < 10; j++) {
                int number = Integer.parseInt(digit);
                if (number == j){
                    numbers[number]++;
                }
            }
        }
    }

}
