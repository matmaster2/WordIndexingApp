package com.wordindexing.app.obj;

import java.util.Set;
import java.util.TreeSet;

/**
 * The class stores data about the letters and words in which this letter appears.
 */
public class WordIndex {

    private char letter;

    private Set<String> words = new TreeSet<>();

    public WordIndex(char letter) {
        this.letter = letter;
    }

    public void addWordToList(String word) {
        words.add(word);
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(", ");
        }
        return letter + ": " + sb.toString().substring(0, sb.length() - 2);
    }
}
