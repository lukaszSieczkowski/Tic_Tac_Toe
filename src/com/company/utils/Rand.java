package com.company.utils;

import com.company.gameElements.Player;

import java.util.Random;

/**
 * Created by Klakson on 2016-12-23.
 */
public class Rand {

    /**
     * Method drafts who will start a game
     *
     * @param player1
     * @param player2
     * @return
     */

    public boolean whoStarts(Player player1, Player player2) {
        Sleeper sleeper = new Sleeper();
        int player1Number;
        int player2Number;
        boolean player1Start = true;

        System.out.println("I am picking who will start first, " + player1.getPlayerName() + " or " + player2.getPlayerName());

        player1Number = createRandomNumber();
        player2Number = createRandomNumber();
        for (int i = 3; i > 0; i--) {
            System.out.println(i + ".....");
            sleeper.wait(1000);
        }
        do {
            if (player1Number > player2Number) {
                System.out.println("Player no.1 " + player1.getPlayerName() + " will start:");
                player1Start = true;
            } else {
                System.out.println("Player no.2 " + player2.getPlayerName() + " will start:");
                player1Start = false;
            }
        } while (player1Number == player2Number);

        return player1Start;
    }

    /**
     * Method drafts a random number
     *
     * @return
     */

    public int createRandomNumber() {
        Random rand = new Random();
        int number = rand.nextInt(1000);
        return number;
    }
}
