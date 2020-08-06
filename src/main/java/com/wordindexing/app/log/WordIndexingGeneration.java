package com.wordindexing.app.log;

import com.wordindexing.app.obj.WordIndex;

import java.util.*;

/**
 * The class is used to generate list of objects based on a sentence.
 * Each object in the list stores data on a unique letter and a list of words in which that letter is used.
 */
public class WordIndexingGeneration {

    private List<WordIndex> listOfWords = new ArrayList<>();

    /**
     * Method that used to indexes and displays a list containing the indexed word.
     *
     * @param sentence base on sentence the words will be indexed
     * @return list of WordIndex objects contains data about letters and words in which this letter appears.
     */
    public List<WordIndex> wordIndexing(String sentence) {
        Set<Character> letters = createLettersSet(sentence);
        for (char x : letters) {
            listOfWords.add(new WordIndex(x));
        }
        fillWordsArray(listOfWords, sentence);
        listOfWords.forEach(System.out::println);
        return listOfWords;
    }

    /**
     * @param sentence base on sentence the words will be indexed
     * @return letter-only set of unique characters
     */
    private Set<Character> createLettersSet(String sentence) {
        char[] letters = sentence.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
        SortedSet<Character> charSet = new TreeSet<>();
        for (char c : letters) {
            charSet.add(c);
        }
        return charSet;
    }

    /**
     * Method used to fill a word list based on the presence of a specific letter
     *
     * @param listOfWordIndexes list contains WordIndex objects with assign unique characters
     * @param sentence          base on sentence the words will be indexed
     */
    private void fillWordsArray(List<WordIndex> listOfWordIndexes, String sentence) {
        String formattedSentence = sentence.toLowerCase().replaceAll("[^a-z\\s]", "");
        ArrayList<String> words = new ArrayList<>(Arrays.asList(formattedSentence.split(" ")));

        for (WordIndex wordIndex : listOfWordIndexes) {
            char letter = wordIndex.getLetter();
            for (String word : words) {
                if (word.contains(Character.toString(letter))) {
                    wordIndex.addWordToList(word);
                }
            }
        }
    }
}
