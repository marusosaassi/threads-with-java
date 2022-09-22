package org.marusosa.threads.TimerExample;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleTaskTimerExample {
    public static void main(String[] args) {
        Timer timer = new Timer();
        /* the Timer class in Java (java.util) lets us add
        tasks and program them */

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task accomplished in "
                        + new Date().toString()
                        + " Thread name: "
                        + Thread.currentThread().getName());

                System.out.println("Time is over");

                timer.cancel();
            }
        }, 5000);

        System.out.println("Schedule a tasks for 5 seconds more ...");

    }
}
