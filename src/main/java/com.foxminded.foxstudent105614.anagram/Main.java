package com.foxminded.foxstudent105614.anagram;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            printAnagram(scanner);
        } catch (NoSuchElementException e) {
            System.err.println("Input not found. Please enter valid input.");
        }
    }

    private static void printAnagram(Scanner scanner) {
        System.out.print("Enter text to continue or 'ex' to exit: ");
        String userInput = scanner.nextLine().trim();

        while (!userInput.equals("ex")) {
            if (userInput.isEmpty()) {
                System.err.println("Input cannot be empty. Please, enter more than 1 characters.");
            }
            AnagramGenerator anagrams = new AnagramGenerator(userInput);
            System.out.println("Your anagram: " + anagrams.createAnagram());
            System.out.print("Enter text to continue or 'ex' to exit: ");
            userInput = scanner.nextLine().trim();
        }
    }
}