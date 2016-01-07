package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        if (params.isEmpty()) return sb;
        else {
            for (Map.Entry<String, String> pair:params.entrySet()) {
                if (pair.getValue()!=null) {
                    sb.append(pair.getKey() + " = " + "'" + pair.getValue() + "'" + " and ");
                }
            }

            sb.delete(sb.length()-5, sb.length());
        }

        return sb;
    }

    public static void main(String[] args)
    {
        Map<String, String> map = new LinkedHashMap<>();

        /*map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", "18");*/

        System.out.println(getCondition(map).toString());
    }
}
