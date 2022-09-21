package org.marusosa.threads.syncexamples;

public class Bakery {
    private String bread;
    private boolean isAvailable;

    public synchronized void toBake(String mass) {
        while (isAvailable) {
            /*while puts the baker "on hold" when it is true to avoid
             baking in an uncontrolled way. While waits for the consumer
             to eat the bread and isAvailable is equal to false again
             to make more bread.
             If isAvailable=true, we enter wait mode: */
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.bread = mass;
        System.out.println("The baker is baking: " + this.bread);
        this.isAvailable = true;
        notify(); //we notify the client that the bread is ready for consumption
    }

    public synchronized String toConsume() {
        while(!isAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // while the condition is false we will be on hold, waiting,
        // until the other finalize their task
        System.out.println("The client eats the bread: " + this.bread);
        this.isAvailable = false;
        notify();
        return bread;
    }
}
