package com.company.utils;

import com.company.gameElements.Menu;

/**
 * Created by Klakson on 2016-12-25.
 */
public class Sleeper {

    /**
     * Meethod slows a computer moves
     * @param time
     */
    public void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Critical error");
            Menu menu = new Menu();
            menu.mainMenu();
        }
    }
}
