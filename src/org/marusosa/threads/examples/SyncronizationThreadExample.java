package org.marusosa.threads.examples;

import org.marusosa.threads.examples.runnable.PrintSentences;

public class SyncronizationThreadExample {
    public static void main(String[] args) {
        new Thread(new PrintSentences("Hello ", "Goodbye")).start();
        new Thread(new PrintSentences(
                "My favorite programming language ", "is Java")).start();
        new Thread(new PrintSentences("Thank you ", "very much")).start();
    }

    public synchronized static void printSentences(String sentence1, String sentence2) {
        System.out.print(sentence1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sentence2);
        /*adding synchronized modifier: with this, every thread will enter
        this method and will use it in order, so when it is in use, the rest
        will be in blocked state, waiting for the thread to end, and,
        when that occurs leaves the synchronized state and enters another,
        in conclusion, prints the sentences in an orderly way*/
    }
}
