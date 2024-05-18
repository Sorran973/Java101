package ru.artembulkhak.trainee.yandex.internship2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Yandex {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        bufferedReader.close();

        int firstIndex = 0;
        int lastIndex = 0;
        List<String> arrayStr = new ArrayList<>();

        while (lastIndex != str.length()) {
            char ch = str.charAt(lastIndex);
            if (ch == ' ' && lastIndex != firstIndex) {
                arrayStr.add(str.substring(firstIndex, lastIndex));
                lastIndex++;
                firstIndex = lastIndex;
                continue;
            } else if (ch == ' ' && lastIndex == firstIndex) {
                lastIndex++;
                firstIndex = lastIndex;
                continue;
            } else if (ch == ',' && lastIndex != firstIndex) {
                arrayStr.add(str.substring(firstIndex, lastIndex));
                firstIndex = lastIndex;
                continue;
            } else if (ch == ',') {
                arrayStr.add(str.substring(firstIndex, ++lastIndex));
                firstIndex = lastIndex;
                continue;
            }

            lastIndex++;
        }
        if (firstIndex != lastIndex) {
            arrayStr.add(str.substring(firstIndex, lastIndex));
        }

        int maxLineLength = arrayStr.stream().max(Comparator.comparing(String::length)).get().length() * 3;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrayStr.get(0));
        int n = maxLineLength - arrayStr.get(0).length();


        for (int i = 1; i < arrayStr.size(); i++) {
            String s = arrayStr.get(i);

            if (s.equals(",")) {
                if (n - s.length() >= 0) {
                    stringBuilder.append(s);
                    n -= s.length();
                    continue;
                } else {
                    stringBuilder.replace(stringBuilder.length() - arrayStr.get(i - 1).length() - 1,
                            stringBuilder.length(), "");
                    stringBuilder.append('\n');
                    stringBuilder.append(arrayStr.get(i - 1)).append(s);
                    n = maxLineLength - (arrayStr.get(i - 1).length() + s.length());
                }
            } else {
                if (n - s.length() - 1 >= 0) {
                    stringBuilder.append(' ').append(s);
                    n -= (s.length() + 1);
                    continue;
                } else {
                    stringBuilder.append('\n');
                    stringBuilder.append(s);
                    n = maxLineLength - s.length();
                }
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
