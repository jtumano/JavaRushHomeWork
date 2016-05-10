package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by jan on 5/9/16.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);

        try
        {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != operation.EXIT);
        }
        catch (InterruptOperationException e)
        {
            ConsoleHelper.writeMessage("Good bye!");
        }
    }
}
