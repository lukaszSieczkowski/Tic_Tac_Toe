package com.company.gameElements;

import com.company.utils.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    /**
     * Method shows main menu
     */

    public void showMenu() {
        System.out.println("Welcome in TIC TAC TOE game");
        System.out.println("1 - Player vs. Player");
        System.out.println("2 - Player vs. Computer");
        System.out.println("3 - Close Game");
    }

    /**
     * Method responsible for mechanics main menu and Player vs Player game.
     */

    public void mainMenu() {

        Scanner scanner = new Scanner(System.in);
        int switcher;

        showMenu();

        while (true) {
            try {
                switcher = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Incorect value");
                scanner.next();
            }
        }
        switch (switcher) {
            case (1): {

                Sounds sound = new Sounds();
                Creator creator = new Creator();
                Rand rand = new Rand();
                Move move = new Move();
                Checker checker = new Checker();
                Sleeper sleeper = new Sleeper();
                int counter = 0;
                boolean player1Start;
                boolean isEnd;
                boolean isFull;
                char tab[][];


                Player player_1 = creator.createPlayer(++counter);
                Player player_2 = creator.createPlayer(++counter);
                player1Start = rand.whoStarts(player_1, player_2);

                if (player1Start == false) {
                    Player switchPlayer = player_1;
                    player_1 = player_2;
                    player_2 = switchPlayer;
                }
                player_1.setSymbol(Symbols.X.getChar());
                player_2.setSymbol(Symbols.O.getChar());

                tab = creator.createBoard();

                while (true) {
                    move.makeHalfRound(player_1, tab);
                    isEnd = checker.checkThreeFliedsValue(tab);
                    isFull = checker.checkTableIsFull(tab);

                    if (isEnd == true) {
                        sound.playSound("applause.wav");
                        System.out.println(player_1.getPlayerName() + " WON !!!!");
                        sleeper.wait(3000);
                        mainMenu();
                        break;
                    } else if (isFull == false) {
                        System.out.println("No possibility to do another move.");
                        System.out.println("Nobody won !!!");
                        mainMenu();
                        break;
                    }
                    move.makeHalfRound(player_2, tab);
                    isEnd = checker.checkThreeFliedsValue(tab);
                    isFull = checker.checkTableIsFull(tab);

                    if (isEnd == true) {
                        System.out.println(player_2.getPlayerName() + " WON !!!!");
                        sound.playSound("applause.wav");
                        sleeper.wait(3000);
                        mainMenu();
                        break;
                    } else if (isFull == false) {
                        System.out.println("No possibility to do another move.");
                        System.out.println("Nobody won !!!");
                        System.out.println();
                        mainMenu();
                        break;
                    }
                }
            }
            case (2): {
                levelMenu();
                break;

            }
            case (3): {
                System.out.println("Bye Bye");
                System.exit(0);
            }
            default: {
                System.out.println("Incorect value");
                System.out.println();
                mainMenu();
            }
        }
    }


    /**
     * Method shows level menu and is responsible for mechanics Player vs COmputer game
     */

    public void levelMenu() {

        Scanner scanner = new Scanner(System.in);
        int switcher;
        Sounds sound = new Sounds();
        Creator creator = new Creator();
        Checker checker = new Checker();
        Rand rand = new Rand();
        Move move = new Move();
        Sleeper sleeper = new Sleeper();
        int counter = 0;
        boolean player1Start;
        boolean isEnd;
        boolean isFull;
        char tab[][];

        System.out.println("Player vs. Computer");
        System.out.println("1 - Level Easy");
        System.out.println("2 - Level Medium");
        System.out.println("3 - Level Hard");
        System.out.println("4 - Main Menu");

        while (true) {
            try {
                switcher = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Incorect value");
                scanner.next();
            }
        }
        switch (switcher) {
            case (1): {

                Player player_1 = creator.createPlayer(++counter);
                Player player_2 = creator.createComputerPlayer(++counter);
                player1Start = rand.whoStarts(player_1, player_2);

                if (player1Start == false) {
                    Player switchPlayer;
                    switchPlayer = player_1;
                    player_1 = player_2;
                    player_2 = switchPlayer;
                }
                player_1.setSymbol(Symbols.X.getChar());
                player_2.setSymbol(Symbols.O.getChar());

                tab = creator.createBoard();

                while (true) {
                    if (player_1.getPlayerName() == "Computer") {
                        move.makeHalfRoundComputerEasy(player_1, tab);
                    } else {
                        move.makeHalfRound(player_1, tab);
                    }

                    isEnd = checker.checkThreeFliedsValue(tab);
                    isFull = checker.checkTableIsFull(tab);

                    if (isEnd == true) {
                        sound.playSound("applause.wav");
                        System.out.println(player_1.getPlayerName() + " WON !!!!");
                        sleeper.wait(3000);
                        mainMenu();
                        break;
                    }
                    if (isFull == false) {
                        System.out.println("No possibility to do another move.");
                        System.out.println("Nobody won !!!");
                        mainMenu();
                        break;
                    }

                    if (player_2.getPlayerName() != "Computer") {
                        move.makeHalfRound(player_2, tab);
                    } else {
                        move.makeHalfRoundComputerEasy(player_2, tab);
                    }

                    isEnd = checker.checkThreeFliedsValue(tab);
                    isFull = checker.checkTableIsFull(tab);
                    if (isEnd == true) {
                        sound.playSound("applause.wav");
                        System.out.println(player_2.getPlayerName() + " WON !!!!");
                        sleeper.wait(3000);
                        mainMenu();
                        break;
                    }
                    if (isFull == false) {
                        System.out.println("No possibility to do another move.");
                        System.out.println("Nobody won !!!");
                        mainMenu();
                        break;
                    }
                }

            }
            case (2): {

                Player player_1 = creator.createPlayer(++counter);
                Player player_2 = creator.createComputerPlayer(++counter);
                player1Start = rand.whoStarts(player_1, player_2);

                if (player1Start == false) {
                    Player switchPlayer;
                    switchPlayer = player_1;
                    player_1 = player_2;
                    player_2 = switchPlayer;
                }
                player_1.setSymbol(Symbols.X.getChar());
                player_2.setSymbol(Symbols.O.getChar());

                tab = creator.createBoard();

                while (true) {
                    if (player_1.getPlayerName() == "Computer") {
                        move.makeHalfRoundComputerMedium(player_1, tab);

                    } else {
                        move.makeHalfRound(player_1, tab);
                    }

                    isEnd = checker.checkThreeFliedsValue(tab);
                    isFull = checker.checkTableIsFull(tab);

                    if (isEnd == true) {
                        sound.playSound("applause.wav");
                        System.out.println(player_1.getPlayerName() + " WON !!!!");
                        sleeper.wait(3000);
                        mainMenu();
                        break;
                    }
                    if (isFull == false) {
                        System.out.println("No possibility to do another move.");
                        System.out.println("Nobody won !!!");
                        mainMenu();
                        break;
                    }

                    if (player_2.getPlayerName() != "Computer") {
                        move.makeHalfRound(player_2, tab);
                    } else {
                        move.makeHalfRoundComputerMedium(player_2, tab);
                    }


                    isEnd = checker.checkThreeFliedsValue(tab);
                    isFull = checker.checkTableIsFull(tab);
                    if (isEnd == true) {
                        sound.playSound("applause.wav");
                        System.out.println(player_2.getPlayerName() + " WON !!!!");
                        sleeper.wait(3000);
                        mainMenu();
                        break;
                    }
                    if (isFull == false) {
                        System.out.println("No possibility to do another move.");
                        System.out.println("Nobody won !!!");
                        mainMenu();
                        break;
                    }
                }
            }
            case (3): {
                Player player_1 = creator.createPlayer(++counter);
                Player player_2 = creator.createComputerPlayer(++counter);
                player1Start = rand.whoStarts(player_1, player_2);

                if (player1Start == false) {
                    Player switchPlayer;
                    switchPlayer = player_1;
                    player_1 = player_2;
                    player_2 = switchPlayer;
                }
                player_1.setSymbol(Symbols.X.getChar());
                player_2.setSymbol(Symbols.O.getChar());

                tab = creator.createBoard();

                while (true) {
                    if (player_1.getPlayerName() == "Computer") {
                        move.makeHalfRoundComputerHard(player_1, tab);

                    } else {
                        move.makeHalfRound(player_1, tab);
                    }

                    isEnd = checker.checkThreeFliedsValue(tab);
                    isFull = checker.checkTableIsFull(tab);

                    if (isEnd == true) {
                        sound.playSound("applause.wav");
                        System.out.println(player_1.getPlayerName() + " WON !!!!");
                        sleeper.wait(3000);
                        mainMenu();
                        break;
                    }
                    if (isFull == false) {
                        System.out.println("No possibility to do another move.");
                        System.out.println("Nobody won !!!");
                        mainMenu();
                        break;
                    }

                    if (player_2.getPlayerName() != "Computer") {
                        move.makeHalfRound(player_2, tab);
                    } else {
                        move.makeHalfRoundComputerHard(player_2, tab);
                    }


                    isEnd = checker.checkThreeFliedsValue(tab);
                    isFull = checker.checkTableIsFull(tab);
                    if (isEnd == true) {
                        sound.playSound("applause.wav");
                        System.out.println(player_2.getPlayerName() + " WON !!!!");
                        sleeper.wait(3000);
                        mainMenu();
                        break;
                    }
                    if (isFull == false) {
                        System.out.println("No possibility to do another move.");
                        System.out.println("Nobody won !!!");
                        mainMenu();
                        break;
                    }
                }

            }
            case (4): {
                mainMenu();
            }
            default: {
                System.out.println("Incorect value");
                System.out.println();
                levelMenu();
            }
        }
    }
}
