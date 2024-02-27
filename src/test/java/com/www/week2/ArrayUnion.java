package com.www.week2;

import java.util.Scanner;

/**
 * @author Leo
 * @date 2024/2/27 11:47
 */
public class ArrayUnion {

    public static int[] union(int[] a, int[] b) {
        if (a == null || b == null){
            return null;
        }

        if (a.length == 0 || b.length == 0){
            return null;
        }


            if (flag){
                int[] arr = new int[resultArr.length];
                for (int j = 0; j < resultArr.length; j++) {
                    arr[j] = resultArr[j];
                }
                resultArr = new int[++resultLength];
                for (int j = 0; j < a.length; j++) {
                    resultArr[j] = arr[j];
                }

                resultArr[resultLength - 1] = i;
            }
        }
        return resultArr;*/
    }

    public static int[] mergedArray(int[] a, int[] b) {
        int[] newArray = new int[a.length + b.length];
        int index = 0;

        for (int number : a){
            newArray[index++] = number;
        }
        for (int number : b){
            newArray[index++] = number;
        }
        return newArray;
    }

    public static int[] removeDuplicates(int[] array) {
        int end = array.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (array[i] == array[j]) {
                    int shiftLeft = j;
                    for (int k = j+1; k < end; k++, shiftLeft++) {
                        array[shiftLeft] = array[k];
                    }
                    end--;
                    j--;
                }
            }
        }

        int[] whitelist = new int[end];
        for (int i = 0; i < end; i++) {
            whitelist[i] = array[i];
        }

        return whitelist;
    }

    public static int[] sortArray(int[] array){

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lengthA = sc.nextInt();
        int[] arrA = new int[lengthA];
        int lengthB = sc.nextInt();
        int[] arrB = new int[lengthB];


        for (int i = 0; i < lengthA; i++) {
            arrA[i] = sc.nextInt();
        }

        for (int i = 0; i < lengthA; i++) {
            arrB[i] = sc.nextInt();
        }

        //int[] union = union(arrA, arrB);
    }
}
