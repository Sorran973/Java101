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

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfitTwoPointers(new int[]{2,4,1}));
    }
}
