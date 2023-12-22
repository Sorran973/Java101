package ru.artembulkhak.leetcode.DP;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */

public class BestTimeToBuyAndSellStock {

    public int maxProfitTwoPointers(int[] prices) {
        int profit = 0;

        for (int left = 0, right = 1; right < prices.length; right++) {
            if (prices[left] > prices[right]) {
                left = right;
            } else {
                if (prices[right] - prices[left] > profit) {
                    profit = prices[right] - prices[left];
                }
            }
        }

        return profit;
    }

    public int maxProfitDP(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Integer.min(dp[i - 1][0], prices[i]);
            dp[i][1] = Integer.max(dp[i - 1][1], prices[i] - dp[i - 1][0]);
        }

        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfitTwoPointers(new int[]{2,4,1}));
    }
}
