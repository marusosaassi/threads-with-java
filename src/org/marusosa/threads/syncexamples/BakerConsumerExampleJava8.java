package org.marusosa.threads.syncexamples;

import org.marusosa.threads.syncexamples.runnable.Baker;
import org.marusosa.threads.syncexamples.runnable.Consumer;

import java.util.concurrent.ThreadLocalRandom;

public class BakerConsumerExampleJava8 {
    public static void main(String[] args) {
        Bakery b = new Bakery();

        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                b.toBake("Bread number: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                b.toConsume();
            }
        }).start();

        /*for (int i = 0; i < 10; i++) {
            bakery.toBake("Bread number: " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/
    }
}
