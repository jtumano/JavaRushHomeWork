package com.javarush.test.level25.lesson05.home01;

/**
 * Created by jan on 03.01.16.
 */
public class LoggingStateThread extends Thread
{
    Thread target;
    State state;

    public LoggingStateThread(Thread target1)
    {
        target = target1;
        setDaemon(true);
        state = target.getState();
        System.out.println(state);
    }

    @Override
    public void run()
    {
        while (state != State.TERMINATED)
        {
            if (state != target.getState())
            {
                state = target.getState();
                System.out.println(target.getState());
            }
        }
    }
}
