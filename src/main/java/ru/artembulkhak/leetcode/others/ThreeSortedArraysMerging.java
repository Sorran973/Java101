package ru.artembulkhak.leetcode.others;

import java.util.Arrays;

public class ThreeSortedArraysMerging {

    public long[] solution(long[] array) {
        // На вход дан массив чисел. Необходимо вернуть массив четных положительных чисел из входящего массива.
        return Arrays.stream(array).filter(x -> x > 0 && x % 2 == 0).toArray();
    }

    public int[] solution(int[] arrayOne, int[] arrayTwo, int[] arrayThree) {
        // На вход поданы три отсортированных по убыванию массиива. Необходимо вернуть один массив,
        // в котором числа из трех входных массивов отсортированы по возрастанию
        int l1 = arrayOne.length;
        int l2 = arrayTwo.length;
        int l3 = arrayThree.length;

        int[] result = new int[l1 + l2 + l3];

        int i = 0, j = 0, k = 0;
        int t = 0;
        while (i < l1 || j < l2 || k < l3) {
            int a = Integer.MIN_VALUE,
                    b = Integer.MIN_VALUE,
                    c = Integer.MIN_VALUE;

            if (i < l1) {
                a = arrayOne[i];
            }
            if (j < l2) {
                b = arrayTwo[j];
            }
            if (k < l3) {
                c = arrayThree[k];
            }

            if (a >= b && a >= c) {
                result[t] = a;
                i++;
            } else if (b >= a && b >= c) {
                result[t] = b;
                j++;
            } else {
                result[t] = c;
                k++;
            }
            t++;
        }

        return Arrays.stream(result).sorted().toArray();
    }

    public static void main(String[] args) {
        ThreeSortedArraysMerging threeSortedArraysMerging = new ThreeSortedArraysMerging();
        System.out.println(Arrays.toString(threeSortedArraysMerging.solution(new long[]{1, 2, -3, -4, 1, 4, 5})));
        System.out.println(Arrays.toString(threeSortedArraysMerging.solution(new int[]{3, 2, 1}, new int[]{9, 3, 1}, new int[]{6, 3, 2})));
    }
}
