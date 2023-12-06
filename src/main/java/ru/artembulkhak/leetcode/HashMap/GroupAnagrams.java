package ru.artembulkhak.leetcode.HashMap;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 */

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public int[] fillASCIIArray(String str) {
        int[] arr = new int[26];
        for (char c: str.toCharArray()) {
            arr[(int)c - (int)'a'] += 1;
        }

        return arr;
    }

    public List<List<String>> groupAnagramsASCII(String[] strs) {
        List<int[]> arrayList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        int[] baseArr = fillASCIIArray(strs[0]);
        arrayList.add(baseArr);
        result.add(new ArrayList<>());
        result.get(0).add(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            boolean flag = true;
            int[] arr = fillASCIIArray(strs[i]);
            for (int j = 0; j < arrayList.size(); j++) {
                if (Arrays.equals(arr, arrayList.get(j))) {
                    result.get(j).add(strs[i]);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                arrayList.add(arr);
                result.add(new ArrayList<>());
                result.get(result.size()-1).add(strs[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"}));
    }
}
