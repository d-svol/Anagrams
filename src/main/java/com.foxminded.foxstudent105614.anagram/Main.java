package com.foxminded.foxstudent105614.anagram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String input = scanner.nextLine();

            Anagrams anagrams = new Anagrams(input);
            String anagram = anagrams.makeAnagram();

            System.out.println("Your anagram: " + anagram);
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}