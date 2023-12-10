package ru.artembulkhak.leetcode.TwoPointers;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String replacedStr = s.toLowerCase().replaceAll("[\\s|\\W|_]", "");
        int n = replacedStr.length();

        for (int i = 0; i < n/2; i++) {
            if (replacedStr.charAt(i) != replacedStr.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("ab_a"));
    }
}
