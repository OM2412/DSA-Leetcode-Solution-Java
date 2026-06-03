// ============================================
// LC #704 - Binary Search
// Date: June 1, 2026
// Difficulty: Easy
// Topic: Binary Search
// ============================================
// PROBLEM:
// Given a sorted array nums and a target value,
// return the index of target. If not found return -1.
//
// APPROACH: Standard Binary Search
// → Maintain two pointers: start and end
// → Find middle element each iteration
// → If mid == target → found, return index
// → If mid < target  → target is in RIGHT half → move start up
// → If mid > target  → target is in LEFT half  → move end down
// → Repeat until start > end (search space exhausted)
//
// Time Complexity : O(log n) — half the search space each step
// Space Complexity: O(1)     — only 3 variables used
//
// WHY (end - start)/2 and not (start + end)/2?
// → (start + end) can cause INTEGER OVERFLOW for large arrays
// → start + (end - start)/2 is always safe ✅
//
// DRY RUN:
// nums = [-1, 0, 3, 5, 9, 12]  target = 9
//
// start=0, end=5
// mid = 0+(5-0)/2 = 2 → nums[2]=3 < 9  → start = 3
//
// start=3, end=5
// mid = 3+(5-3)/2 = 4 → nums[4]=9 == 9 → return 4 ✅
// ============================================
package binarysearch;
class Solution {
    public int search(int[] nums, int target) {

        // Step 1 — Initialize start pointer at beginning of array
        int start = 0;

        // Step 2 — Initialize end pointer at last index of array
        int end = nums.length - 1;

        // Step 3 — Keep searching while search space is valid
        // When start > end → entire array checked → stop
        while(start <= end) {

            // Step 4 — Find middle index safely
            // Using start + (end-start)/2 to prevent integer overflow
            int mid = start + (end - start) / 2;

            if(nums[mid] < target) {
                // Step 5a — Target is LARGER than mid element
                // → Target must be in RIGHT half
                // → Discard left half by moving start past mid
                start = mid + 1;

            } else if(nums[mid] > target) {
                // Step 5b — Target is SMALLER than mid element
                // → Target must be in LEFT half
                // → Discard right half by moving end before mid
                end = mid - 1;

            } else {
                // Step 5c — nums[mid] == target → FOUND!
                // → Return the index directly
                return mid;
            }
        }

        // Step 6 — Search space exhausted, target not in array
        return -1;
    }
}