package com.foxminded.foxstudent105614.anagram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrams {
    public String text;

    public Anagrams(String text) {
        this.text = text;
    }

    public String makeAnagram() {
        return splitWords(text)
                .stream()
                .map(Anagrams::reverseWord)
                .collect(Collectors.joining(" "));
    }

    private List<String> splitWords(String text) {
        return Arrays.asList(text.split(" "));
    }

    private static String reverseWord(String word) {
        StringBuilder reversWord = new StringBuilder();
        char[] arrayChar = word.toCharArray();
        char[] reverseChar = new StringBuffer(word).reverse().toString().toCharArray();

        for (int i = 0; i < arrayChar.length; i++) {
            char is_alphabetic_symbol = reverseChar[i];
            if (Character.isAlphabetic(is_alphabetic_symbol)) {
                reversWord.append(is_alphabetic_symbol);
            }
        }
        for (int i = 0; i < arrayChar.length; i++) {
            char is_special_symbol = arrayChar[i];
            if (!Character.isAlphabetic(is_special_symbol)) {
                reversWord.insert(i, is_special_symbol);
            }
        }
        return reversWord.toString();
    }
}
