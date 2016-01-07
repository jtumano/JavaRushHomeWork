package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException{
        reader = new BufferedReader(new FileReader(args[1]));
        writer = new BufferedWriter(new FileWriter(args[2]));

        if (args[0].equals("-e")) encrypt();
        else if (args[0].equals("-d")) decrypt();

        reader.close();
        writer.close();
    }

    private static void encrypt() throws IOException{
        while (reader.ready()) {
            String s = reader.readLine();
            char[] out = new char[s.length()];

            for (int i = 0; i < s.length(); i++)
            {
                out[i] = (char) (s.toCharArray()[i] + 2);
            }
            writer.write(String.valueOf(out));
            writer.newLine();
        }
        writer.flush();
    }

    private static void decrypt() throws IOException{
        while (reader.ready()) {
            String s = reader.readLine();
            char[] out = new char[s.length()];

            for (int i = 0; i < s.length(); i++)
            {
                out[i] = (char) (s.toCharArray()[i] - 2);
            }
            writer.write(String.valueOf(out));
            writer.newLine();
        }

        writer.flush();
    }
}
