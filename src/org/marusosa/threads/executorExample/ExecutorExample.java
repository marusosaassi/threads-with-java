package org.marusosa.threads.executorExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        /* There are two main interfaces: Executor and ExecutorService
        * Executor only executes one task with the method "executor"
        * and we pass an implementation with Java8, lambda, or an
        * instance of a runnable (an implementation of the method run)
        * and it executes it.
        * ExecutorService also let us execute a task and make a following
        * of it. Instead of Runnable we can also use Callable, and it
        * returns the task that it is executing as an Object of future
        * type, and then we can know if it is in execution, if it is ended,
        * cancel it, control it, etc. */

        /* Executors lets us create instances with the 'new', the most popular one
        * is newSingleThreadExecutor to execute only one thread, it is a pool
        * of only one, it manages only one instance. This way we can execute
        * several tasks, one before the other, we have to finish one to execute
        * the other */

        Runnable task = () -> {
            System.out.println("Start of the task...");
            try {
                System.out.println("Thread name: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // interrupt the execution of the current thread
                throw new RuntimeException(e);
            }
            System.out.println("Task has ended");
        };
        executor.submit(task);
        executor.shutdown();
        /* executor.shutdownNow(); turns off the executor abroubtly and
        * interrupt all the tasks that are being executed, this could be
        * a problem because it can leave ambiguities the execution of this
        * processes.
        * shutdown is better because it shuts down
        * once the execution of all the processes and tasks end,
        * even the queued tasks */
        System.out.println("Continuing with the execution of the method main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS);
        /*it waits for all the tasks to end and then the executor to end
        to continue executing the main method */
        System.out.println("Continuing with the execution of the method main 2");
    }
}
