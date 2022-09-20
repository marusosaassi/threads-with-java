package org.marusosa.threads.examples;

import org.marusosa.threads.examples.runnable.TravelTask;

public class InterfaceRunnableExample {
    public static void main(String[] args) {
        new Thread(new TravelTask("Japan")).start();
        new Thread(new TravelTask("United Kingdom")).start();
        new Thread(new TravelTask("Chile")).start();
        new Thread(new TravelTask("Peru")).start();

    }
}
