package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            Person person = null;
            String personString = scanner.nextLine();

            int i = 0;

            String firstName = "";
            String middleName = "";
            String lastName = "";
            String birthDate = "";

            SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");

            for (; i < personString.toCharArray().length; i++) {
                if (personString.toCharArray()[i] == 32) {
                    lastName = personString.substring(0, i);
                    i++;
                    break;
                }
            }
            int i2 = i++;
            for (; i < personString.toCharArray().length; i++) {
                if (personString.toCharArray()[i] == 32) {
                    firstName = personString.substring(i2, i);
                    i++;
                    break;
                }
            }
            int i3 = i++;
            for (; i < personString.toCharArray().length; i++) {
                if (personString.toCharArray()[i] == 32) {
                    middleName = personString.substring(i3, i);
                    i++;
                    break;
                }
            }
            birthDate = personString.substring(i);

            try
            {
                return new Person(firstName, middleName, lastName, df.parse(birthDate));
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
