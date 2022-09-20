package org.marusosa.threads.examples;

import org.marusosa.threads.examples.runnable.TravelTask;

public class InterfaceRunnableFunctionalExample {
    public static void main(String[] args) {

        Runnable travel = () ->
            {
                for(int i=0; i<10; i++){
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long)(Math.random() * 1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("I am traveling to " + Thread.currentThread().getName());
            };

        new Thread(travel, "Japan").start();
        new Thread(travel, "United Kingdom").start();
        new Thread(travel, "Chile").start();
        new Thread(travel, "Peru").start();

    }
}
