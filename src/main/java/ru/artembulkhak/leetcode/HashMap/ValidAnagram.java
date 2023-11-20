package ru.artembulkhak.leetcode.HashMap;

import java.util.*;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */

public class ValidAnagram {

    public boolean isAnagramSort(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        String first = Arrays.toString(sArr);
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);
        String second = Arrays.toString(sArr);

        return first.equals(second);

//        for (int i = 0; i < sArr.length; i++) {
//            if (sArr[i] != tArr[i]) {
//                return false;
//            }
//            continue;
//        }
//
//        return true;
    }

    public boolean isAnagramHashMap(String s, String t) {

        int n = s.length();
        int m = t.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int g = 1;

            if (map.containsKey(c)) {
                g = map.get(c) + 1;
            }

            map.put(c, g);
        }

        for (int i = 0; i < m; i++) {
            char c = t.charAt(i);

            if (map.containsKey(c)) {
                if (map.get(c) - 1 == 0) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }


    public static void main(String[] args) {
//        System.out.println(new ValidAnagram().isAnagramHashMap("rat", "car"));
        System.out.println(new ValidAnagram().isAnagramSort("anagram", "nagaram"));

    }
}
