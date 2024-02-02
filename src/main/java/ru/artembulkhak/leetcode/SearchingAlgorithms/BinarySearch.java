package ru.artembulkhak.leetcode.SearchingAlgorithms;

/**
 * https://leetcode.com/problems/binary-search/description/
 */

public class BinarySearch {

    // Time: O(logn); Space: O(1)
    static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                result = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        System.out.println(binarySearch(arr, 0));
    }
}
