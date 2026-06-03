package binarysearch;

// ============================================
// LC #278 - First Bad Version
// Date: June 2, 2026
// Difficulty: Easy
// Topic: Binary Search — Find First Occurrence
// ============================================
// PROBLEM:
// Find the first bad version among [1, 2, ..., n]
// All versions after a bad one are also bad.
// Minimize API calls to isBadVersion()
//
// APPROACH: Modified Binary Search (Find Boundary)
// → Standard BS but with modified right pointer handling
// → If mid is BAD → first bad is at mid or before
//   → Set right = mid (don't exclude it!)
// → If mid is GOOD → first bad is after mid
//   → Set left = mid + 1
// → Loop ends when left == right (found the boundary!)
//
// Example: n=5, bad=4
// Versions: [1✅, 2✅, 3✅, 4❌, 5❌]
// 
// Call 1: mid=3 → isBadVersion(3)=false → left=4
// Call 2: mid=4 → isBadVersion(4)=true → right=4
// Loop ends: left==right==4 → return 4 ✅
//
// Time Complexity : O(log n) — binary search
// Space Complexity: O(1)     — only variables
//
// KEY INSIGHT:
// When mid is bad → DON'T move right to mid-1
// We must check mid itself as it could be the answer!
// ============================================
/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Step 1 — Initialize search boundaries
        int start = 1;
        int end = n;
        
        // Step 2 — Binary search for the first bad version
        while (start < end) {
            
            // Step 3 — Safe mid calculation (prevents integer overflow)
            int mid = start + (end - start) / 2;
            
            if (isBadVersion(mid)) {
                // Step 4a — mid is BAD
                // First bad could be at mid or before
                // DON'T exclude mid → set end = mid
                end = mid;
            } 
            else {
                // Step 4b — mid is GOOD
                // First bad is after mid
                // Move start forward, past mid
                start = mid + 1;
            }
        }
        
        // Step 5 — Loop ends when start == end
        // This is the first bad version
        return start;
    }
}
