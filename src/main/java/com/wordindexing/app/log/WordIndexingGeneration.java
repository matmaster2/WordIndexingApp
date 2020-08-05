package com.wordindexing.app.log;

import com.wordindexing.app.obj.WordIndex;

import java.util.*;

/**
 * The class is used to generate list of index words in a sentence depending on the presence of the letter.
 */
public class WordIndexingGeneration {

    private List<WordIndex> listOfWords = new ArrayList<>();

    /**
     * Method that used to indexes and displays a list containing the indexed words
     */
    public void wordIndexing(String sentence) {
        List<Character> letters = createLettersList(sentence);
        for (char x : letters) {
            listOfWords.add(new WordIndex(x));
        }
        fillWordsArray(listOfWords, sentence);
        listOfWords.forEach(System.out::println);
    }

    /**
     * @return letter-only list of unique characters
     */
    private List<Character> createLettersList(String sentence) {
        char[] letters = sentence.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (char c : letters) {
            charSet.add(c);
        }
        return new ArrayList<>(charSet);
    }

    /**
     * Method used to fill a word list based on the presence of a specific letter
     *
     * @param listOfWordIndexes list contains WordIndex objects with assign unique characters
     * @param sentence          base on sentence the words will be indexed
     */
    private void fillWordsArray(List<WordIndex> listOfWordIndexes, String sentence) {
        String formattedSentence = sentence.toLowerCase().replaceAll("[^a-z\\s]", "");
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(formattedSentence.split(" ")));

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
