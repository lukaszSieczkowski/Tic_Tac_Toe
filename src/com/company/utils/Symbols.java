package com.company.utils;

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
