package ru.artembulkhak.trainee.yandex.internship2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Yandex2 {
    private static int myBinarySearch(String[] a, String key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            int cmp;
            if (a[mid].length() < key.length()) {
                String midVal = a[mid];
                String newKey = key.substring(0, midVal.length());
                cmp = midVal.compareTo(newKey);
            } else {
                String midVal = a[mid].substring(0, key.length());
                cmp = midVal.compareTo(key);
            }

            if (cmp == 0 && mid == 0) {
                return mid;
            }

            if (cmp == 0 && a[mid - 1].startsWith(key))
                high = mid - 1;
            else if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);

        String[] dict = new String[n];
        int[] arrayQInt = new int[q];
        String[] arrayQStr = new String[q];

        for (int i = 0; i < n; i++) {
            dict[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < q; i++) {
            line = bufferedReader.readLine().split(" ");
            arrayQInt[i] = Integer.parseInt(line[0]);
            arrayQStr[i] = line[1];
        }

        bufferedReader.close();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int index = myBinarySearch(dict, arrayQStr[i]);
            if (index < 0) {
                stringBuilder.append(-1).append("\n");
                continue;
            }
            int newQ = 0;
            boolean flag = false;
            for (int j = index; j < dict.length; j++) {
                if (dict[j].startsWith(arrayQStr[i])) {
                    newQ++;
                    if (arrayQInt[i] == newQ) {
                        stringBuilder.append(++j).append("\n");
                        flag = true;
                        break;
                    }
                } else {
                    stringBuilder.append(-1).append("\n");
                    flag = true;
                    break;
                }
            }

            if (!flag)
                stringBuilder.append(-1).append("\n");
        }

        System.out.println(stringBuilder);
    }
}

//10 6
//aa
//aaa
//aab
//ab
//abc
//ac
//ba
//daa
//dab
//dadba
//1 aaaa
//1 aaa
//3 aaa
//2 ba
//1 ba
//3 dadbaa