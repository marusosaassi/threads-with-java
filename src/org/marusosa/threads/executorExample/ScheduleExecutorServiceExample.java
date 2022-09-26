package org.marusosa.threads.executorExample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Some task in main...");
        executor.schedule(() -> {
                    System.out.println("Hello world task");
                    try {
                        TimeUnit.MICROSECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                ,2000, TimeUnit.MICROSECONDS);

        System.out.println("Some other task in the main");
        executor.shutdown();
    }
}
