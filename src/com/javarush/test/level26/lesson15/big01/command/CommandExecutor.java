package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jan on 5/9/16.
 */
public class CommandExecutor
{
    private static Map<Operation, Command> map;

    static {
        map = new HashMap<>();
        map.put(Operation.LOGIN, new LoginCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        map.get(operation).execute();
    }

    private CommandExecutor()
    {
    }
}
