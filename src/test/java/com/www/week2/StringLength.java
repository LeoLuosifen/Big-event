package com.www.week2;

/**
 * @author Leo
 * @date 2024/2/27 12:14
 */
public class StringLength {

    public static void main(String[] args) {
        if(args.length < 1) {
            return;
        }
        String str = args[0];
        int length = str.length();
        // TODO
        // System.out.println("java StringLength Test");
        System.out.println(str + " is " + length + " characters long");
    }

}
