package org.marusosa.threads.executorExample;

import java.util.concurrent.*;

public class FutureExecutorExampleCallable2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        //ExecutorService executor = Executors.newFixedThreadPool(3);
        //this way, all three tasks will be executed at the same time

        ExecutorService executor = Executors.newFixedThreadPool(2);
        // this way, 2 tasks will be executed at the same time and one will be
        // on hold.

        Callable<String> task = () -> {
            System.out.println("Start of the task...");
            try {
                System.out.println("Thread name: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // interrupt the execution of the current thread
                throw new RuntimeException(e);
            }
            System.out.println("Task has ended");
            return "Some important result of the task";
        };

        Callable<Integer> task2 = () -> {
            System.out.println("Beginning task 2");
            TimeUnit.SECONDS.sleep(3);
          return 10;
        };

        /*now future receives a String because it is what the
        * callable is returning */
        Future<String> result = executor.submit(task);
        Future<String> result2 = executor.submit(task);
        Future<Integer> result3 = executor.submit(task2);
        /* We send another 2 tasks to execution but will be on hold */

        executor.shutdown();

        System.out.println("Continuing with the execution of the method main 1");

        while(!(result.isDone() && result2.isDone() && result3.isDone())) {
            System.out.println(String.format(
                    "result1: %s - result2: %s - result3: %s",
                    result.isDone() ? "finished" : "in process",
                    result2.isDone() ? "finished" : "in process",
                    result3.isDone() ? "finished" : "in process"
            ));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        System.out.println("We obtain the result1 of the task " + result.get(5, TimeUnit.SECONDS));
        System.out.println("End of the task: " + result.isDone());

        System.out.println("We obtain the result2 of the task " + result2.get(5, TimeUnit.SECONDS));
        System.out.println("End of the task: " + result2.isDone());


        System.out.println("We obtain the result3 of the task " + result3.get(5, TimeUnit.SECONDS));
        System.out.println("End of the task: " + result3.isDone());


    }
}
