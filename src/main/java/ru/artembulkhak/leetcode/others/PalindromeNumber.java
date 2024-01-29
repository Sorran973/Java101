package ru.artembulkhak.leetcode.others;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 */

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int testX = x;
        int newX = 0;

        while (testX / 10 != 0) {
            newX += testX % 10;
            newX *= 10;
            testX /= 10;
        }
        newX += testX % 10;

        return x == newX;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(10));
    }
}
