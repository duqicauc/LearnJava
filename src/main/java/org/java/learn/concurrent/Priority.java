package org.java.learn.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 作用:
 * User: duqi
 * Date: 2018/2/3
 * Time: 15:34
 */
public class Priority {

    private static volatile boolean noStart = true;
    private static volatile boolean noEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }

        noStart = false;
        TimeUnit.SECONDS.sleep(10);
        noEnd = false;
        for (Job job: jobs) {
            System.out.println("Job Priority:" + job.priority + ", Count:" + job.jobCount);
        }
    }

    static class Job implements Runnable {

        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while(noStart) {
                Thread.yield();
            }

            while (noEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}
