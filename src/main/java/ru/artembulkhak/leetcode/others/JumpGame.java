package ru.artembulkhak.leetcode.others;

/**
 * https://leetcode.com/problems/jump-game/description/
 */

public class JumpGame {

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



    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 2, 3, 0, 4}));
        System.out.println(canJump(new int[]{1, 0, 3, 0, 4}));
    }
}
