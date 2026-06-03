import java.util.Arrays;

// ============================================
// LC #2995 - Minimize the Difference of Ride Times
// Date: June 2, 2026
// Difficulty: Medium
// Topic: Optimization + Greedy Insight
// ============================================
// PROBLEM:
// Tourist must take exactly ONE land ride and ONE water ride
// (in either order). Find minimum time to complete both rides.
//
// APPROACH: Smart Selection - Only Check Promising Combinations
// → Key Insight: The optimal answer ALWAYS includes at least one
//   ride that finishes earliest in its category!
// → So we only need to check:
//   (1) Fastest land ride + all water rides (both orderings)
//   (2) Fastest water ride + all land rides (both orderings)
// → This gives us O(n + m) instead of O(n*m) ✅
//
// WHY THIS WORKS:
// If a land ride is NOT the fastest:
//   - It finishes later than fastest land
//   - To be optimal, water ride must finish MUCH earlier
//   - That water ride would be the fastest water ride!
// So at least one ride in optimal pair must be fastest in its category
//
// Example: landStartTime = [2,8], landDuration = [4,1]
//          waterStartTime = [6], waterDuration = [3]
//
// Fastest land: Land 1 (8→9)
// Fastest water: Water 0 (6→9)
//
// Check:
//   1. Land 1 + Water 0 ✅
//   2. Water 0 + Land 0, 1 ✅
//
// Time Complexity : O(n + m) — One pass through each array
// Space Complexity: O(1)     — Only store min finish time
//
// ============================================

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        
        int minFinishTime = Integer.MAX_VALUE;
        
        // Step 1 — Find the land ride with minimum finish time
        int minLandFinish = Integer.MAX_VALUE;
        int minLandIdx = -1;
        for (int i = 0; i < landStartTime.length; i++) {
            int finish = landStartTime[i] + landDuration[i];
            if (finish < minLandFinish) {
                minLandFinish = finish;
                minLandIdx = i;
            }
        }
        
        // Step 2 — Find the water ride with minimum finish time
        int minWaterFinish = Integer.MAX_VALUE;
        int minWaterIdx = -1;
        for (int j = 0; j < waterStartTime.length; j++) {
            int finish = waterStartTime[j] + waterDuration[j];
            if (finish < minWaterFinish) {
                minWaterFinish = finish;
                minWaterIdx = j;
            }
        }
        
        // Step 3 — Check fastest land + all water rides
        int i = minLandIdx;
        for (int j = 0; j < waterStartTime.length; j++) {
            // Plan A: Land first
            int landFinishA = landStartTime[i] + landDuration[i];
            int waterStartA = Math.max(landFinishA, waterStartTime[j]);
            int finishA = waterStartA + waterDuration[j];
            minFinishTime = Math.min(minFinishTime, finishA);
            
            // Plan B: Water first
            int waterFinishB = waterStartTime[j] + waterDuration[j];
            int landStartB = Math.max(waterFinishB, landStartTime[i]);
            int finishB = landStartB + landDuration[i];
            minFinishTime = Math.min(minFinishTime, finishB);
        }
        
        // Step 4 — Check fastest water + all land rides
        int j = minWaterIdx;
        for (int idx = 0; idx < landStartTime.length; idx++) {
            // Plan A: Land first
            int landFinishA = landStartTime[idx] + landDuration[idx];
            int waterStartA = Math.max(landFinishA, waterStartTime[j]);
            int finishA = waterStartA + waterDuration[j];
            minFinishTime = Math.min(minFinishTime, finishA);
            
            // Plan B: Water first
            int waterFinishB = waterStartTime[j] + waterDuration[j];
            int landStartB = Math.max(waterFinishB, landStartTime[idx]);
            int finishB = landStartB + landDuration[idx];
            minFinishTime = Math.min(minFinishTime, finishB);
        }
        
        return minFinishTime;
    }
}

/*
DRY RUN - Example 1:
landStartTime = [2,8], landDuration = [4,1]
waterStartTime = [6], waterDuration = [3]

Step 1: Find fastest land
  Land 0: 2+4=6
  Land 1: 8+1=9  ← FASTEST
  MinLand = Land 1 (finish=9)

Step 2: Find fastest water
  Water 0: 6+3=9  ← FASTEST
  MinWater = Water 0 (finish=9)

Step 3: Check Land 1 (fastest) + all waters
  Land 1 + Water 0:
    Plan A: 8→9, max(9,6)→9+3=12
    Plan B: 6→9, max(9,8)→9+1=10
    Min: 10

Step 4: Check Water 0 (fastest) + all lands
  Water 0 + Land 0:
    Plan A: 2→6, max(6,6)→6+3=9 ✅
    Plan B: 6→9, max(9,2)→9+4=13
    Min: 9
  
  Water 0 + Land 1:
    Already checked above

Result: min(10, 9) = 9 ✅ (Only 2 checks instead of 4!)

DRY RUN - Failed Test Case:
landStartTime = [31,8], landDuration = [47,64]
waterStartTime = [3,7], waterDuration = [95,44]

Step 1: Find fastest land
  Land 0: 31+47=78
  Land 1: 8+64=72  ← FASTEST
  MinLand = Land 1 (finish=72)

Step 2: Find fastest water
  Water 0: 3+95=98
  Water 1: 7+44=51  ← FASTEST
  MinWater = Water 1 (finish=51)

Step 3: Check Land 1 + all waters
  Land 1 + Water 0:
    Plan A: 8→72, max(72,3)→72+95=167
    Plan B: 3→98, max(98,8)→98+64=162
    Min: 162
  
  Land 1 + Water 1:
    Plan A: 8→72, max(72,7)→72+44=116
    Plan B: 7→51, max(51,8)→51+64=115
    Min: 115

Step 4: Check Water 1 + all lands
  Water 1 + Land 0:
    Plan A: 31→78, max(78,7)→78+44=122
    Plan B: 7→51, max(51,31)→51+47=98 ✅ BEST!
    Min: 98
  
  Water 1 + Land 1:
    Already checked above

Result: min(162, 115, 122, 98) = 98 ✅
(Only 3 land+water checks instead of 4!)
*/
