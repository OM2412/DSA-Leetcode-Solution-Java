# LeetCode 374: Guess Number Higher or Lower ✅

## Intuition
Instead of guessing numbers sequentially from 1 to n (which could take forever!), we can be **smart** about it. Think of it like finding a name in a dictionary:
- Don't flip pages one by one
- Jump to the middle and see if you need to go left or right
- Keep narrowing down the range until you find it

This is **Binary Search** - we eliminate half the remaining numbers with each guess! 🎯

---

## Approach

### The Strategy:
1. **Start** with `start = 1` and `end = n` (full range)
2. **Calculate middle**: `mid = start + (end - start) / 2`
   - Why `start + (end - start) / 2`? To avoid integer overflow!
3. **Call guess(mid)** and get feedback:
   - If `result == 0` → Found it! ✅ Return `mid`
   - If `result == -1` → Your guess is too high, search **LEFT** (lower numbers)
     - Move `end = mid - 1`
   - If `result == 1` → Your guess is too low, search **RIGHT** (higher numbers)
     - Move `start = mid + 1`
4. **Repeat** until you find the number

### Example Walkthrough (n=10, pick=6):
```
Step 1: start=1, end=10 → mid=5 → guess(5) → result=1 (too low)
Step 2: start=6, end=10 → mid=8 → guess(8) → result=-1 (too high)
Step 3: start=6, end=7 → mid=6 → guess(6) → result=0 ✅ Found!
```

---

## Complexity

- **Time Complexity**: $$O(\log n)$$
  - Each guess eliminates half the numbers
  - Maximum guesses for n = 2³¹-1 is only 31! 🚀
  
- **Space Complexity**: $$O(1)$$
  - Only using a few variables (start, end, mid)
  - No extra data structures needed

---

## Code

```java
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        
        while (start <= end) {
            // Calculate middle (avoids overflow)
            int mid = start + (end - start) / 2;
            
            // Get feedback from the guess API
            int result = guess(mid);
            
            if (result == 0) {
                return mid;  // Correct guess!
            } else if (result == -1) {
                // Guess is too high, search lower
                end = mid - 1;
            } else {
                // Guess is too low, search higher
                start = mid + 1;
            }
        }
        
        return start;
    }
}
```

---

## Key Learning Points ⭐

| Concept | Explanation |
|---------|-------------|
| **Binary Search** | Divide & conquer: eliminate half the numbers each time |
| **Why not linear?** | Linear search O(n) = billions of guesses; Binary search O(log n) = ~31 guesses max! |
| **Mid calculation** | Use `start + (end - start) / 2` to avoid integer overflow |
| **When to move left/right** | `result == -1` → go LEFT (end=mid-1); `result == 1` → go RIGHT (start=mid+1) |
| **Loop condition** | `while(start <= end)` keeps searching until range is exhausted |

---

## Why This Solution is Optimal 🏆

✅ **Beats 100%** - Most efficient approach possible  
✅ **O(log n) time** - Scales beautifully even for huge numbers  
✅ **O(1) space** - No extra memory needed  
✅ **One guess at a time** - Uses the guess API efficiently  

