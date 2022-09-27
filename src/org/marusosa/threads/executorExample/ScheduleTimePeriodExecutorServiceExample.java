package org.marusosa.threads.executorExample;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleTimePeriodExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Some task in main...");
        //CountDownLatch lock = new CountDownLatch(5);
        AtomicInteger count = new AtomicInteger(5);
        Future<?> future = executor.scheduleAtFixedRate(() -> {
                    System.out.println("Hello world task");
                    try {
                        TimeUnit.MICROSECONDS.sleep(1000);
                        //lock.countDown();
                        count.getAndDecrement();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                ,1000, 2000, TimeUnit.MILLISECONDS);
        /*every task will be executed in this two seconds*/

        /* scheduleAtFixedRate and scheduleWithFixedDelay
        * sAFR= the time of the tasks is fixed, with
        * sWFD = there will always be a time between one task end and the other begins */

        //TimeUnit.SECONDS.sleep(10);
        //lock.await();
        //future.cancel(true);

        while(count.get() >= 0) {
            if(count.get() == 0){
                future.cancel(true);
                count.getAndDecrement();
            }
        }
        System.out.println("Some other task in the main");
        executor.shutdown();
    }
}
