package org.marusosa.threads.executorExample;

import org.marusosa.threads.syncexamples.Bakery;
import org.marusosa.threads.syncexamples.runnable.Baker;
import org.marusosa.threads.syncexamples.runnable.Consumer;

import java.util.concurrent.*;

public class ProducerConsumerExecutorExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Pool size: " + executor.getPoolSize());
        System.out.println("Quantity of tasks on hold/queue: " + executor.getQueue().size());

        Bakery bakery = new Bakery();
        Runnable producer = new Baker(bakery);
        Runnable consumer = new Consumer(bakery);

        Future<?> future1 = executor.submit(producer);
        Future<?> future2 = executor.submit(consumer);

        System.out.println("Pool size: " + executor.getPoolSize());
        System.out.println("Quantity of tasks on hold/queue: " + executor.getQueue().size());
        executor.shutdown();

        System.out.println("Continuing with the execution of the method main 1");
    }
}
