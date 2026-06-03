/* A perfect square is an integer x such that x * x == num.
Instead of checking every number up to num, we can use binary search to efficiently find if such an x exists.

📝 Approach
Initialize two pointers: beg = 1 and end = num.
While beg <= end:
Compute mid = beg + (end - beg)/2.
If mid * mid == num, return true.
If mid * mid > num, move end = mid - 1.
Else, move beg = mid + 1.
If no mid satisfies mid * mid == num, return false.
Use long for mid and mid * mid to avoid integer overflow.
⏱️ Complexity
Time complexity: O(logn) — binary search halves the search space at each step.
Space complexity: O(1) — only a few variables are used; no extra data structures. */
class Solution {
    public boolean isPerfectSquare(int num) {
        long start=1;
        long end=num;
        while(start<=end){
            long mid=start+(end-start)/2;
            
            if( mid*mid==num){
                return true;
            }else if(mid*mid<num){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
 return false;   }
}