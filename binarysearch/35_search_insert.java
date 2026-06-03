// ============================================
// LC #35 - Search Insert Position
// Date: June 2, 2026
// Difficulty: Easy
// Topic: Binary Search — Modified
// ============================================
// PROBLEM:
// Given sorted array and target — return index if found.
// If not found — return index where it WOULD be inserted
// to keep array sorted.
//
// APPROACH: Modified Binary Search
// → Standard BS template with one key change
// → If target found → return mid (same as normal BS)
// → If target NOT found → return START pointer
// → WHY start? Because when loop ends:
//   start > end means start is pointing to
//   the exact position where target should be inserted
//
// Time Complexity : O(log n) — binary search
// Space Complexity: O(1)     — only variables
//
// KEY INSIGHT:
// When target not found → start always lands on
// the first element GREATER than target
// = the correct insert position ✅
//
// DRY RUN — target found:
// nums = [1, 3, 5, 6]  target = 5
// start=0, end=3
// mid=1 → nums[1]=3 < 5 → start=2
// mid=2 → nums[2]=5 == 5 → return 2 ✅
//
// DRY RUN — target NOT found:
// nums = [1, 3, 5, 6]  target = 2
// start=0, end=3
// mid=1 → nums[1]=3 > 2 → end=0
// mid=0 → nums[0]=1 < 2 → start=1
// start(1) > end(0) → loop ends
// return start = 1 ✅ (2 would go between 1 and 3)
// ============================================
package binarysearch;
class Solution {
    public int searchInsert(int[] nums, int target) {

        // Step 1 — Initialize search space
        int start = 0;
        int end = nums.length - 1;

        // Step 2 — Standard binary search loop
        while(start <= end) {

            // Step 3 — Safe mid calculation (prevents overflow)
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                // Step 4a — Exact match found → return index
                return mid;

            } else if(nums[mid] < target) {
                // Step 4b — Target is LARGER → search right half
                start = mid + 1;

            } else {
                // Step 4c — Target is SMALLER → search left half
                end = mid - 1;
            }
        }

        // Step 5 — Target not found
        // 'start' now points to correct insert position
        // This is the first element greater than target
        return start;
    }
}