package ru.artembulkhak.leetcode.others;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);
        int count = 0;
        int countMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                continue;
            }
            if (nums[i + 1] - nums[i] == 1) {
                count++;
            } else {
                Math.max(countMax, count);
                count = 0;
            }

        }

        Math.max(countMax, count);

        return ++countMax;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }
}
