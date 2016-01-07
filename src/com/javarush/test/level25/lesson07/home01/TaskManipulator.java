package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private String threadName;
    Thread current;

    @Override
    public void run() {
        try
        {
            while (!current.isInterrupted()) {
                Thread.sleep(0);
                System.out.println(threadName);
                Thread.sleep(90);
            }
        }
        catch (InterruptedException e) {}
    }

    @Override
    public void start(String threadName)
    {
        this.threadName = threadName;
        current = new Thread(this);
        current.start();
    }

    @Override
    public void stop()
    {
        current.interrupt();
    }
}
