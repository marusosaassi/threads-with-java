package org.marusosa.threads.examples.threads;

public class NameThread extends Thread {
    public NameThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("run method of the tread initialized" + getName());

        for(int i=0; i<10; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName());
        }

        System.out.println("thread ended");
    }
}
