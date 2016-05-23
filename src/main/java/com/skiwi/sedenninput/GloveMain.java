package com.skiwi.sedenninput;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Frank van Heeswijk
 */
public class GloveMain {
    private void init() throws FileNotFoundException, UnsupportedEncodingException {
        WordVectors wordVectors = WordVectorSerializer.loadTxtVectors(Paths.get("D:\\Downloads\\glove.6B\\glove.6B.300d.txt").toFile());

        //prints the 300 length vector associated with the word "cat"
        System.out.println(Arrays.toString(wordVectors.getWordVector("cat")));

        //prints the 10 closest words to "cat"
        System.out.println(wordVectors.wordsNearest("cat", 10));

        //prints the 10 closest words to "kitten" - "cat" + "dog"
        System.out.println(wordVectors.wordsNearest(Arrays.asList("kitten", "dog"), Arrays.asList("cat"), 10));

        //pritns the closest word to "berlin" - "germany" + "france"
        System.out.println(wordVectors.wordsNearest(Arrays.asList("berlin", "france"), Arrays.asList("germany"), 1));
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        new GloveMain().init();
    }
}
