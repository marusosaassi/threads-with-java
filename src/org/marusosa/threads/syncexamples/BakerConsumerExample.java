package org.marusosa.threads.syncexamples;

import org.marusosa.threads.syncexamples.runnable.Baker;
import org.marusosa.threads.syncexamples.runnable.Consumer;

public class BakerConsumerExample {
    public static void main(String[] args) {
        Bakery b = new Bakery();
        new Thread(new Baker(b)).start();
        new Thread(new Consumer(b)).start();

    }
}
