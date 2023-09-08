package com.foxminded.foxstudent105614.anagram;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            printAnagram(scanner);
        } catch (NoSuchElementException e) {
            System.err.println("Input not found. Please enter valid input.");
        } catch (EmptyInputException e) {
            System.err.println("Input cannot be empty. Please enter valid input.");
        }
    }

    private static void printAnagram(Scanner scanner) throws EmptyInputException {
        System.out.print("Enter text: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            throw new EmptyInputException();
        }

        AnagramGenerator anagrams = new AnagramGenerator(input);
        String anagram = anagrams.createAnagram();

        System.out.println("Your anagram: " + anagram);
    }
}