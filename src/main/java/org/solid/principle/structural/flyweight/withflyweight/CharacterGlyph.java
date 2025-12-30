package org.solid.principle.structural.flyweight.withflyweight;

public class CharacterGlyph implements Glyph {
    private
    char symbol; // intrinsic//
     private String font; // intrinsic
     private int size; // intrinsic
    private String color; // intrinsic

    CharacterGlyph(char symbol, String font, int size, String color) {
        this.symbol
                = symbol;
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public void display(int x, int y) {
        System.out.println("Displaying '" + symbol
                + "' at (" + x + "," + y + ") with font " + font + ", size " + size + ", color "
                + color);
    }
}
