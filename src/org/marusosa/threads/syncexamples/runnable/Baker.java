package org.marusosa.threads.syncexamples.runnable;

import org.marusosa.threads.syncexamples.Bakery;

import java.util.concurrent.ThreadLocalRandom;

public class Baker implements Runnable {

    /* Both baker and consumer have the bakery attribute in common, the
     monitor object with the synchronized methods */

    private Bakery bakery;

    public Baker(Bakery bakery) {
        this.bakery = bakery;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bakery.toBake("Bread number: " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
