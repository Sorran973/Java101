package ru.artembulkhak.leetcode.TwoPointers;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */

public class IndexOfTheFirstOccurrenceInString {

    public int strStrTwoPoints(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        for (int i = 0, j = 0; i < haystackLen; i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needleLen) {
                    return i - j + 1;
                }
            } else {
                i = i - j;
                j = 0;
            }
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
//        System.out.println(strStr("mississippi", "issip"));
//        System.out.println(strStr("leetettetcde", "etc"));
//        System.out.println(strStr("n", "n"));
        System.out.println(new IndexOfTheFirstOccurrenceInString().strStrTwoPoints("mississippi", "issip"));

    }
}
