package ru.artembulkhak.leetcode.TwoPointers;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 */

public class ValidPalindrome2 {

    public boolean validPalindrome(String s, int first, int last) {
        while (first <= last) {
            if (s.charAt(first) != s.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }

        return true;
    }
    public boolean validPalindrome(String s) {
        int first = 0;
        int last = s.length() - 1;

        while (first <= last) {
            if (s.charAt(first) != s.charAt(last)) {
                return validPalindrome(s, first + 1, last) || validPalindrome(s, first, last - 1);
            }

            first++;
            last--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome2().validPalindrome("aba"));
    }
}
