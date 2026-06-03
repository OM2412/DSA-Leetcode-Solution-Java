// ============================================
// LC #53 - Maximum Subarray
// Date: June 1, 2026
// Difficulty: Medium
// Topic: Arrays
// ============================================
// PROBLEM:
// Find the subarray with the largest sum.
// Return its sum.
//
// APPROACH: Kadane's Algorithm
// → Keep running sum of current subarray
// → If running sum goes negative → reset to 0
//   (negative sum only hurts future subarrays)
// → Track maximum sum seen at any point
//
// Time Complexity : O(n) — single loop
// Space Complexity: O(1) — only 2 variables
//
// DRY RUN:
// nums = [-2,1,-3,4,-1,2,1,-5,4]
// i=0 → cur=-2, max=-2
// i=1 → cur=1,  max=1   (reset because -2<0)
// i=2 → cur=-2, max=1   (reset)
// i=3 → cur=4,  max=4
// i=4 → cur=3,  max=4
// i=5 → cur=5,  max=5
// i=6 → cur=6,  max=6 ✅
// Answer: 6 → subarray [4,-1,2,1]
// ============================================

class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        // Step 1 — Initialize currentSum as 0
        int currentSum = 0;

        // Step 2 — Initialize maxSum with first element
        // IMPORTANT: not 0, because all numbers could be negative
        int maxSum = nums[0];

        // Step 3 — Loop through every element
        for(int i = 0; i < nums.length; i++) {

            // Step 4 — Add current number to running sum
            currentSum = currentSum + nums[i];

            // Step 5 — Update maxSum if currentSum is better
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }

            // Step 6 — If running sum is negative → reset
            // Starting fresh is better than carrying negative sum
            if(currentSum < 0) {
                currentSum = 0;
            }
        }

        // Step 7 — Return maximum subarray sum found
        return maxSum;
    }
}