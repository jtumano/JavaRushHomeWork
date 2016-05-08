package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        ArrayList<Integer> resa = new ArrayList<>();
        StringBuilder razrjady = new StringBuilder();

        for (int i = 1; i <= N; i++)
        {
            razrjady.delete(0, razrjady.length());
            razrjady.append(String.valueOf(i));

            int res = 0;

            int nn = i;
            while (nn > 0) {
                if (nn % 10 != 0) {

                    int ans = nn % 10;
                    for (int j = 0; j < razrjady.length()-1; j++)
                    {
                        ans *= nn % 10;
                    }
                    res += ans;
                }
                nn /= 10;
            }


            if (res == i) resa.add(res);
        }

        int[] result = new int[resa.size()];

        for (int a = 0; a < resa.size(); a++) {
            result[a] = resa.get(a);
        }

        return result;
    }

    public static void main(String[] args)
    {
        long memoryStart = Runtime.getRuntime().freeMemory();
        Long t0 = System.currentTimeMillis();
        int[] chisla = Solution.getNumbers(Integer.MAX_VALUE / 25);

        long memoryEnd = Runtime.getRuntime().freeMemory();

        for (int i: chisla) System.out.println(i);

        long memoTaken = (memoryStart - memoryEnd) / 1000000;
        Long t1 = System.currentTimeMillis();

        System.out.println();
        System.out.println(memoTaken);
        System.out.println("Time need to create the array = " + ((t1 - t0)));
    }
}
