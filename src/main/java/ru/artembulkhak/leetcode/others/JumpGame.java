package ru.artembulkhak.leetcode.others;

/**
 * https://leetcode.com/problems/jump-game/description/
 */

public class JumpGame {

//------------------------------------------------
//  Time: O(n); Space: O(n)
    static boolean canJumpDP(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        try {
            jumpDP(nums, 0, dp);
        } catch (RuntimeException e) {
            return true;
        }

        return false;
    }

    static void jumpDP(int[] nums, int i, boolean[] dp) {
        if (dp[i]) {
            return;
        }

        dp[i] = true;

        if (i + nums[i] >= nums.length - 1) {
            throw new RuntimeException("true");
        }
        for (int j = i + 1; j <= i + nums[i]; j++) {
            jumpDP(nums, j, dp);
        }

    }


//------------------------------------------------
//  Time Limit Exceeded because of Depth of Recursion Stack
    static boolean canJumpRecursion (int[] nums) {
        if (nums[0] == 0 && nums.length != 1) {
            return false;
        }

        if (0 == nums.length - 1) {
            return true;
        }

        for (int i = 1; i <= nums[0]; i++) {
            if (!jump(nums, i)) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    static boolean jump (int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }

        for (int j = 1; j <= nums[i]; j++) {
            if (!jump(nums, i + j)) {
                continue;
            } else {
                return true;
            }
        }

        return false;
    }

//------------------------------------------------
// Time: O(n^2)
    static boolean canJump (int[] nums) {
        if (nums[0] == 0 && nums.length != 1) {
            return false;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (i == nums.length - 1) {
                return true;
            }
            if (nums[i] == 0) {
                int jump = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > jump) {
                        break;
                    }
                    if (j == 0) {
                        return false;
                    }

                    jump++;
                }
            }
        }
        return true;
    }

//-----------------------------------------------------
//  The best solution
//  Time: O(n)
    static boolean canJumpBacktracking(int[] nums) {
        int target = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= target - i) {
                target = i;
            }
        }

        return target == 0;
    }



    public static void main(String[] args) {
//        System.out.println(canJumpRecursion(new int[]{1, 2, 3, 0, 4}));
        System.out.println(canJumpBacktracking(new int[]{0}));
//        System.out.println(canJumpBacktracking(new int[]{0, 0, 0, 1, 4}));
//        System.out.println(canJumpBacktracking(new int[]{2, 3, 1, 1, 4}));
    }
}
