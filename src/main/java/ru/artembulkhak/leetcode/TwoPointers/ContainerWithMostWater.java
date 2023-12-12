package ru.artembulkhak.leetcode.TwoPointers;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 */

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int firstPointer = 0;
        int secondPointer = height.length - 1;

        int maxArea = (secondPointer - firstPointer) * Math.min(height[firstPointer], height[secondPointer]);

        while (firstPointer != secondPointer) {
            if (height[firstPointer] > height[secondPointer]) {
                secondPointer--;
            } else {
                firstPointer++;
            }

            int newArea = (secondPointer - firstPointer) * Math.min(height[firstPointer], height[secondPointer]);
            if (maxArea < newArea) {
                maxArea = newArea;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{2,3,4,5,18,17,6}));
    }
}
