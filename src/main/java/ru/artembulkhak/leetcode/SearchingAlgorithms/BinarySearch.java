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


    // Time: O(logn); Space: O(logn) because of Call Stack
    static int recursiveBinarySearch(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    static int search(int[] sortedArray, int target, int start, int end) {
        if (start <= end) {
            int middle = (end - start) / 2 + start;
            if (sortedArray[middle] == target) {
                return middle;
            } else if (sortedArray[middle] > target) {
                return search(sortedArray, target, start, middle - 1);
            } else {
                return search(sortedArray, target, middle + 1, end);
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        System.out.println(binarySearch(arr, 0));
    }
}
