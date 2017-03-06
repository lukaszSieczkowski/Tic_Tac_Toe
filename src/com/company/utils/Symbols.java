package com.company.utils;

/**
 * Created by Klakson on 2016-12-23.
 */
public enum Symbols {
     X ('X'),
     O ('O');

    char c;
    Symbols(char c) {
        this.c=c;
    }

    public char getChar(){
        return c;
    }

}
