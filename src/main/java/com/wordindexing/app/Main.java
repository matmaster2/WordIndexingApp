package com.wordindexing.app;

import com.wordindexing.app.log.WordIndexingGeneration;

import java.util.Scanner;

/**
 * The class is used to run the program with its own entered sentence from console.
 */
public class Main {

    public static void main(String[] args) {
        String sentence;
        WordIndexingGeneration wordIndexingGeneration = new WordIndexingGeneration();
        System.out.println("Write your sentence:");
        try (Scanner sc = new Scanner(System.in)) {
            sentence = sc.nextLine();
            wordIndexingGeneration.wordIndexing(sentence);
        }
    }
}
