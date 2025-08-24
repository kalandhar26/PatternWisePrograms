package arrays;

/**
 * Problem:
 * ----------
 * You are given an array where each element represents the price of a stock on a given day.
 * You may complete as many transactions as you like (buy one and sell one share of the stock multiple times).
 * However, you cannot engage in multiple transactions at the same time (i.e., you must sell the stock before buying again).
 * <p>
 * Task:
 * Write a function to calculate the maximum profit you can achieve.
 * <p>
 * Example:
 * ---------
 * Input:  [3, 2, 6, 2, 15, 5, 0, 3]
 * Output: 25
 * <p>
 * Explanation:
 * - Buy at 2 and sell at 6 → Profit = 4
 * - Buy at 2 and sell at 15 → Profit = 13
 * - Buy at 0 and sell at 3 → Profit = 3
 * Total Profit = 4 + 13 + 3 = 20
 * <p>
 * Note: In this example, our code is taking every rising slope as a buy-sell pair,
 * effectively adding up all gains from consecutive increasing days.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        int array[] = {3, 2, 6, 2, 15, 5, 0, 3};

        System.out.println(getMaximumProfit(array));
        System.out.println(maxProfitTwoTransactions(array));

    }

    public static int getMaximumProfit(int[] array) {
        if (array.length <= 1)
            return 0;

        int currentProfit = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                currentProfit += array[i + 1] - array[i];
            }

        }
        return currentProfit;
    }

    /* find the maximum profit you can achieve with at most two transactions.
    You cannot hold more than one stock at a time, and the second transaction
    must start after the first one ends.
     */
    public static int maxProfitTwoTransactions(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int n = prices.length;
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        // Left pass: max profit from 0 to i
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        // Right pass: max profit from i to end
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        // Combine the two profits
        int maxTotalProfit = 0;
        for (int i = 0; i < n; i++) {
            maxTotalProfit = Math.max(maxTotalProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxTotalProfit;
    }


}
