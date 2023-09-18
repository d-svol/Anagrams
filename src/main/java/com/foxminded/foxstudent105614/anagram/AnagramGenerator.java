package com.foxminded.foxstudent105614.anagram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramGenerator {
	private final String text;

	public AnagramGenerator(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String createAnagram() {
		return splitWords(text)
			.stream()
			.map(this::reverseWordCharacters)
			.collect(Collectors.joining(" "));
	}

	private List<String> splitWords(String text) {
		return Arrays.asList(text.split(" "));
	}

	private String reverseWordCharacters(String word) {
		StringBuilder stringBuilder = new StringBuilder();

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