package ru.artembulkhak.leetcode.TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/description/
 */

public class HappyNumber {
    public boolean isHappyTwoPointers(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = square(slow);
            fast = square(square(fast));
            if (slow == 1 || fast == 1) {
                return true;
            }

        } while (slow != fast);

        return false;
    }

    public int square(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            int partOfSum = digit * digit;
            sum += partOfSum;
            n /= 10;
        }

        return sum;
    }


    public boolean isHappyHashSet(int n){
        Set<Integer> hashSet = new HashSet<>();

        while (hashSet.add(n)) {
            n = square(n);

            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappyTwoPointers(10));
        System.out.println(new HappyNumber().isHappyHashSet(10));
    }
}
