package com.company.utils;

import com.company.gameElements.Player;
import com.company.gameElements.Board;

import java.util.Scanner;

public class Creator {

    //Method creates game board

    public char[][] createBoard() {
        Board board = new Board();
        char[][] tab = new char[3][3];
        board.fillBoard(tab);
        board.printBoard(tab);
        return tab;
    }


    //Method creates Computer Player

    public Player createComputerPlayer(int number) {
        System.out.println("Im creating Computer player.");
        Player player = new Player("Computer");
        return player;
    }

    //Method creates Human Player

    public Player createPlayer(int numberPlayerCounter) {
        Scanner scanner = new Scanner(System.in);
        String name;

        System.out.println("Enter name player no." + numberPlayerCounter + ":");
        name = scanner.nextLine();

        Player player = new Player(name);

        return player;
    }
}
