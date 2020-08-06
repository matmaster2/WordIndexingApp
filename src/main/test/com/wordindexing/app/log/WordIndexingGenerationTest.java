package com.wordindexing.app.log;

import com.wordindexing.app.obj.WordIndex;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WordIndexingGenerationTest {

    /**
     * Test checks if the correct number of characters and their alphabetical order are returned.
     */
    @Test
    public void isCorrectNumberAndOrderOfCharacters() {
        WordIndexingGeneration wordIndexingGeneration = new WordIndexingGeneration();
        String sentence = "abc aaa bbb dac";
        char[] correctCharArray = {'a', 'b', 'c', 'd'};
        List<WordIndex> listOfWords = wordIndexingGeneration.wordIndexing(sentence);
        Assert.assertEquals(correctCharArray.length, listOfWords.size());
        for (int i = 0; i < listOfWords.size(); i++) {
            Assert.assertEquals(correctCharArray[i], listOfWords.get(i).getLetter());
        }
    }
}