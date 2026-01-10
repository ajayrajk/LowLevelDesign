package org.designpattern.structural.flyweight.withflyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private Map<String,
                Glyph> characters = new HashMap<>();

    public Glyph getCharacter(char symbol, String font, int size, String color) {
        String key = symbol + font + size + color;
        if (!characters.containsKey(key)) {
            characters.put(key, new CharacterGlyph(symbol, font, size, color));
        }
        return characters.get(key);
    }
}
