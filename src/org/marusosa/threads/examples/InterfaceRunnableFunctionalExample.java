package org.marusosa.threads.examples;

import org.marusosa.threads.examples.runnable.TravelTask;

public class InterfaceRunnableFunctionalExample {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();
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
                System.out.println(main.getState());
            };

        Thread travel1 = new Thread(travel, "Japan");
        Thread travel2= new Thread(travel, "United Kingdom");
        Thread travel3 = new Thread(travel, "Chile");
        Thread travel4 = new Thread(travel, "Peru");

        travel1.start();
        travel2 .start();
        travel3.start();
        travel4.start();

        travel1.join(); //here I join the main thread with the 'travel1' thread
        travel2 .join();
        travel3.join();
        travel4.join();

        //in this way we expect every thread to end to continue the execution of the program

        // Thread.sleep(10000); //this thread.sleep here is a pause in the main, not in the threads
        // join, in the other way, waits for the other threads that are being executed into the main thread to end
        System.out.println("Keep executing the main method: " + main.getName());
        // so,  the treads execute while the main enters a pause method, at the end, when all
        // the threads end, the main continues its execution
    }
}
