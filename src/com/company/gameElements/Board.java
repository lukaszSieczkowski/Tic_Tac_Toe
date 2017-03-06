package com.company.gameElements;

public class Board {

    private char board[][] = new char[3][3];

    /**
     * Getter method for the  board
     * @return  board
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Setter method for theboard
     * @param board  board
     */
    public void setBoard(char[][] board) {
        this.board = board;
    }

    /**
     * Method fills the whole board " " sign
     * @param board board
     * @return board
     */

    public char[][] fillBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    /**
     * Method prints board
     * @param board
     */
    public void printBoard(char[][] board) {
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                System.out.printf(" %s", "");
            }
            if (i == 1 || i == 3 || i == 5) {
                System.out.printf(" %s ", "");
            }
            if (i == 2 || i == 4 || i == 6) {
                System.out.printf("%d", i / 2);
            }
            for (int j = 0; j < 4; j++) {
                if (i == 0 && (j == 1 || j == 2 || j == 3)) {
                    System.out.printf(" %c ", (char) (64 + j));
                }
                if (i == 1 && (j == 1 || j == 2 || j == 3) || i == 3 && (j == 1 || j == 2 || j == 3) || i == 5 && (j == 1 || j == 2 || j == 3)) {
                    System.out.printf(" %s", "-----");
                }
                if (i == 2 && (j == 1 || j == 2 || j == 3)) {
                    System.out.printf(" %c ", board[i - 2][j - 1]);
                }
                if (i == 4 && (j == 1 || j == 2 || j == 3)) {
                    System.out.printf(" %c ", board[i - 3][j - 1]);
                }
                if (i == 6 && (j == 1 || j == 2 || j == 3)) {
                    System.out.printf(" %c ", board[i - 4][j - 1]);
                }
                if (i == 0 || i == 2 || i == 4 || i == 6) {
                    System.out.printf(" %c ", '|');
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
