package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jan on 5/25/16.
 */
public class MyThread extends Thread
{
    static AtomicInteger prior = new AtomicInteger(0);

    public MyThread()
    {
        if (prior.get() < 10) {
            setPriority(prior.incrementAndGet());
        }
        else {
            prior.set(1);
            setPriority(prior.get());
        }
    }

    public MyThread(Runnable target)
    {
        super(target);
        if (prior.get() <= 10) setPriority(prior.incrementAndGet());
        else {
            prior.set(1);
            setPriority(prior.get());
        }
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        if (prior.get() < 10) {
            if (prior.incrementAndGet() > getThreadGroup().getMaxPriority()) {
                setPriority(getThreadGroup().getMaxPriority());
            }
            else {
                setPriority(prior.get());
            }
        }
        else {
            prior.set(1);
            setPriority(prior.get());
        }
    }

    public MyThread(String name)
    {
        super(name);
        if (prior.get() <= 10) setPriority(prior.incrementAndGet());
        else {
            prior.set(1);
            setPriority(prior.get());
        }
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        if (prior.get() < 10) {
            if (prior.incrementAndGet() > getThreadGroup().getMaxPriority()) {
                setPriority(getThreadGroup().getMaxPriority());
            }
            else {
                setPriority(prior.get());
            }
        }
        else {
            prior.set(1);
            setPriority(prior.get());
        }
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        if (prior.get() <= 10) setPriority(prior.incrementAndGet());
        else {
            prior.set(1);
            setPriority(prior.get());
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        if (prior.get() < 10) {
            if (prior.incrementAndGet() > getThreadGroup().getMaxPriority()) {
                setPriority(getThreadGroup().getMaxPriority());
            }
            else {
                setPriority(prior.get());
            }
        }
        else {
            prior.set(1);
            setPriority(prior.get());
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        if (prior.get() < 10) {
            if (prior.incrementAndGet() > getThreadGroup().getMaxPriority()) {
                setPriority(getThreadGroup().getMaxPriority());
            }
            else {
                setPriority(prior.get());
            }
        }
        else {
            prior.set(1);
            setPriority(prior.get());
        }
    }
}
