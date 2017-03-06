package com.company.utils;

import com.company.gameElements.Move;

import java.util.ArrayList;
import java.util.List;

public class Checker {

    /**
     * Method checks is field free
     *
     * @param letter
     * @param number
     * @param tab
     * @return
     */
    public boolean checkFieldValue(int letter, int number, char[][] tab) {
        boolean isFree;
        if (tab[number][letter] == 'X' || tab[number][letter] == 'O') {
            isFree = false;
        } else {
            isFree = true;
        }
        return isFree;
    }

    /**
     * Method checks whether the conditions are met to win the game (3 fields with one sign)
     *
     * @param tab
     * @return
     */
    public boolean checkThreeFliedsValue(char[][] tab) {
        boolean isEndOfTheGame = true;
        if ((tab[0][0] == 'X' && tab[0][1] == 'X' && tab[0][2] == 'X') || (tab[0][0] == 'O' && tab[0][1] == 'O' && tab[0][2] == 'O')) {
            isEndOfTheGame = true;
        } else if ((tab[1][0] == 'X' && tab[1][1] == 'X' && tab[1][2] == 'X') || (tab[1][0] == 'O' && tab[1][1] == 'O' && tab[1][2] == 'O')) {
            isEndOfTheGame = true;
        } else if ((tab[2][0] == 'X' && tab[2][1] == 'X' && tab[2][2] == 'X') || (tab[2][0] == 'O' && tab[2][1] == 'O' && tab[2][2] == 'O')) {
            isEndOfTheGame = true;
        } else if ((tab[0][0] == 'X' && tab[1][0] == 'X' && tab[2][0] == 'X') || (tab[0][0] == 'O' && tab[1][0] == 'O' && tab[2][0] == 'O')) {
            isEndOfTheGame = true;
        } else if ((tab[0][1] == 'X' && tab[1][1] == 'X' && tab[2][1] == 'X') || (tab[0][1] == 'O' && tab[1][1] == 'O' && tab[2][1] == 'O')) {
            isEndOfTheGame = true;
        } else if ((tab[0][2] == 'X' && tab[1][2] == 'X' && tab[2][2] == 'X') || (tab[0][2] == 'O' && tab[1][2] == 'O' && tab[2][2] == 'O')) {
            isEndOfTheGame = true;
        } else if ((tab[0][0] == 'X' && tab[1][1] == 'X' && tab[2][2] == 'X') || (tab[0][0] == 'O' && tab[1][1] == 'O' && tab[2][2] == 'O')) {
            isEndOfTheGame = true;
        } else if ((tab[0][2] == 'X' && tab[1][1] == 'X' && tab[2][0] == 'X') || (tab[0][2] == 'O' && tab[1][1] == 'O' && tab[2][0] == 'O')) {
            isEndOfTheGame = true;
        } else {
            isEndOfTheGame = false;
        }
        return isEndOfTheGame;
    }

    /**
     * Method check is board full;
     *
     * @param tab
     * @return
     */
    public boolean checkTableIsFull(char[][] tab) {
        boolean isEmpty = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] == ' ') {
                    isEmpty = true;
                }
            }
        }
        return isEmpty;
    }

    /**
     * Method generates list of empty fields on board
     *
     * @param tab
     * @return
     */
    public List<String> checkEmptyFieldForComputer(char[][] tab) {

        List<String> coordinatesList = new ArrayList<String>();
        String a;
        String b;
        String ab;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] == ' ') {
                    a = Integer.toString(i);
                    b = Integer.toString(j);
                    ab = a + b;
                    coordinatesList.add(ab);
                }
            }
        }
        return coordinatesList;
    }

    /**
     * Method  check vertical fields if oponent will win in next move (Player vs Computer - Medium)
     *
     * @param tab
     * @param sign
     * @return
     */
    public String verticalCheck(char[][] tab, char sign) {
        int counter = 0;
        String a;
        String b;
        String ab = null;
        for (int j = 0; j < 3; j++) {
            counter = 0;
            for (int i = 0; i < 3; i++) {
                if (tab[i][j] != sign && tab[i][j] != ' ') {
                    counter++;
                }
                if (counter == 2) {
                    for (int x = 0; x < 3; x++) {
                        if (tab[x][j] == ' ') {
                            a = Integer.toString(x);
                            b = Integer.toString(j);
                            ab = a + b;
                            break;
                        }
                    }
                }
            }
        }
        return ab;
    }

    /**
     * Method  check horizontal fields if oponent will win in next move (Player vs Computer - Medium)
     *
     * @param tab
     * @param sign
     * @return
     */
    public String horizontalCheck(char[][] tab, char sign) {
        int counter = 0;
        String a;
        String b;
        String ab = null;
        for (int i = 0; i < 3; i++) {
            counter = 0;
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] != sign && tab[i][j] != ' ') {
                    counter++;
                }
                if (counter == 2) {
                    for (int x = 0; x < 3; x++) {
                        if (tab[i][x] == ' ') {
                            a = Integer.toString(i);
                            b = Integer.toString(x);
                            ab = a + b;
                            break;
                        }
                    }
                }
            }
        }
        return ab;
    }

    /**
     * Method  check fields diagonally from left to right if oponent will win in next move (Player vs Computer - Medium)
     *
     * @param tab
     * @param sign
     * @return
     */
    public String crossCheckLeftToRight(char[][] tab, char sign) {
        int counter = 0;
        String a;
        String b;
        String ab = null;
        for (int i = 0; i < 3; i++) {
            if (tab[i][i] != sign && tab[i][i] != ' ') {
                counter++;
            }
        }
        if (counter == 2) {
            for (int x = 0; x < 3; x++) {
                if (tab[x][x] == ' ') {
                    a = Integer.toString(x);
                    b = Integer.toString(x);
                    ab = a + b;
                    break;
                }
            }
        }
        return ab;
    }

    /**
     * Method  check fields diagonally from right to left if oponent will win in next move (Player vs Computer - Medium)
     *
     * @param tab
     * @param sign
     * @return
     */
    public String crossCheckRightToLeft(char[][] tab, char sign) {
        int counter = 0;
        String a;
        String b;
        String ab = null;

        if (tab[0][2] != sign && tab[0][2] != ' ') {
            counter++;
        }
        if (tab[1][1] != sign && tab[1][1] != ' ') {
            counter++;
        }
        if (tab[2][0] != sign && tab[2][0] != ' ') {
            counter++;
        }
        if (counter == 2) {
            if (tab[0][2] == ' ') {
                ab = "02";
            } else if (tab[1][1] == ' ') {
                ab = "11";
            } else if (tab[2][0] == ' ') {
                ab = "20";
            }
        }
        return ab;
    }

    /**
     * Method looks empty fields on board (Player vs Computer - Medium)
     *
     * @param tab
     * @param sign
     * @return
     */
    public char[] checkEmptyFieldForComputerMedium(char[][] tab, char sign) {

        Move move = new Move();
        String coordinates;
        char[] coord = new char[2];

        coordinates = horizontalCheck(tab, sign);
        if (coordinates != null) {
            coord = coordinates.toCharArray();
        } else {
            coordinates = verticalCheck(tab, sign);
            if (coordinates != null) {
                coord = coordinates.toCharArray();
            } else {
                coordinates = crossCheckLeftToRight(tab, sign);
                if (coordinates != null) {
                    coord = coordinates.toCharArray();
                } else {
                    coordinates = crossCheckRightToLeft(tab, sign);
                    if (coordinates != null) {
                        coord = coordinates.toCharArray();
                    }
                }
            }
            if (coordinates == null) {
                List<String> coordinatesLSit = checkEmptyFieldForComputer(tab);
                coord = move.choseFieldForComputer(coordinatesLSit);
            }
        }
        return coord;
    }

    /**
     * Method looks empty fields on board (Player vs Computer - Hard)
     *
     * @param tab
     * @param sign
     * @return
     */
    public char[] checkEmptyFieldForComputerHard(char[][] tab, char sign) {

        String coordinates;
        char[] coord;

        if (sign == 'X') {
            sign = 'O';
        } else {
            sign = 'X';
        }

        coordinates = horizontalCheck(tab, sign);
        if (coordinates != null) {
            coord = coordinates.toCharArray();
        } else {
            coordinates = verticalCheck(tab, sign);
            if (coordinates != null) {
                coord = coordinates.toCharArray();
            } else {
                coordinates = crossCheckLeftToRight(tab, sign);
                if (coordinates != null) {
                    coord = coordinates.toCharArray();
                } else {
                    coordinates = crossCheckRightToLeft(tab, sign);
                    if (coordinates != null) {
                        coord = coordinates.toCharArray();
                    } else {
                        coordinates = "xy";
                        coord = coordinates.toCharArray();
                    }
                }
            }

        }
        return coord;
    }
}
