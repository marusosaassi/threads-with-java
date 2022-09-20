package org.marusosa.threads.examples;

import org.marusosa.threads.examples.threads.NameThread;

public class ExtendThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new NameThread("Maru Sosa");
        thread.start(); //start internally evokes and calls run
        //Thread.sleep(100);
        //System.out.println(thread.getState()); //NEW because it is created but the thread is not executed

        Thread thread2 = new NameThread("Rafael");
        thread2.start();
        System.out.println(thread2.getState());
        //it is very fast but the two threads start at the same time and are
        // occurring in their own processor in a paralell way

        Thread thread3 = new NameThread("Jinni");
        thread3.start();

    }
}
