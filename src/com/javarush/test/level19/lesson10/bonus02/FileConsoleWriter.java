package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.FileWriter;
import java.io.IOException;
public class FileConsoleWriter extends FileWriter
{
    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    @Override
    public void write(int c) throws IOException
    {
        char[] var2 = new char[]{(char)c};
        write((char[])var2, 0, 1);
    }

    @Override
    public void write(char[] cbuf) throws IOException
    {
        write(cbuf, 0,cbuf.length);
    }

    @Override
    public void write(String str) throws IOException
    {
        write(str.toCharArray(),0,str.length());
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        String s = String.valueOf(cbuf);
        System.out.println(s.substring(off,len+off));
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        write(str.toCharArray(),off,len);
        super.write(str,off,len);
    }



    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("jan");
        fileConsoleWriter.write("Проверка String:");
        fileConsoleWriter.write(1234);
        char[] buff = "Проверка char buff:".toCharArray();
        fileConsoleWriter.write(buff);
        fileConsoleWriter.write(buff, 3, 5);
        fileConsoleWriter.write("Проверка String обрезка:", 0, 2);
        fileConsoleWriter.flush();
        fileConsoleWriter.close();

    }
}
