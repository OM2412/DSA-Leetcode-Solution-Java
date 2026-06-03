// ============================================
// LC #283 - Move Zeroes
// Date: June 1, 2026
// Difficulty: Easy
// Topic: Arrays — Two Pointer
// ============================================
// PROBLEM:
// Move all 0s to end while maintaining
// relative order of non-zero elements.
// Must do it in-place (no extra array).
//
// APPROACH: Two Pointer
// → pointer1 tracks where next non-zero should go
// → i scans the entire array
// → When non-zero found → swap with pointer1 position
// → pointer1 moves forward after each swap
//
// Time Complexity : O(n) — single loop
// Space Complexity: O(1) — in-place, no extra array
//
// DRY RUN:
// nums = [0,1,0,3,12]
// p1=0
// i=0 → nums[0]=0  → skip
// i=1 → nums[1]=1  → swap(0,1) → [1,0,0,3,12], p1=1
// i=2 → nums[2]=0  → skip
// i=3 → nums[3]=3  → swap(1,3) → [1,3,0,0,12], p1=2
// i=4 → nums[4]=12 → swap(2,4) → [1,3,12,0,0] ✅
// ============================================

class MoveZeroes {
    public void moveZeroes(int[] nums) {

        // Step 1 — pointer1 points to position where
        // next non-zero element should be placed
        int pointer1 = 0;

        // Step 2 — Scan entire array with i
        for(int i = 0; i < nums.length; i++) {

            // Step 3 — When non-zero element found
            if(nums[i] != 0) {

                // Step 4 — Swap current element with pointer1 position
                // This pushes non-zero to front, zero drifts back
                int temp = nums[pointer1];
                nums[pointer1] = nums[i];
                nums[i] = temp;

                // Step 5 — Move pointer1 forward
                pointer1++;
            }
            // If nums[i] == 0 → do nothing → i moves forward
            // pointer1 stays → next non-zero will fill this gap
        }
    }
}