package org.marusosa.threads.timerExample;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleTaskTimerIntervalExample {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger atomicCounter = new AtomicInteger(3);

        Timer timer = new Timer();
        /* the Timer class in Java (java.util) lets us add
        tasks and program them */

        timer.schedule(new TimerTask() {
            //private int counter = 3;
            @Override
            public void run() {
                int i = atomicCounter.getAndDecrement();
                if(i > 0) {
                    toolkit.beep();
                    System.out.println("Periodic task " + i +" in "
                            + new Date().toString()
                            + " Thread name: "
                            + Thread.currentThread().getName());
                    //counter--;
                } else {
                    System.out.println("Time is over");
                    timer.cancel(); //comment this to avoid canceling
                }
            }
        }, 0, 10000);

        System.out.println("Schedule a immediate task that repeats itself every 10 seconds ...");

    }
}
