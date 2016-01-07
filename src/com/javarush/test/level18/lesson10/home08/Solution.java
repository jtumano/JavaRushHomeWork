package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename;

        while (true)
        {
            filename = reader.readLine();
            if (filename.equals("exit")) break;
            else {
                new ReadThread(filename).start();
            }
        }



        reader.close();
    }

    public static class ReadThread extends Thread {
        String filename;
        InputStream inputStream;

        public ReadThread(String fileName) throws FileNotFoundException{
            //implement constructor body
            this.filename = fileName;
            inputStream = new FileInputStream(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run() {
            try
            {
                Map<Integer, Integer> map = new HashMap<>();
                int maxbytekey = 0;
                int maxbytevalue = 0;

                while (inputStream.available()>0)
                {
                    int data = inputStream.read();

                    if (map.containsKey(data))
                    {
                        int tmp = map.get(data);
                        map.put(data, ++tmp);
                    }
                    else
                    {
                        map.put(data, 1);
                    }
                }
                inputStream.close();

                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    if (pair.getValue() > maxbytevalue)
                    {
                        maxbytekey = pair.getKey();
                        maxbytevalue = pair.getValue();
                    }
                }

                resultMap.put(filename, maxbytekey);

                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    if (pair.getValue() == maxbytevalue)
                    {
                        if (pair.getKey() != maxbytekey)
                        {
                            resultMap.put(filename, maxbytekey);
                        }
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
