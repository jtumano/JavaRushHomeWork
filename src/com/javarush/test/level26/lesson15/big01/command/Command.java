package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by jan on 5/9/16.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}
