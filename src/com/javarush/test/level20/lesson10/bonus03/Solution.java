package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same", "rrp", "lmp", "pml", "mgl", "roo", "oor", "anm");
        for (Word word:list) {
            System.out.println(word.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        StringBuilder sb = new StringBuilder();
        List<Word> list = new ArrayList<>();


//        Find horizontals
        for (int i = 0; i < crossword.length; i++)
        {
            for (int j = 0; j < crossword[i].length; j++)
            {
                sb.append(Character.valueOf((char) crossword[i][j]));
                if (j == crossword[i].length-1) {
                    for (int k = 0; k < words.length; k++)
                    {
                        String reverse = sb.reverse().toString();
                        if (sb.toString().contains(words[k])) {
                            Word word = new Word(words[k]);
                            word.setStartPoint(sb.toString().indexOf(words[k]), i);
                            word.setEndPoint(sb.toString().lastIndexOf(words[k]), i);

                            list.add(word);
                        }
                        if (reverse.contains(words[k])) {
                            Word word = new Word(words[k]);
                            word.setStartPoint(sb.toString().indexOf(words[k]), i);
                            word.setEndPoint(sb.substring(sb.indexOf(words[k])).indexOf(words[k].charAt(words[k].length()-1))+1, i);

                            list.add(word);
                        }
                        sb.reverse();
                    }
                    sb.delete(0,sb.length());
                }
            }
        }

//        Find verticals
        for (int i = 0; i < crossword[0].length; i++)
        {
            for (int j = 0; j < crossword.length; j++)
            {
                sb.append(Character.valueOf((char) crossword[j][i]));
                if (i == crossword.length-1) {
                    for (int k = 0; k < words.length; k++)
                    {
                        if (sb.toString().contains(words[k])) {
                            Word word = new Word(words[k]);
                            word.setStartPoint(i, sb.toString().indexOf(words[k]));
                            word.setEndPoint(i, sb.toString().lastIndexOf(words[k]));

                            list.add(word);
                        }
                        if (sb.reverse().toString().contains(words[k])) {
                            Word word = new Word(words[k]);
                            word.setStartPoint(i, sb.toString().indexOf(words[k]));
                            word.setEndPoint(i, sb.toString().lastIndexOf(words[k]));

                            list.add(word);
                        }
                    }
                    sb.delete(0,sb.length());
                }
            }
        }

        sb.delete(0, sb.length());

//        Find diagonals - to be done

        for(int i=0; i<crossword.length; i++)
            for(int j=0; j<=i; j++) {
                sb.append(Character.valueOf((char) crossword[i-j][j]));
                if (j == i) {
                    for (int k = 0; k < words.length; k++)
                    {
                        if (sb.toString().contains(words[k])) {
                            System.out.println(words[k]);
                        }
                        if (sb.reverse().toString().contains(words[k])) {
                            System.out.println(words[k]);
                        }
                    }
                    sb.delete(0,sb.length());
                }
            }

        for(int i=1; i<crossword[0].length; i++)
            for(int j=i; j<crossword[0].length; j++) {
                sb.append(Character.valueOf((char) crossword[crossword.length-j+i-1][j]));
                if (j == i) {
                    for (int k = 0; k < words.length; k++)
                    {
                        if (sb.toString().contains(words[k])) {
                            System.out.println(words[k]);
                        }
                        if (sb.reverse().toString().contains(words[k])) {
                            System.out.println(words[k]);
                        }
                    }
                    sb.delete(0,sb.length());
                }
            }

//        Find diagonals to other side - to be done!!!

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
