package org.marusosa.threads.examples.runnable;

import static  org.marusosa.threads.examples.SyncronizationThreadExample.printSentences;

import static org.marusosa.threads.examples.SyncronizationThreadExample.printSentences;

public class PrintSentences implements Runnable{
    private String sentence1, sentence2;

    public PrintSentences(String sentence1, String sentence2) {
        this.sentence1 = sentence1;
        this.sentence2 = sentence2;
    }

    @Override
    public void run() {
        printSentences(this.sentence1, this.sentence2);
    }
}
