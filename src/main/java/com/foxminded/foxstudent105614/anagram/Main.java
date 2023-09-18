package com.foxminded.foxstudent105614.anagram;

import org.apache.commons.lang3.StringUtils;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			printAnagram(scanner);
		} catch (NoSuchElementException e) {
			System.err.println(UserMessage.EMPTY_INPUT);
		}
	}

	private static void printAnagram(Scanner scanner) {
		System.out.print(UserMessage.CONTINUE_OR_EXIT);
		try {
			String userInput = scanner.nextLine().trim();
			while (!userInput.equals("ex")) {
				if (StringUtils.isEmpty(userInput)) {
					System.err.print(UserMessage.EMPTY_INPUT);
					System.out.println();
				} else {
					AnagramGenerator anagrams = new AnagramGenerator(userInput);
					System.out.println(UserMessage.ANAGRAM_PREFIX + anagrams.createAnagram());
				}
				System.out.print(UserMessage.CONTINUE_OR_EXIT);
				userInput = scanner.nextLine().trim();
			}
		} catch (NullPointerException e) {
			System.err.println(UserMessage.NULL_POINTER_EXCEPTION_PREFIX + e.getMessage());
		}
	}
}