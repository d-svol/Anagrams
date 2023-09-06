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
        StringBuilder stringBuilder = new StringBuilder(); //

        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (Character.isAlphabetic(ch)) {
                stringBuilder.append(ch);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!Character.isAlphabetic(ch)) {
                stringBuilder.insert(i, ch);
            }
        }
        return stringBuilder.toString();
    }
}
