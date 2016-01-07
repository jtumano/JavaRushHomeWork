package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));

        List<String> text = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        String arg = args[0];
        String str = "";

        while (file.ready()) {
            str += file.readLine();
        }

        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            String stroka = matcher.group();
            if (stroka.contains("</" + arg)) {
                text.add(stroka);
                pos.add(matcher.end());
            }
            else if (stroka.contains("<" + arg)) {
                text.add(stroka);
                pos.add(matcher.start());
            }
        }

        int start = 0;
        int end = 0;

        String[] stroki = new String[text.size()*2];

        int count = 0;
        for (int i = 0; i < text.size(); i++)
        {
            if (text.get(i).contains("</" + arg)) {
                start = pos.get(i-1);
                end = pos.get(i);
                count++;
                if (stroki[i+count]==null) {
                    stroki[i+count] = str.substring(start, end);
                }
                else stroki[i+count-1] = str.substring(start, end);

                text.remove(i);
                text.remove(i-1);
                pos.remove(i);
                pos.remove(i-1);
                i=0;
            }
        }

        for (int i = 0; i < stroki.length; i++)
        {
            if (stroki[i]!=null) System.out.println(stroki[i]);
        }

        reader.close();
        file.close();
    }
}
