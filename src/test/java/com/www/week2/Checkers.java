package com.www.week2;

import java.util.Scanner;

/**
 * @author Leo
 * @date 2024/2/27 16:30
 */
public class Checkers {
    private final static String[][] board = new String[8][8]; // 8x8
    private final static Scanner sc = new Scanner(System.in);
    private static boolean whiteTurn = true;
    private static boolean kingWhiteTurn = false;
    private static String currentChess = " ";
    private static String opponentChess = " ";
    private static String kingCurrentChess = " ";
    private static String kingOpponentChess = " ";

    private static void initialiseBoard() {
        // Implement this method to fill the board array with pieces in their starting positions.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i + j) % 2 != 0){
                    if (i < 3){
                        board[i][j] = "w";
                    }
                    else if (i > 4){
                        board[i][j] = "b";
                    }else {
                        board[i][j] = " ";
                    }
                }else {
                    board[i][j] = " ";
                }
            }
        }
    }

    /**
     * Displays the current state of the board to the console.
     */
    private static void displayBoard() {
        // Implement this method to print the board to the console.
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    /**
     * Main game loop. Handles player turns and checks for game end conditions.
     */
    private static void startGame() {
        // Implement the game loop, handling player input, turn switching, and win condition checking.
        while (!isGameOver()){
            displayBoard();
            String userInput = sc.nextLine();
            if ("exit".equals(userInput)){
                System.out.println();
                System.out.println();
                break;
            }

            // move
            if (processMove(userInput)){
                whiteTurn = !whiteTurn;
            }else {
                System.out.println();
                System.out.println("Error!");
            }
            System.out.println();
        }
    }

    /**
     * Processes a player's move.
     *
     * @param move A string representing the player's move (e.g., "C3 to D4").
     * @return true if the move is valid and executed, false otherwise.
     */
    private static boolean processMove(String move) {
        // Implement this method to process the player's move.
        String[] individual = move.split(" to ");
        if (individual.length != 2){
            return false;
        }
        // A6
        int formRow = individual[0].charAt(1) - '1';
        int formCol = individual[0].charAt(0) - 'A';
        // System.out.println("formRow: " + formRow + " formCol: " + formCol);
        // B5
        int toRow = individual[1].charAt(1) - '1';
        int toCol = individual[1].charAt(0) - 'A';
        // System.out.println("toRow: " + toRow + " toCol: " + toCol);
        // You should validate the move and execute it if it's valid.
        return isValidMove(formRow, formCol, toRow, toCol);
    }

    /**
     * Checks if a move is valid.
     *
     * @param fromRow the starting row of the move.
     * @param fromCol the starting column of the move.
     * @param toRow   the ending row of the move.
     * @param toCol   the ending column of the move.
     * @return true if the move is legal, false otherwise.
     */
    private static boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        // Implement this method to check if a move is legal according to the rules of Checkers.
        if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7 || toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7){
            return false;
        }
        if (!board[toRow][toCol].equals(" ")){
            return false;
        }

        // normal chess
        currentChess = whiteTurn ? "b" : "w";
        opponentChess = whiteTurn ? "w" : "b";
        // king chess
        kingCurrentChess = kingWhiteTurn ? "B" : "W";
        kingOpponentChess = kingWhiteTurn ? "W" : "B";

        if (kingWhiteTurn){
            System.out.println("king");
            // King normal moving
            if (
                    Math.abs(fromRow - toRow) == 1
                            && Math.abs(fromCol - toCol) == 1
                            && board[fromRow][fromCol].equals(kingCurrentChess)  ||
                            (Math.abs(fromRow - toRow) == 2
                                    && Math.abs(fromCol - toCol) == 2
                                    && board[fromRow][fromCol].equals(kingCurrentChess)
                                    && board[(fromRow + toRow) / 2][(fromCol + toCol) / 2].equals(kingCurrentChess)
                            ))
            {
                board[fromRow][fromCol] = " ";
                board[toRow][toCol] = kingCurrentChess;
                kingWhiteTurn = !kingWhiteTurn;
                return true;
            }

            // King captures chess
            if(Math.abs(fromRow - toRow) == 2
                    && Math.abs(fromCol - toCol) == 2
                    && board[fromRow][fromCol].equals(kingCurrentChess)
                    && board[(fromRow + toRow) / 2][(fromCol + toCol) / 2].equals(kingOpponentChess)
            ){

                if (board[(fromRow + toRow) / 2][(fromCol + toCol) / 2].equals(kingOpponentChess) || board[(fromRow + toRow) / 2][(fromCol + toCol) / 2].equals(opponentChess)) {
                    board[fromRow][fromCol] = " ";
                    board[toRow][toCol] = kingCurrentChess;
                    board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = " ";
                }else {
                    board[fromRow][fromCol] = " ";
                    board[toRow][toCol] = kingCurrentChess;
                }

                kingWhiteTurn = !kingWhiteTurn;
                return true;
            }
        } else {
            // normal moving
            if (
                    (Math.abs(fromRow - toRow) == 1 && Math.abs(fromCol - toCol) == 1 && board[fromRow][fromCol].equals(currentChess))
            ){
                int rowDiff = toRow - fromRow;
                int colDiff = Math.abs(toCol - fromCol);

                if (currentChess.equals("b") && rowDiff != -1){
                    return false;
                }else if (currentChess.equals("w")&& rowDiff != 1){
                    return false;
                }

                if (colDiff != 1){
                    return false;
                }

                board[fromRow][fromCol] = " ";
                board[toRow][toCol] = currentChess;
                if (currentChess.equals("b") && toRow == 0){
                    board[toRow][toCol] = "B";
                } else if (currentChess.equals("w") && toRow == 7){
                    board[toRow][toCol]= "W";
                }
                return true;
            }

            // capturing chess
            if (Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2
                    && board[fromRow][fromCol].equals(currentChess)
            ){

                int rowDiff = toRow - fromRow;
                int colDiff = Math.abs(toCol - fromCol);

                if (currentChess.equals("b") && rowDiff != -2){
                    return false;
                }else if (currentChess.equals("w")&& rowDiff != 2){
                    return false;
                }

                if (colDiff != 2){
                    return false;
                }

                if (board[(fromRow + toRow) / 2][(fromCol + toCol) / 2].equals(opponentChess)){
                    board[fromRow][fromCol] = " ";
                    board[toRow][toCol] = currentChess;
                    board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = " ";
                }else {
                    board[fromRow][fromCol] = " ";
                    board[toRow][toCol] = currentChess;
                }

                if (currentChess.equals("b") && toRow == 0){
                    board[toRow][toCol] = "B";
                } else if (currentChess.equals("w") && toRow == 7){
                    board[toRow][toCol]= "W";
                }
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if the game has ended.
     *
     * The program should terminate if the game has finished.
     */
    private static boolean isGameOver() {
        // Implement this method to check for win conditions.
        boolean hasWhite = false;
        boolean hasBlack = false;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                String chess = board[row][col];
                if (chess.equals("w") || chess.equals("W")){
                    hasWhite = true;
                } else if (chess.equals("b") || chess.equals("B")){
                    hasBlack = true;
                }
            }
        }

        if (!hasWhite || !hasBlack){
            return true;
        }

//        boolean hasStillMove = false;
//        for (int i = 0; i < 8 && !hasStillMove; i++) {
//            for (int j = 0; j < 8 && !hasStillMove; j++) {
//                String chess = board[i][j];
//                if (
//                        ((chess.equals("w") || chess.equals("W")) && !whiteTurn)
//                        || ((chess.equals("b") || chess.equals("B")) && !whiteTurn)
//                ) {
//                    int direction = whiteTurn ? 1 : -1;
//                    int[] rows = {i + direction, i + 2 * direction};
//                    int[] cols = {j - 1, j + 1};
//                    for (int row : rows){
//                        for (int col : cols){
//                            if (isValidMove(i, j, row, col)){
//                                hasStillMove = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        if (!hasStillMove){
//            return true;
//        }

        return false;
    }

    /**
     * Main method to run the game.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        initialiseBoard();
        startGame();
    }
}