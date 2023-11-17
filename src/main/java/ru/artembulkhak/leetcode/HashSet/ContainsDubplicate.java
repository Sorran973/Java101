package ru.artembulkhak.leetcode.HashSet;

import java.util.*;

/**
 * https://leetcode.com/problems/contains-duplicate/submissions/1069141542/
 */

public class ContainsDubplicate {

    public boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int first = 0;
        int second = 1;

        while (first < n - 1) {
            if (nums[first] == nums[second]) {
                return true;
            } else {
                first++;
                second++;
            }
        }

        return false;
    }


    public boolean containsDuplicateHashSet(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int item: nums) {
            if (!hashSet.add(item)) {
                return true;
            }
        }

        return false;
    }


    public boolean containsDuplicateHashMap(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int item: nums) {
            if (!hashMap.containsKey(item)) {
                hashMap.put(item, 0);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDubplicate().containsDuplicateHashMap(new int[]{1,2,3,}));
        System.out.println(new ContainsDubplicate().containsDuplicateHashSet(new int[]{1,2,3,1}));
        System.out.println(new ContainsDubplicate().containsDuplicateSort(new int[]{1,2,3}));
    }
}
