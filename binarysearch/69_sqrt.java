package binarysearch;

// ============================================
// LC #69 - Sqrt(x)
// Date: June 2, 2026
// Difficulty: Easy
// Topic: Binary Search — Find Exact/Floor Value
// ============================================
// PROBLEM:
// Given an integer x, return the square root of x
// If x is not a perfect square, return floor(sqrt(x))
// WITHOUT using built-in library functions
//
// Example: x = 8 → return 2 (not 2.8...)
//         x = 4 → return 2 (perfect square)
//
// APPROACH: Binary Search with Condition Check
// → Instead of standard comparison, use division
// → Why? To avoid integer overflow
// → Check TWO conditions to ensure accuracy:
//   (1) mid*mid <= x  →  mid * mid == x/mid (divide instead of multiply)
//   (2) (mid+1)*(mid+1) > x  →  (mid+1) > x/(mid+1)
//
// KEY INSIGHT:
// Instead of checking mid² ≤ x
// We check mid ≤ x/mid (avoids overflow for large x)
//
// If both conditions true → mid is the answer!
// - mid is valid (mid² ≤ x)
// - mid+1 is too large ((mid+1)² > x)
// - So mid is the floor of sqrt(x)
//
// Example: x = 8
// Versions: 1, 2, 3, 4, 5, 6, 7, 8
// Valid:    1, 2         (only these when squared ≤ 8)
// Answer:   2 (floor value)
//
// Call 1: start=1, end=8, mid=4
//   4 > 8/4=2 → search left → end=4
// Call 2: start=1, end=4, mid=2
//   2 ≤ 8/2=4 ✓ AND 3 > 8/3=2 ✓ → return 2 ✅
//
// Time Complexity : O(log x) — binary search
// Space Complexity: O(1)     — only variables
//
// ============================================

class Solution {
    public int mySqrt(int x) {
        // Step 1 — Edge case: sqrt(0) = 0
        if (x == 0) return 0;
        
        // Step 2 — Initialize search boundaries
        int start = 1;
        int end = x;
        
        // Step 3 — Binary search for sqrt
        while (start < end) {
            // Step 4 — Safe mid calculation (prevents overflow)
            int mid = start + (end - start) / 2;
            
            // Step 5 — Check if mid is the answer
            // Condition 1: mid² ≤ x → check as mid ≤ x/mid (avoid overflow)
            // Condition 2: (mid+1)² > x → check as (mid+1) > x/(mid+1)
            // If both true → mid is floor(sqrt(x))
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                // Step 6a — Found the result!
                return mid;
            }
            else if (mid > x / mid) {
                // Step 6b — mid is too large
                // sqrt(x) is smaller → search left half
                end = mid;
            }
            else {
                // Step 6c — mid is too small
                // sqrt(x) is larger → search right half
                start = mid + 1;
            }
        }
        
        // Step 7 — Return when start == end
        return start;
    }
}

/*
DRY RUN - Perfect Square:
Input: x = 4

start=1, end=4
Call 1: mid=2
  Check: 2 ≤ 4/2=2 ✓ AND 3 > 4/3=1 ✓
  return 2 ✅

DRY RUN - Non-Perfect Square:
Input: x = 8

start=1, end=8
Call 1: mid=4
  Check: 4 ≤ 8/4=2? NO (4 > 2)
  mid > x/mid → end=4

start=1, end=4
Call 2: mid=2
  Check: 2 ≤ 8/2=4 ✓ AND 3 > 8/3=2 ✓
  return 2 ✅

DRY RUN - Edge Case:
Input: x = 1

start=1, end=1
Loop condition: start < end? NO (1 < 1 is false)
return start = 1 ✅
*/
