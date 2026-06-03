# LeetCode 367: Valid Perfect Square ✅

## Intuition
We need to find if some integer `x` exists where `x * x = num`. Instead of checking every number from 1 to num (too slow!), we can use **Binary Search** to efficiently narrow down the candidates.

Think of it like guessing a number in a game:
- If we guess `mid`, calculate `mid * mid`
- If `mid * mid == num` → Found it! ✅
- If `mid * mid > num` → We guessed too high, search lower
- If `mid * mid < num` → We guessed too low, search higher

This eliminates half the possibilities with each guess! 🎯

---

## Approach

### The Strategy:
1. **Initialize** `start = 1` and `end = num` (search range)
2. **While loop** continues as long as `start <= end`
3. **Calculate middle**: `mid = start + (end - start) / 2`
4. **Calculate square**: `square = mid * mid`
5. **Check three cases**:
   - If `square == num` → Perfect match! Return `true`
   - If `square > num` → Too high, search LEFT with `end = mid - 1`
   - If `square < num` → Too low, search RIGHT with `start = mid + 1`
6. **Exit loop** → No integer found, return `false`

### Example Walkthrough (num=16):
```
Step 1: start=1, end=16 → mid=8 → 8*8=64 > 16 → search left
Step 2: start=1, end=7 → mid=4 → 4*4=16 ✅ FOUND!
Return: true
```

### Example Walkthrough (num=14):
```
Step 1: start=1, end=14 → mid=7 → 7*7=49 > 14 → search left
Step 2: start=1, end=6 → mid=3 → 3*3=9 < 14 → search right
Step 3: start=4, end=6 → mid=5 → 5*5=25 > 14 → search left
Step 4: start=4, end=4 → mid=4 → 4*4=16 > 14 → search left
Step 5: start=4, end=3 → Loop exits (start > end)
Return: false (no perfect square found)
```

---

## Complexity

- **Time Complexity**: $$O(\log n)$$
  - Binary search: halves the search space each time
  - Maximum iterations ≈ log₂(n)
  - For num = 2³¹-1, only ~31 iterations needed! 🚀
  
- **Space Complexity**: $$O(1)$$
  - Only using a few variables (start, end, mid, square)
  - No extra data structures needed

---

## Code

```java
class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        
        while (start <= end) {
            // Calculate middle (avoids overflow)
            int mid = start + (end - start) / 2;
            
            // Calculate square
            long square = (long) mid * mid;
            
            if (square == num) {
                return true;  // Perfect square found!
            } else if (square > num) {
                // Square is too big, search lower
                end = mid - 1;
            } else {
                // Square is too small, search higher
                start = mid + 1;
            }
        }
        
        return false;  // No perfect square found
    }
}
```

---

## Important Detail ⚠️

**Why `long square = (long) mid * mid;`?**
- `int` can overflow! For example: `46341 * 46341` exceeds max int value
- Casting to `long` prevents overflow and ensures correct comparison
- The `num` parameter is `int`, but our intermediate calculation needs to be `long`

---

## Key Learning Points ⭐

| Concept | Explanation |
|---------|-------------|
| **Binary Search** | Divide & conquer: eliminate half the range each time |
| **Perfect Square** | An integer x where x * x = num (e.g., 4*4=16, 7*7=49) |
| **Why not loop?** | Linear search O(n) = slow; Binary search O(log n) = fast! |
| **Overflow prevention** | Use `long` for intermediate calculations with large numbers |
| **Mid calculation** | Use `start + (end - start) / 2` to avoid overflow |
| **Three outcomes** | Equal (return true), greater (search left), less (search right) |

---

## Comparison with Other Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| **Linear Search** | O(n) | O(1) | Slow - checks 1,2,3... up to n |
| **Binary Search** ⭐ | O(log n) | O(1) | Fast - halves range each time |
| `Math.sqrt()` | O(1) | O(1) | Not allowed per problem constraints |

---

## Why This Solution is Optimal 🏆

✅ **No built-in functions** - Uses only math and logic  
✅ **O(log n) time** - Extremely efficient for large numbers  
✅ **O(1) space** - No extra memory used  
✅ **Overflow-safe** - Handles edge cases with `long` casting  
✅ **Clean & readable** - Easy to understand and debug  

