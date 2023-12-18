package ru.artembulkhak.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-the-difference/description/
 */

public class FindTheDifference {

    public char findTheDifferenceSorting(String s, String t) {
        char[] firstArray = s.toCharArray();
        char[] secondArray = t.toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                return secondArray[i];
            }
        }

        return secondArray[secondArray.length - 1];
    }

    public char findTheDifferenceHashMap(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Map.Entry entry: map2.entrySet()) {
            if (!entry.getValue().equals(map1.get(entry.getKey()))) {
                return (char) entry.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifferenceSorting("abcd", "abcde"));
    }
}
