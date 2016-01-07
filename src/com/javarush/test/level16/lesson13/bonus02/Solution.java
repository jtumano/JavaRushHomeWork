package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new nit1());
        threads.add(new nit2());
        threads.add(new nit3());
        threads.add(new nit4());
        threads.add(new nit5());
    }

    private static class nit1 extends Thread {
        @Override
        public void run()
        {
            while (true) {}
        }
    }

    private static class nit2 extends Thread {
        @Override
        public void run()
        {
            try
            {
                while (!isInterrupted()){}
                throw new InterruptedException();
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }

    private static class nit3 extends Thread {
        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    Thread.sleep(500);
                    System.out.println("Ура");
                }
            }
            catch (InterruptedException e)
            {

            }
        }
    }

    private static class nit4 extends Thread implements Message {
        @Override
        public void run()
        {
            while (!this.isInterrupted()) {}
        }

        @Override
        public void showWarning()
        {
            try
            {
                this.interrupt();
                this.join();
            }
            catch (InterruptedException e)
            {

            }
        }
    }

    private static class nit5 extends Thread {
        @Override
        public void run()
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String s = "";
            int ans = 0;

            while (!s.equals("N")) {
                try
                {
                    s = reader.readLine();
                    ans += Integer.parseInt(s);
                }
                catch (NumberFormatException e)
                {

                }
                catch (IOException e)
                {

                }
            }

            System.out.println(ans);
        }
    }

    public static void main(String[] args)
    {
        for (Thread thread:threads) {
            thread.start();
        }
    }
}
