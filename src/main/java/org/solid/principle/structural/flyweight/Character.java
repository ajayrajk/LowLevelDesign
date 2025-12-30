package org.solid.principle.structural.flyweight;

public class Character {
    /*
    * Naively, you might store a separate object for every single character:
    * */
    char symbol;
    String font;
    int size;
    String color;
    int x;
    int y;

    Character(char symbol, String font, int size, String color, int x, int y) {
        this.symbol = symbol;
        this.font = font;
        this.size = size;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    /*
    * Problem
    If the document has millions of characters, storing full info for each character
    wastes memory.
    Most characters share font, size, and color. Only symbol and position vary.
     Memory usage grows linearly with the number of characters.

    * */
}
