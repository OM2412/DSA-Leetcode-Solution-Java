// LC #121 - Best Time to Buy and Sell Stock
// Date: June 1, 2026
// Approach: Track minimum price and maximum profit in one pass
// Time Complexity: O(n) — single loop
// Space Complexity: O(1) — only variables, no extra array

class Solution {
    public int maxProfit(int[] prices) {

        // Step 1 — Start with 0 profit (worst case = no transaction)
        int max = 0;

        // Step 2 — Set minimum to largest possible int
        // so that first price always becomes the new minimum
        int min = Integer.MAX_VALUE;

        // Step 3 — Loop through every price one by one
        for(int i = 0; i < prices.length; i++) {

            // Step 4 — Check if today's price is lower than
            // the lowest price seen so far
            // If yes → update minimum (best day to buy)
            if(prices[i] < min) {
                min = prices[i];
            }

            // Step 5 — Calculate profit if we sold today
            // profit = today's price - minimum buy price so far
            int profit = prices[i] - min;

            // Step 6 — If this profit is better than
            // our best profit so far → update max
            if(profit > max) {
                max = profit;
            }
        }

        // Step 7 — Return the maximum profit found
        // Returns 0 if no profit possible (prices only decrease)
        return max;
    }
}