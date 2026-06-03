// ============================================
// LC #217 - Contains Duplicate
// Date: June 1, 2026
// Difficulty: Easy
// Topic: Arrays
// ============================================
// PROBLEM:
// Return true if any value appears at least twice.
// Return false if all elements are distinct.
//
// APPROACH: Sort then Compare Adjacent
// → Sort array — duplicates become neighbours
// → Check if any adjacent pair is equal
// → If yes → duplicate found
//
// Time Complexity : O(n log n) — Arrays.sort()
// Space Complexity: O(1)       — no extra memory
//
// TODO: Optimize with HashSet → O(n) time after learning Sets
//
// DRY RUN:
// nums = [1,2,3,1]
// After sort → [1,1,2,3]
// i=0 → nums[0]==nums[1] → 1==1 → true ✅
// ============================================

import java.util.Arrays;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        // Step 1 — Sort array so duplicates become adjacent
        Arrays.sort(nums);

        // Step 2 — Check every adjacent pair
        // Stop at length-1 because we access nums[i+1]
        for(int i = 0; i < nums.length - 1; i++) {

            // Step 3 — If two adjacent elements are equal → duplicate found
            if(nums[i] == nums[i + 1]) {
                return true;
            }
        }

        // Step 4 — No duplicates found
        return false;
    }
}