package com.www.week2;

import java.util.Scanner;

/**
 * @author Leo
 * @date 2024/2/27 16:30
 */
public class Checkers {
    private char[][] board = new char[8][8]; // 8x8
    private Scanner scanner = new Scanner(System.in);

    public void initialiseBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = ' ';
                } else if (i < 3) {
                    board[i][j] = 'b';
                } else if (i > 4) {
                    board[i][j] = 'w';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.print("|");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public void startGame() {
        initialiseBoard();
        displayBoard();
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("请输入移动指令（例如：C3 to D4），或者输入exit来结束游戏:");
            String input = scanner.nextLine().trim();
            if ("exit".equals(input)) {
                gameRunning = false;
                System.out.println("GameOver");
                break;
            }

        }
    }

    public static void main(String[] args) {
        Checkers game = new Checkers();
        game.startGame();
    }
}
