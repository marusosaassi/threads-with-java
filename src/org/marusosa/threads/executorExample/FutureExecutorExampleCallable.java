package org.marusosa.threads.executorExample;

import java.util.concurrent.*;

public class FutureExecutorExampleCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();


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

        /*now future receives a String because it is what the
        * callable is returning */
        Future<String> result = executor.submit(task);
        executor.shutdown();

        System.out.println("Continuing with the execution of the method main 1");

        //System.out.println(result.isDone());

        while(!result.isDone()) {
            System.out.println("Executing task ...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        System.out.println("We obtain the result of the task " + result.get(5, TimeUnit.SECONDS));
        /* it is not always good to call the .get() because it blocks the
        * current thread, it stays on hold until the task is executed and
        * finalized and returns the value. In our case it is blocked for
        * three seconds until the task is completed.
        * When we click run, we can see that get() blocks de main
        * until the tasks is finished */

        /* We can put a parameter inside the get, for example we can say
        that the task should take 2 seconds, and if the task takes more
        than 2 seconds, we can throw a timeout exception
         */
        System.out.println("End of the task: " + result.isDone());
        //System.out.println(result.isDone());

        /* In conclusion, the only difference between Runnable and Callable
        * is that Callable returns a value. Both are tasks and both can
        * be executed or send to execution. Through Future we can
        * manage it, manipulate it, know if it is finished, iterate,
        * block the main thread, evoke the result, cancel the tasks, etc. */

    }
}
