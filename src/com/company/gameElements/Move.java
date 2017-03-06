package com.company.gameElements;

import com.company.utils.Checker;
import com.company.utils.Sleeper;
import com.company.utils.Sounds;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Move {

    /**
     * Method makes one player move (Computer - Easy level)
     * @param player
     * @param table
     */
    public void makeHalfRoundComputerEasy(Player player, char[][] table) {

        Checker checker = new Checker();
        Sounds sound = new Sounds();
        Sleeper sleeper = new Sleeper();

        Board board = new Board();
        char[] player1char;
        int letter;
        int number;

        System.out.println("Computer move !!!!");
        sleeper.wait(3000);
        List<String> coordinatesLSit = checker.checkEmptyFieldForComputer(table);
        player1char = choseFieldForComputer(coordinatesLSit);

        number = player1char[0] - 48;
        letter = player1char[1] - 48;

        table[number][letter] = player.getSymbol();

        sound.playSound("click.wav");
        board.printBoard(table);
    }

    /**
     * Method makes one player move (Computer - Easy Medium)
     * @param player
     * @param table
     */
    public void makeHalfRoundComputerMedium(Player player, char[][] table) {

        Sleeper sleeper = new Sleeper();
        Board board = new Board();
        Sounds sound = new Sounds();
        Checker checker = new Checker();
        char[] player1char;
        int letter;
        int number;

        System.out.println("Computer move !!!!");
        sleeper.wait(3000);

        player1char = checker.checkEmptyFieldForComputerMedium(table, player.getSymbol());

        number = player1char[0] - 48;
        letter = player1char[1] - 48;

        table[number][letter] = player.getSymbol();

        sound.playSound("click.wav");
        board.printBoard(table);
    }

    /**
     * Method makes one player move (Computer - Hard level)
     * @param player
     * @param table
     */
    public void makeHalfRoundComputerHard(Player player, char[][] table) {

        Sleeper sleeper = new Sleeper();
        Board board = new Board();
        Sounds sound = new Sounds();
        Checker checker = new Checker();
        char[] player1char;
        int letter;
        int number;

        System.out.println("Computer move !!!!");
        sleeper.wait(3000);

        player1char = checker.checkEmptyFieldForComputerHard(table, player.getSymbol());

        if(player1char[0]=='x'&& player1char[1]=='y'){
            player1char = checker.checkEmptyFieldForComputerMedium(table, player.getSymbol());
        }

        number = player1char[0] - 48;
        letter = player1char[1] - 48;

        table[number][letter] = player.getSymbol();

        sound.playSound("click.wav");
        board.printBoard(table);
    }


    /**
     * Method makes one player move (Human)
     * @param player
     * @param table
     */
    public void makeHalfRound(Player player, char[][] table) {

        Board board = new Board();
        Sounds sound = new Sounds();
        Checker checker = new Checker();
        char[] player1char;
        int letter;
        int number;
        System.out.println("Your turn " + player.getPlayerName());
        do {
            player1char = playerMove();

            letter = player1char[0] - 48;
            number = player1char[1] - 48;
            if (!checker.checkFieldValue(letter, number, table)) {
                System.out.println("This field is not free !!!");
                sound.playSound("error.wav");
            }
        } while (!checker.checkFieldValue(letter, number, table));

        table[number][letter] = player.getSymbol();

        sound.playSound("click.wav");
        board.printBoard(table);
    }

    /**
     * Methd responsible for enter move data (Human)
     * @return
     */
    public char[] playerMove() {

        Sounds sound = new Sounds();
        char letter = ' ';
        char number = 0;
        char[] coordinatesTab = new char[2];

        do {
            String coordinates;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your sign using format (A1)");

            coordinates = scanner.nextLine();
            letter = coordinates.charAt(0);
            try {
                number = coordinates.charAt(1);
            } catch (StringIndexOutOfBoundsException e) {
                sound.playSound("error.wav");
            }
            if ((letter != 'A' && letter != 'a' && letter != 'B' && letter != 'b' && letter != 'C' && letter != 'c') || (number != '1' && number != '2' && number != '3')) {
                System.out.println("Incorect value !!!");
                sound.playSound("error.wav");
            } else {
                if (letter == 'A' || letter == 'B' || letter == 'C') {
                    coordinatesTab[0] = (char) (letter - 17);
                } else {
                    coordinatesTab[0] = (char) (letter - 49);
                }
                coordinatesTab[1] = (char) (number - 1);
            }
        }
        while ((letter != 'A' && letter != 'a' && letter != 'B' && letter != 'b' && letter != 'C' && letter != 'c') || (number != '1' && number != '2' && number != '3'));

        return coordinatesTab;
    }

    /**
     * Method draws where on empty fields Computer will make a move(Player vs Computer)
     * @param coordinatesList
     * @return
     */
    public char[] choseFieldForComputer(List<String> coordinatesList){
        int listLength;
        int listPlaceNumber;
        String coordinates;
        Random rand = new Random();
        char[]coord ;

        listLength = coordinatesList.size();
        listPlaceNumber = rand.nextInt(listLength);
        coordinates = coordinatesList.get(listPlaceNumber);
        coord = coordinates.toCharArray();

        return coord;
    }
}

