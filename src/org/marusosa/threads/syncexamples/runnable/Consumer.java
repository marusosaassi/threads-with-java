package org.marusosa.threads.syncexamples.runnable;

import org.marusosa.threads.syncexamples.Bakery;

public class Consumer implements Runnable{

    private Bakery bakery;

    public Consumer(Bakery bakery) {
        this.bakery = bakery;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            bakery.toConsume();
        }
    }
}
