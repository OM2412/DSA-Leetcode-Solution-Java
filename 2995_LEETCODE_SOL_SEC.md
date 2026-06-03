# LeetCode #2995 - Earliest Finish Time | Structured Solution 🎢

## **1️⃣ Problem Understanding**
- Tourist must ride: **1 land ride + 1 water ride** (any order)
- Each ride has: opening time & duration
- Can start anytime ≥ opening time
- Find: **earliest possible finish time**

---

## **2️⃣ Key Observations**
| Aspect | Details |
|--------|---------|
| **Order matters** | Different sequences = different wait times |
| **Two orderings** | Land→Water OR Water→Land |
| **Max function** | `max(finish, nextOpen)` handles waiting |
| **Compare both** | Pick the ordering that finishes earlier |

---

## **3️⃣ Algorithm Strategy**

```
FOR each land ride (i):
  FOR each water ride (j):
    
    PLAN A: Land First, then Water
    ├─ landFinish = landStart[i] + landDuration[i]
    ├─ waterStart = max(landFinish, waterStart[j])
    └─ totalTime = waterStart + waterDuration[j]
    
    PLAN B: Water First, then Land
    ├─ waterFinish = waterStart[j] + waterDuration[j]
    ├─ landStart = max(waterFinish, landStart[i])
    └─ totalTime = landStart + landDuration[i]
    
    Track minimum of both plans

RETURN overall minimum
```

---

## **4️⃣ Step-by-Step Execution**

### **Example:**
```
landStartTime = [2,8], landDuration = [4,1]
waterStartTime = [6], waterDuration = [3]
```

### **Combination 1: Land 0 + Water 0**
```
Land 0: opens at 2, lasts 4 hours
├─ Starts: 2
└─ Finishes: 2 + 4 = 6

Plan A (Land→Water):
├─ Land finishes: 6
├─ Water opens: 6
├─ Water starts: max(6, 6) = 6
└─ Water finishes: 6 + 3 = 9 ✅

Plan B (Water→Land):
├─ Water finishes: 6 + 3 = 9
├─ Land opens: 2
├─ Land starts: max(9, 2) = 9
└─ Land finishes: 9 + 4 = 13

Min for this combo: 9
```

### **Combination 2: Land 1 + Water 0**
```
Land 1: opens at 8, lasts 1 hour
├─ Starts: 8
└─ Finishes: 8 + 1 = 9

Plan A (Land→Water):
├─ Land finishes: 9
├─ Water starts: max(9, 6) = 9
└─ Water finishes: 9 + 3 = 12

Plan B (Water→Land):
├─ Water finishes: 9
├─ Land starts: max(9, 8) = 9
└─ Land finishes: 9 + 1 = 10

Min for this combo: 10
```

### **Final Answer:**
```
min(9, 10) = 9 ✅
```

---

## **5️⃣ Complete Code**

```java
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        
        int minFinishTime = Integer.MAX_VALUE;
        
        // Step 1: Iterate all land rides
        for (int i = 0; i < landStartTime.length; i++) {
            
            // Step 2: Iterate all water rides
            for (int j = 0; j < waterStartTime.length; j++) {
                
                // Step 3a: Plan A - Land first, then water
                int landFinishA = landStartTime[i] + landDuration[i];
                int waterStartA = Math.max(landFinishA, waterStartTime[j]);
                int finishA = waterStartA + waterDuration[j];
                
                // Step 3b: Plan B - Water first, then land
                int waterFinishB = waterStartTime[j] + waterDuration[j];
                int landStartB = Math.max(waterFinishB, landStartTime[i]);
                int finishB = landStartB + landDuration[i];
                
                // Step 4: Update minimum
                minFinishTime = Math.min(minFinishTime, 
                                        Math.min(finishA, finishB));
            }
        }
        
        // Step 5: Return result
        return minFinishTime;
    }
}
```

---

## **6️⃣ Complexity Analysis**

| Metric | Value | Explanation |
|--------|-------|-------------|
| **Time** | O(n × m) | Nested loops: n lands × m waters |
| **Space** | O(1) | Only one variable tracked |
| **Worst case** | 100 × 100 = 10k ops | Negligible |

---

## **7️⃣ Visual Flow**

```
┌─────────────────────────────────────┐
│  Check ALL Land × Water Combos      │
├─────────────────────────────────────┤
│                                     │
│  For Each Combination:              │
│  ├─ Plan A: Land → Water            │
│  │  └─ Calculate finish time        │
│  │                                  │
│  ├─ Plan B: Water → Land            │
│  │  └─ Calculate finish time        │
│  │                                  │
│  └─ Update minimum                  │
│                                     │
└─────────────────────────────────────┘
         ↓
    Return min
```

---

## **8️⃣ Edge Cases Handled**

| Case | Handling |
|------|----------|
| **One of each ride** | Both combos checked |
| **No waiting** | `max()` handles immediately |
| **Long wait** | `max()` waits for opening |
| **Multiple options** | All are compared |

---

## **9️⃣ Why This Works**

✅ **Complete:** Checks every possibility  
✅ **Correct:** Compares both orderings  
✅ **Efficient:** Direct calculation, no sorting  
✅ **Simple:** Easy to understand and debug  

---

## **Key Takeaways**
- Order of rides significantly impacts total time
- Always check both orderings for each combination
- The `Math.max()` function elegantly handles wait times
- This solution guarantees finding the optimal answer
