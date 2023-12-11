package ru.artembulkhak.leetcode.TwoPointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */

public class TwoSum2InputArrayIsSorted {

//    Time complexity = O(n)
    public int[] twoSumTwoPointers(int[] numbers, int target) {
        int fiestPointer = 0;
        int secondPointer = numbers.length - 1;

        while (numbers[fiestPointer] + numbers[secondPointer] != target) {
            if (numbers[fiestPointer] + numbers[secondPointer] > target) {
                secondPointer--;
            } else {
                fiestPointer++;
            }
        }

        return new int[]{fiestPointer + 1, secondPointer + 1};
    }

//    Time complexity = O(n^2)
    public int[] twoSumBinarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = Arrays.binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j > 0) {
                return new int[]{i+1, j+1};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
//        System.out.println(new TwoSum2InputArrayIsSorted().twoSumTwoPointers(new int[]{2,7,11,15}, 9));
//        System.out.println(new TwoSum2InputArrayIsSorted().twoSumTwoPointers(new int[]{-1,0}, -1));
        System.out.println(new TwoSum2InputArrayIsSorted().twoSumTwoPointers(new int[]{2,3,4}, 6));
    }
}
