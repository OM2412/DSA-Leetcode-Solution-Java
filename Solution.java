/**
 * =====================================================
 * LeetCode 2786 - Minimum Cost of Buying All Candies
 * =====================================================
 * 
 * Problem: A shop gives a free candy for every 2 candies bought.
 * The free candy must cost ≤ minimum of the 2 bought candies.
 * Find the minimum cost to buy all candies.
 * 
 * Strategy: Greedy + Sorting (Descending)
 * =====================================================
 */

/*
# INTUITION
To minimize the total cost, we want to maximize the value of the free candies. The key insight is that when we buy 2 candies and get 1 free, the free candy must cost ≤ the minimum of the 2 bought candies. By selecting the most expensive candies first and making the 3rd most expensive one free, we ensure this constraint is satisfied while saving the maximum amount.

# APPROACH
1. Sort in descending order - Put the most expensive candies first
2. Greedily pick groups of 3 - For each group: buy the 1st and 2nd most expensive, get the 3rd for free
3. Skip every 3rd candy - This is the free candy
4. Handle remaining candies - Any leftover candies (1 or 2) must be bought since there's no third candy to make free

Why this works: When we process candies from most to least expensive in groups of 3:
- The free candy (3rd in each group) is always ≤ both purchased candies ✅
- We maximize savings by freeing the most expensive candies possible ✅

# COMPLEXITY
- Time complexity: O(n log n) - Dominated by sorting the array
- Space complexity: O(1) - Only using a temporary variable for swapping (in-place reversal)

# EXAMPLE WALKTHROUGH
Input: [6,5,7,9,2,2]
After sort & reverse: [9,7,6,5,2,2]
Group 1 (i=0): Buy 9 + 7, Free 6 → Cost: 16
Group 2 (i=3): Buy 5 + 2, Free 2 → Cost: 7
Total: 23 ✅
*/

import java.util.Arrays;

public class Solution {
    public int minimumCost(int[] cost) {
        // Step 1: Sort in ascending order
        Arrays.sort(cost);
        
        // Step 2: Reverse to descending order
        for (int i = 0; i < cost.length / 2; i++) {
            int temp = cost[i];
            cost[i] = cost[cost.length - 1 - i];
            cost[cost.length - 1 - i] = temp;
        }
        
        // Step 3: Calculate total cost by skipping every 3rd candy (the free one)
        int totalCost = 0;
        for (int i = 0; i < cost.length; i += 3) {
            if (i < cost.length) totalCost += cost[i];           // Buy 1st
            if (i + 1 < cost.length) totalCost += cost[i + 1];   // Buy 2nd
            // Skip i + 2 (it's free!)
        }
        
        return totalCost;
    }
}
