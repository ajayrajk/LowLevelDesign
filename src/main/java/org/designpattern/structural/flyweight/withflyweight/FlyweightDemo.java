package org.designpattern.structural.flyweight.withflyweight;

public class FlyweightDemo {

    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        Glyph a1 = factory.getCharacter('a', "Arial", 12, "Black");
        Glyph a2 = factory.getCharacter('a', "Arial", 12, "Black");
        Glyph b1 = factory.getCharacter('b', "Arial", 12, "Black");
        // Extrinsic state: position
        a1.display(0, 0);
        a2.display(1, 0);
        b1.display(2, 0);
        System.out.println("Are a1 and a2 the same object ? " + (a1 == a2));
    }
}
