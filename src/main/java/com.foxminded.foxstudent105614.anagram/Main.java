package com.foxminded.foxstudent105614.anagram;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            printAnagram(new Scanner(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printAnagram(Scanner scanner) {
        try {
            System.out.print("Enter text: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                throw new EmptyTextException("Text cannot be empty. Please enter valid input.");
            }

            AnagramGenerator anagrams = new AnagramGenerator(input);
            String anagram = anagrams.createAnagram();

            System.out.println("Your anagram: " + anagram);

        } catch (InputMismatchException e) {
            System.err.println("Input mismatch. Please enter valid input.");
        } catch (NoSuchElementException e) {
            System.err.println("Input not found. Please enter valid input.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}