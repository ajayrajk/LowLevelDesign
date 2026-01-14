package org.java8;

import java.util.Optional;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        String input="ajay";
        Optional<Character> nonRepeated=input.chars()
                .mapToObj(c->(char)c)
                .filter(c->input.indexOf(c)==input.lastIndexOf(c))
                .findFirst();
        System.out.println(nonRepeated.orElse(' '));

    }
}
